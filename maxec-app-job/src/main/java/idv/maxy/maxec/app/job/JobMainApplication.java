package idv.maxy.maxec.app.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author Max Chen
 *
 */
@SpringBootApplication
public class JobMainApplication {
	public static void main(String[] args) {
		SpringApplication.run(JobMainApplication.class, args);
	}
}
