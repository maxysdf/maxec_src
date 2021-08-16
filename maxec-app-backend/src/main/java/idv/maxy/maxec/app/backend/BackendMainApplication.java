package idv.maxy.maxec.app.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Max Chen
 *
 */
@SpringBootApplication
@ComponentScan(basePackages= {
	"idv.maxy.maxec.app.backend",
	"idv.maxy.maxec.biz.product"
})
public class BackendMainApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendMainApplication.class, args);
	}
}
