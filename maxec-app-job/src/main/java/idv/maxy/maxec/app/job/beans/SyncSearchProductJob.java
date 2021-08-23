package idv.maxy.maxec.app.job.beans;

import static idv.maxy.maxec.app.job.config.JobSettings.CRON_SYNC_PRODUCT_SEARCH;
import static idv.maxy.maxec.app.job.config.JobSettings.PREFIX_SYNC_PRODUCT_SEARCH;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.stereotype.Component;

import idv.maxy.maxec.biz.product.service.ProductService;
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.biz.search.model.SearchProduct;
import idv.maxy.maxec.biz.search.service.SearchService;

@Component
@DisallowConcurrentExecution
public class SyncSearchProductJob extends BaseJobBean {
	private static final long serialVersionUID = -1123825249614736901L;
	private static Logger logger = LoggerFactory.getLogger(SyncSearchProductJob.class);
	
    @Bean(name=PREFIX_SYNC_PRODUCT_SEARCH+"BeanTrigger")
    public CronTriggerFactoryBean sampleJobTrigger(@Qualifier(PREFIX_SYNC_PRODUCT_SEARCH+"Bean") JobDetail jobDetail) {
    	return trigger(jobDetail, CRON_SYNC_PRODUCT_SEARCH);
    }

    @Bean(name=PREFIX_SYNC_PRODUCT_SEARCH+"Bean")
    public JobDetailFactoryBean sampleJobDetail() {
    	return jobDetail(SyncSearchProductJob.class);
    }
	
    @Autowired
    private ProductService productService;
    
    @Autowired
    private SearchService searchService;
    
    
	@Override
	protected void executeJob(JobExecutionContext context, List<String> errMsgs) {
		try {
			logger.info("executed at " + new Date());
			
			long now = System.currentTimeMillis();
			
			// find all product
			List<ProductVO> list = productService.findAll();
			
			
			List<SearchProduct> slist = new ArrayList<>();
			
			for(ProductVO v : list) {
				SearchProduct sp = new SearchProduct();
				sp.setId(v.getId());
				sp.setName(v.getName());
				sp.setDescription(v.getDescription());
				sp.setBrief(v.getBrief());
				sp.setPrice(v.getPrice());
				sp.setRating(v.getRating());
				sp.setSku(v.getSku());
				sp.setWeight(v.getWeight());
				sp.setSaleAmount(v.getSaleAmount());
				sp.setSaleDate(v.getSaleDate());
				sp.setTimestamp(now);
				
				// brand
				
				
				slist.add(sp);
			}
			
			// update search product
			searchService.saveAllSearchProduct(slist, now);
			
			
		} catch(Exception ex) {
			logger.error("failed", ex);
		}
	}
}
