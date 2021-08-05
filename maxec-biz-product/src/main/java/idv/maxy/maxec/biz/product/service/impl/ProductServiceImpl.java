package idv.maxy.maxec.biz.product.service.impl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.maxy.maxec.biz.product.dao.ProductDao;
import idv.maxy.maxec.biz.product.model.Product;
import idv.maxy.maxec.biz.product.service.ProductService;
import idv.maxy.maxec.biz.product.vo.ProductVO;

/**
 * 
 * @author Max Chen
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	/** */
	private Function<Product, ProductVO> M2V_PRODUCT = m -> {
		if(m == null) { return null; }
		ProductVO v = new ProductVO();
		v.setId(m.getId());
		v.setName(m.getName());
		return v;
	};
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ProductVO findById(String id) {
		return productDao.findById(id)
				.map(M2V_PRODUCT).orElse(null);
	}
	
}
