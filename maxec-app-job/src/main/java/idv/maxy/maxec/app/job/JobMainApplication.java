package idv.maxy.maxec.app.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * @author Max Chen
 *
 */
@SpringBootApplication
@EnableFeignClients
public class JobMainApplication {
	public static void main(String[] args) {
		SpringApplication.run(JobMainApplication.class, args);
	}
}
