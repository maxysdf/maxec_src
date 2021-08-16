package idv.maxy.maxec.biz.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import idv.maxy.maxec.biz.product.dao.ProductDao;
import idv.maxy.maxec.biz.product.model.Product;

/**
 * 
 * @author Max Chen
 *
 */
@SpringBootTest(webEnvironment=WebEnvironment.NONE)
@Transactional
@ActiveProfiles("product")
public class ProductDaoTest {

	@Autowired
	private ProductDao productDao;
	
	@Test @Rollback(false)
	public void testSave() {
		Product p = new Product();
		p.setName("test");
		
		productDao.save(p);
	}
	
	
}
