package idv.maxy.maxec.biz.product.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		v.setPrice(m.getPrice());
		v.setAlias(m.getAlias());
		return v;
	};
	
	private Function<ProductVO, Product> V2M_PRODUCT = v -> {
		Product m = v.getId() != null ? productDao.findById(v.getId()).orElse(null) : null;
		if(m == null) { m = new Product(); }
		m.setAlias(v.getAlias());
		m.setName(v.getName());
		m.setPrice(v.getPrice());
		return m;
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
	
	public List<ProductVO> findAll() {
		return productDao.findAll().stream().map(M2V_PRODUCT).collect(toList());
	}
	
	public ProductVO findByAlias(String alias) {
		return productDao.findByAlias(alias).map(M2V_PRODUCT).orElse(null);
	}
	
	@Transactional
	public String saveProduct(ProductVO v) {
		Product m = V2M_PRODUCT.apply(v);
		productDao.save(m);
		return m.getId();
	}
	
	public Page<ProductVO> pageProduct(int pageNo, int pageSize) {
		Pageable pa = PageRequest.of(pageNo, pageSize);
		Page<ProductVO> page = productDao.findAll(pa).map(M2V_PRODUCT);
		return page;
	}
	
}
