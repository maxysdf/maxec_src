package idv.maxy.maxec.app.backend;

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
public class BackendMainApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendMainApplication.class, args);
	}
}
