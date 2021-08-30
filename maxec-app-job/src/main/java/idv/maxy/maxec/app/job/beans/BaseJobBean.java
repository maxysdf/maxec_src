package idv.maxy.maxec.app.job.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 基礎的 QuartzJob類別，實作Quartz Job程式時需要繼承此類別。 <br/>
 *
 * @author Johnny.Lin
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class BaseJobBean extends QuartzJobBean implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7857289474043406267L;

    /**
     * Logger for this class
     */
    private final static Logger logger = LoggerFactory.getLogger(BaseJobBean.class);

    /**
     * JPA的entityManagerFactory物件。
     */
    @Autowired
    protected EntityManagerFactory entityManagerFactory = null;

    /**
     * JPA的EntityManager物件。
     */
    protected EntityManager entityManager = null;

    /**
     * QuartzJobBean定義的Qaurtz Job程式進入點。<br />
     *
     * @param ctx
     *            Quartz Framework的Context物件。
     * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
     */
    @Override
    protected void executeInternal(JobExecutionContext ctx) throws JobExecutionException {
        List<String> errorMessages = new ArrayList<String>();

        boolean isBound = false;
        try {
            entityManager = this.entityManagerFactory.createEntityManager();

            if (entityManager == null) {
                logger.warn("entityManager == null");
            } else {
                TransactionSynchronizationManager.bindResource(entityManagerFactory,
                        new EntityManagerHolder(entityManager));

                isBound = true;

                MDC.put("jobId", ctx.getJobDetail().getKey().getName());
                try {
                	// 執行Job工作，由各Job實作
                    this.executeJob(ctx, errorMessages);
                } finally {
                	MDC.remove("jobId");
                }
            }
        } catch (Exception ex) {
            logger.error("executeInternal(JobExecutionContext) - exception: ", ex);
            errorMessages.add(ex.getMessage());
        } finally {
            if (isBound) {
                TransactionSynchronizationManager.unbindResource(entityManagerFactory);
            }

            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    /**
     * Batch Job執行工作的進入點。
     *
     * @param ctx Quartz Framework的Context物件。
     * @param errorMessages job執行時記錄錯誤訊息的列表物件。
     */
    protected abstract void executeJob(JobExecutionContext ctx, List<String> errorMessages);

    /**
     * 判斷指定的jobs是否正在執行。<br />
     * p.s. 此方法是用來判斷若JobB或JobC是否正在執行，藉由幫忙判斷正在執行的JobA要不要繼續做下去，
     * 若只是要判斷JobA自己有無執行，用@DisallowConcurrentExecution的annotation就可以了。
     *
     * @param ctx Quartz Framework的Context物件。
     * @param jobNameList 欲判斷的job名稱列表。
     * @return 若正在執行回傳true；反之回傳false。
     */
    protected boolean isInCurrentlyExecutingJobs(JobExecutionContext ctx, List<String> jobNameList) {
        boolean result = false;

        try {
            List<JobExecutionContext> jobsList = ctx.getScheduler().getCurrentlyExecutingJobs();

            for (JobExecutionContext context : jobsList) {
                if ((context != null) && (context.getJobDetail() != null)
                        && (context.getJobDetail().getKey() != null)) {
                    String currentJobName = context.getJobDetail().getKey().getName();
                    logger.debug("currentJobName = " + currentJobName);
                    if ((currentJobName != null) && (jobNameList != null) && (jobNameList.contains(currentJobName))) {
                        result = true;
                        break;
                    }
                }
            } // end of for loop
        } catch (SchedulerException ex) {
            logger.error("isInCurrentlyExecutingJobs() - exception: ", ex);
        }

        logger.info("result = " + result);
        return result;
    }

    /**
     * 設定Job Trigger的Cron Expression。
     *
     * @param ctx Quartz Framework的Context物件。
     * @param triggerName 欲設定的Job Trigger名稱。
     * @param newCronExpression 欲設定的Cron Expression。
     * @throws Exception 有任何錯誤時拋出。
     */
    protected void updateJobCronExpression(JobExecutionContext ctx, String triggerName, String newCronExpression)
            throws Exception {

        Scheduler scheduler = ctx.getScheduler();
        updateJobCronExpression(scheduler, triggerName, newCronExpression);
    }

    /**
     * 設定Job Trigger的Cron Expression。
     *
     * @param schedulerFactoryBean Quartz Framework的SchedulerFactoryBean物件。
     * @param triggerName 欲設定的Job Trigger名稱。
     * @param newCronExpression 欲設定的Cron Expression。
     * @throws Exception 有任何錯誤時拋出。
     */
    public static void updateJobCronExpression(SchedulerFactoryBean schedulerFactoryBean, String triggerName,
            String newCronExpression) throws Exception {

        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        updateJobCronExpression(scheduler, triggerName, newCronExpression);
    }

    /**
     * 設定Job Trigger的Cron Expression。
     *
     * @param scheduler Quartz Framework的Scheduler物件。
     * @param triggerName 欲設定的Job Trigger名稱。
     * @param newCronExpression 欲設定的Cron Expression。
     * @throws Exception 有任何錯誤時拋出。
     */
    public static void updateJobCronExpression(Scheduler scheduler, String triggerName, String newCronExpression)
            throws Exception {
        logger.info("updateJobCronExpression() - start");
        logger.info(String.format("triggerName=%s", triggerName));
        logger.info(String.format("newCronExpression=%s", newCronExpression));

        TriggerKey triggerKey = new TriggerKey(triggerName);
        CronTriggerImpl trigger = (CronTriggerImpl) scheduler.getTrigger(triggerKey);

        if (trigger == null) {
            throw new RuntimeException(triggerName + "not found");
        } else {
            trigger.setCronExpression(newCronExpression);
            scheduler.rescheduleJob(triggerKey, trigger);
        }

        logger.info("updateJobCronExpression() - end");
    }
    
    
    
    protected CronTriggerFactoryBean trigger(JobDetail jobDetail, String cronExpr) {
    	CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
		factoryBean.setJobDetail(jobDetail);
		factoryBean.setCronExpression(cronExpr);
		factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
		return factoryBean;
    }
    
    protected JobDetailFactoryBean jobDetail(Class<? extends Job> jobClass) {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
		factoryBean.setJobClass(jobClass);
		factoryBean.setDurability(true);
		return factoryBean;
    }

}
