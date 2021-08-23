package idv.maxy.maxec.app.job;

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
	"idv.maxy.maxec.app.job",
	"idv.maxy.maxec.biz.product.service",
	"idv.maxy.maxec.biz.search.service",
})
@EntityScan({"idv.maxy.maxec.biz.product.model"})
@EnableJpaRepositories(basePackages= {
	"idv.maxy.maxec.biz.product"
})
@EnableElasticsearchRepositories(basePackages = {
	"idv.maxy.maxec.biz.search"
})
public class JobMainApplication {
	public static void main(String[] args) {
		SpringApplication.run(JobMainApplication.class, args);
	}
}
