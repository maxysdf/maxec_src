package idv.maxy.maxec.app.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author Max Chen
 *
 */
@SpringBootApplication
@ComponentScan(basePackages= {
	"idv.maxy.maxec.app.frontend",
	"idv.maxy.maxec.biz.product.service",
	"idv.maxy.maxec.biz.search.service"
})
@EnableJpaRepositories(basePackages= {
	"idv.maxy.maxec.biz.product"
})
@EnableElasticsearchRepositories(basePackages = {
	"idv.maxy.maxec.biz.search"
})
@EntityScan(basePackages= { "idv.maxy.maxec.biz.product.model" })
public class FrontendMainApplication {
	public static void main(String[] args) {
		SpringApplication.run(FrontendMainApplication.class, args);
	}
}
