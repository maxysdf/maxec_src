package idv.maxy.maxec.app.frontend;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import feign.Feign;
import feign.Logger;
import feign.slf4j.Slf4jLogger;
import idv.maxy.maxec.biz.product.restapi.ProductRestAPI;
import idv.maxy.maxec.biz.product.vo.ProductVO;

/**
 * 
 * @author Max Chen
 *
 */
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
@Transactional
public class FrontendTest {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FrontendTest.class);
	
	@Test
	public void testProductApi() {
		
	}
}
