package idv.maxy.maxec.app.job.config;

/**
 * 
 * @author Max Chen
 *
 */
public class JobSettings {
	/** 前綴 - simple */ 
	public static final String PREFIX_SIMPLE = "simpleJob";
	/** 排程 - simple */ 
	public static final String CRON_SIMPLE = "0 * * * * ?";
	
	/** 前綴 - SyncProductSearch */ 
	public static final String PREFIX_SYNC_PRODUCT_SEARCH = "syncProductSearch";
	/** 排程 - SyncProductSearch */ 
	public static final String CRON_SYNC_PRODUCT_SEARCH = "0 0/10 * * * ?";
}
