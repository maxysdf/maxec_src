package idv.maxy.maxec.biz.product.service.impl;

import static idv.maxy.maxec.core.vo.ParamTuple.param;
import static java.util.stream.Collectors.toList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idv.maxy.maxec.biz.product.dao.BrandDao;
import idv.maxy.maxec.biz.product.dao.CategoryDao;
import idv.maxy.maxec.biz.product.dao.ProductComplexDao;
import idv.maxy.maxec.biz.product.dao.ProductDao;
import idv.maxy.maxec.biz.product.dao.TagDao;
import idv.maxy.maxec.biz.product.model.Brand;
import idv.maxy.maxec.biz.product.model.Category;
import idv.maxy.maxec.biz.product.model.Product;
import idv.maxy.maxec.biz.product.model.Tag;
import idv.maxy.maxec.biz.product.service.ProductService;
import idv.maxy.maxec.biz.product.vo.BrandVO;
import idv.maxy.maxec.biz.product.vo.CategoryVO;
import idv.maxy.maxec.biz.product.vo.ProductCategoryVO;
import idv.maxy.maxec.biz.product.vo.ProductTagVO;
import idv.maxy.maxec.biz.product.vo.ProductVO;
import idv.maxy.maxec.biz.product.vo.TagVO;
import idv.maxy.maxec.core.vo.ParamTuple;
import idv.maxy.maxec.core.vo.ParamTuples;
import idv.maxy.maxec.core.vo.Tuple;
import idv.maxy.maxec.core.vo.Tuples;

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
	private ProductComplexDao productComplexDao;
	
	@Autowired
	private BrandDao brandDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private TagDao tagDao;
	
	
	private Function<ProductVO, Product> V2M_PRODUCT = v -> {
		Product m = v.getId() != null ? productDao.findById(v.getId()).orElse(null) : null;
		if(m == null) { m = new Product(); }
		m.setAlias(v.getAlias());
		m.setName(v.getName());
		m.setSku(v.getSku());
		m.setPrice(v.getPrice());
		
		//brand
		Brand brand = brandDao.findById(v.getBrandId()).orElse(null);
		m.setBrand(brand);
		
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
		v.setSort(m.getSort());
		return v;
	};
	
	/** */
	private Function<Product, ProductVO> M2V_PRODUCT = m -> {
		if(m == null) { return null; }
		ProductVO v = new ProductVO();
		v.setId(m.getId());
		v.setName(m.getName());
		v.setPrice(m.getPrice());
		v.setAlias(m.getAlias());
		v.setSaleAmount(m.getSaleAmount());
		v.setSku(m.getSku());
		
		Date saleDate = m.getSaleDate();
		v.setSaleDate(saleDate != null ? new SimpleDateFormat("yyyy-MM-dd").format(saleDate) : null);
		v.setOnsaleTime(m.getOnsaleTime());
		v.setOffsaleTime(m.getOffsaleTime());
		
		v.setBrand(M2V_BRAND.apply(m.getBrand()));
		
		m.getProductCategoryMaps().forEach(pcm -> {
			CategoryVO vcat = M2V_CATEGORY.apply(pcm.getCategory());
			ProductCategoryVO pvcat = new ProductCategoryVO();
			pvcat.setId(vcat.getId());
			pvcat.setName(vcat.getName());
			v.getCategories().add(pvcat);
		});
		
		m.getProductTagMaps().forEach(ptm -> {
			TagVO vtag = M2V_TAG.apply(ptm.getTag());
			ProductTagVO pvtag = new ProductTagVO();
			pvtag.setId(vtag.getId());
			pvtag.setType(vtag.getType());
			pvtag.setCode(vtag.getCode());
			pvtag.setName(vtag.getName());
			pvtag.setValue(ptm.getValue());
			v.getTags().add(pvtag);
		});

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
	
	public List<ProductVO> findByIds(List<String> ids) {
		if(ids.isEmpty()) { return new ArrayList<>(); }
		return productDao.findAllById(ids).stream().map(M2V_PRODUCT).collect(toList());
	}
	
	@Transactional
	public String saveProduct(ProductVO v) {
		Product m = V2M_PRODUCT.apply(v);
		productDao.save(m);
		return m.getId();
	}
	
	public Page<ProductVO> pageProduct(List<String> keywords, int pageNo, int pageSize) {
		Page<ProductVO> page = productComplexDao.findAllAvailable(
				keywords, null, false, pageNo, pageSize).map(M2V_PRODUCT);
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

	public List<ProductVO> findAllWithRelated() {
		return productDao.findAllWithRelated().stream().map(M2V_PRODUCT).collect(toList());
	}
	
	@Transactional
	public void deleteProduct(String id) {
		Product p = productDao.findById(id).orElse(null);
		if(p == null) { return; }
		p.setIsDeleted(true);
	}
	
	
	public Page<BrandVO> pageBrand(List<String> keywords, int pageNo, int pageSize) {
		boolean hasKeywords = keywords != null && !keywords.isEmpty();
		
		Page<BrandVO> page = productComplexDao.pageQuery(
				pageNo, pageSize, null, false, 
				ParamTuples.create()
					.addIf("keywords", keywords, hasKeywords)
				.build(),
				( params -> new StringBuilder()
					.append(" from Brand b ")
					.append(" where coalesce(b.isDeleted,'N')<>'Y' " )
					.append(hasKeywords ? " and (lower(b.name) in :keywords) " : "" )
					.toString()
				),
				( params -> "" ),
				M2V_BRAND,
				BrandVO.class);
		return page;
	}
	
	public Page<CategoryVO> pageCategory(List<String> keywords, int pageNo, int pageSize) {
		boolean hasKeywords = keywords != null && !keywords.isEmpty();
		
		Page<CategoryVO> page = productComplexDao.pageQuery(
				pageNo, pageSize, null, false, 
				ParamTuples.create()
					.addIf("keywords", keywords, hasKeywords)
				.build(),
				( params -> new StringBuilder()
					.append(" from Category b ")
					.append(" where coalesce(b.isDeleted,'N')<>'Y' " )
					.append(hasKeywords ? " and (lower(b.name) in :keywords) " : "" )
					.toString()
				),
				( params -> "" ),
				M2V_CATEGORY,
				CategoryVO.class);
		return page;
	}
	
	public Page<TagVO> pageTag(List<String> keywords, int pageNo, int pageSize) {
		boolean hasKeywords = keywords != null && !keywords.isEmpty();
		
		Page<TagVO> page = productComplexDao.pageQuery(
				pageNo, pageSize, null, false, 
				ParamTuples.create()
					.addIf("keywords", keywords, hasKeywords)
				.build(),
				( params -> new StringBuilder()
					.append(" from Tag b ")
					.append(" where coalesce(b.isDeleted,'N')<>'Y' " )
					.append(hasKeywords ? " and (lower(b.name) in :keywords) " : "" )
					.toString()
				),
				( params -> "" ),
				M2V_TAG,
				TagVO.class);
		return page;
	}
	
}
