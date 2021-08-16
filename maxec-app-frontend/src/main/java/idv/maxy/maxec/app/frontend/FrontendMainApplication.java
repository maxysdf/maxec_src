package idv.maxy.maxec.app.frontend;

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
	"idv.maxy.maxec.app.frontend",
	"idv.maxy.maxec.biz.product"
})
public class FrontendMainApplication {
	public static void main(String[] args) {
		SpringApplication.run(FrontendMainApplication.class, args);
	}
}
