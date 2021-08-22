package idv.maxy.maxec.biz.product.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idv.maxy.maxec.biz.product.dao.BrandDao;
import idv.maxy.maxec.biz.product.dao.CategoryDao;
import idv.maxy.maxec.biz.product.dao.ProductDao;
import idv.maxy.maxec.biz.product.dao.TagDao;
import idv.maxy.maxec.biz.product.model.Brand;
import idv.maxy.maxec.biz.product.model.Category;
import idv.maxy.maxec.biz.product.model.Product;
import idv.maxy.maxec.biz.product.model.Tag;
import idv.maxy.maxec.biz.product.service.ProductService;
import idv.maxy.maxec.biz.product.vo.BrandVO;
import idv.maxy.maxec.biz.product.vo.CategoryVO;
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.biz.product.vo.TagVO;

/**
 * 
 * @author Max Chen
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private BrandDao brandDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private TagDao tagDao;
	
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
	
	private Function<Category, CategoryVO> M2V_CATEGORY = m -> {
		if(m == null) { return null; }
		CategoryVO v = new CategoryVO();
		v.setId(m.getId());
		v.setName(m.getName());
		return v;
	};
	
	private Function<Brand, BrandVO> M2V_BRAND = m -> {
		if(m == null) { return null; }
		BrandVO v = new BrandVO();
		v.setId(m.getId());
		v.setName(m.getName());
		return v;
	};
	
	private Function<Tag, TagVO> M2V_TAG = m -> {
		if(m == null) { return null; }
		TagVO v = new TagVO();
		v.setId(m.getId());
		v.setType(m.getType());
		v.setName(m.getName());
		v.setValue(m.getValue());
		v.setCode(m.getCode());
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
	
	
	public List<CategoryVO> findAllCategories() {
		return categoryDao.findAll().stream().map(M2V_CATEGORY).collect(toList());
	}
	
	public List<BrandVO> findAllBrands() {
		return brandDao.findAll().stream().map(M2V_BRAND).collect(toList());
	}
	
	
	public Map<String, List<TagVO>> listTagGroupByTypes(List<String> types) {
		Map<String, List<TagVO>> map = new LinkedHashMap<>();
		if(types == null || types.isEmpty()) { return map; }
		
		List<TagVO> vlist = tagDao.findAllTagByTypes(types).stream().map(M2V_TAG).collect(toList());
		for(TagVO v : vlist) {
			map.putIfAbsent(v.getType(), new ArrayList<>());
			map.get(v.getType()).add(v);
		}
		return map;
	}
	
}
