package idv.maxy.maxec.app.job.beans;

import static idv.maxy.maxec.app.job.config.JobSettings.CRON_SIMPLE;
import static idv.maxy.maxec.app.job.config.JobSettings.PREFIX_SIMPLE;

import java.util.Date;
import java.util.List;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

@Component
@DisallowConcurrentExecution
public class SimpleJob extends BaseJobBean {
	private static final long serialVersionUID = -1123825249614736901L;
	private static Logger logger = LoggerFactory.getLogger(SimpleJob.class);
	
    @Bean(name=PREFIX_SIMPLE+"BeanTrigger")
    public CronTriggerFactoryBean sampleJobTrigger(@Qualifier(PREFIX_SIMPLE+"Bean") JobDetail jobDetail) {
    	return trigger(jobDetail, CRON_SIMPLE);
    }

    @Bean(name=PREFIX_SIMPLE+"Bean")
    public JobDetailFactoryBean sampleJobDetail() {
    	return jobDetail(SimpleJob.class);
    }
	
	@Override
	protected void executeJob(JobExecutionContext context, List<String> errMsgs) {
		try {
			logger.info("executed at " + new Date());
			
		} catch(Exception ex) {
			logger.error("failed", ex);
		}
	}
}
