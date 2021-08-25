package idv.maxy.maxec.app.frontend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.Logger;
import feign.slf4j.Slf4jLogger;
import idv.maxy.maxec.biz.product.restapi.ProductRestAPI;
import idv.maxy.maxec.biz.search.restapi.SearchRestAPI;

@Configuration
public class FeignConfiguration {

//	@Value("${app.api.product.endpoint}")
//	private String productApiEndpoint;
//	
//	@Value("${app.api.search.endpoint}")
//	private String searchApiEndpoint;
//	
//	@Bean
//	public ProductRestAPI productApi() { return api(ProductRestAPI.class, productApiEndpoint); }
//	
//	@Bean
//	public SearchRestAPI searchApi() { return api(SearchRestAPI.class, searchApiEndpoint); }
//	
//	
//	private <T> T api(Class<T> cls, String endpoint) {
//		return Feign.builder()
//		  .client(new ApacheHttpClient())
//		  .encoder(new GsonEncoder())
//		  .decoder(new GsonDecoder())
//		  .logger(new Slf4jLogger(ProductRestAPI.class))
//		  .logLevel(Logger.Level.FULL)
//		  .target(cls, endpoint);
//	}
}
