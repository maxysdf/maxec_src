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

import idv.maxy.maxec.biz.product.dao.BrandDao;
import idv.maxy.maxec.biz.product.dao.CategoryDao;
import idv.maxy.maxec.biz.product.dao.ProductDao;
import idv.maxy.maxec.biz.product.model.Brand;
import idv.maxy.maxec.biz.product.model.Category;
import idv.maxy.maxec.biz.product.model.Product;
import idv.maxy.maxec.biz.product.model.ProductCategoryMap;
import idv.maxy.maxec.biz.product.model.ProductTagMap;
import idv.maxy.maxec.biz.product.model.Tag;

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
	
	@Autowired
	private BrandDao brandDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	@Test
	public void testSaveProduct() {
		Product p = new Product();
		p.setName("test");
		
		productDao.save(p);
	}
	
	@Test @Rollback(false)
	public void testSaveBrand() {
		Brand p = new Brand();
		p.setName("test brand");
		
		Product prd = new Product();
		prd.setName("test bb");
		prd.setBrand(p);
		
		Category cat = new Category();
		cat.setName("men");
		categoryDao.save(cat);
		
		Tag tag = new Tag();
		tag.setType("COLOR");
		tag.setName("Black");
		tag.setCode("BLACK");
		
		ProductCategoryMap pcm = new ProductCategoryMap();
		pcm.setProduct(prd);
		pcm.setCategory(cat);
		prd.getProductCategoryMaps().add(pcm);
		cat.getProductCategoryMaps().add(pcm);
		
		ProductTagMap ptm = new ProductTagMap();
		ptm.setProduct(prd);
		ptm.setTag(tag);
		prd.getProductTagMaps().add(ptm);
		tag.getProductTagMaps().add(ptm);
		
		productDao.save(prd);
	}
	
	
}
