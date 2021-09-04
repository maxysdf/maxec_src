package idv.maxy.maxec.app.job.config;

import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JobConfiguration {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Value("${app.job.delegateClass:#{null}}")
    private String delegateClass;
    
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(
			JobFactory quartzJobFactory, 
			@Qualifier("dataSource") DataSource dataSource, 
			PlatformTransactionManager transactionManager,
			List<Trigger> triggers) throws Exception {
		SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        factoryBean.setJobFactory(quartzJobFactory);

        Properties props = new Properties();

        factoryBean.setQuartzProperties(props);

        props.setProperty("org.quartz.scheduler.instanceName"         , "scheduler"                                   );
        props.setProperty("org.quartz.scheduler.instanceId"           , "AUTO"                                        );
        props.setProperty("org.quartz.jobStore.class"                 , "org.quartz.impl.jdbcjobstore.JobStoreTX"     );
        props.setProperty("org.quartz.jobStore.driverDelegateClass"   , "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
        props.setProperty("org.quartz.jobStore.tablePrefix"           , "QRTZ_"                                       );
        props.setProperty("org.quartz.jobStore.isClustered"           , "true"                                        );
        props.setProperty("org.quartz.jobStore.useProperties"         , "false"                                       );
        props.setProperty("org.quartz.jobStore.clusterCheckinInterval", "5000"                                        );
        props.setProperty("org.quartz.scheduler.skipUpdateCheck"      , "true"                                        );
        props.setProperty("org.quartz.threadPool.class"               , "org.quartz.simpl.SimpleThreadPool"           );
        props.setProperty("org.quartz.threadPool.threadCount"         , "10"                                          );
        props.setProperty("org.quartz.threadPool.threadPriority"      , "5"                                           );
        props.setProperty("org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread", "true"        );
        
        if(delegateClass != null) {
        	props.setProperty("org.quartz.jobStore.driverDelegateClass", delegateClass );	
        }
        

        //factoryBean.setConfigLocation(new ClassPathResource("quartz.properties"));
        factoryBean.setDataSource(dataSource);
        factoryBean.setTransactionManager(platformTransactionManager);
        factoryBean.afterPropertiesSet();
        factoryBean.setTriggers(triggers.toArray(new Trigger[triggers.size()]));

        return factoryBean;
	}

	@Bean
    public Scheduler scheduler(SchedulerFactoryBean schedulerFactoryBean) throws Exception {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.start();
        return scheduler;
    }
	
}