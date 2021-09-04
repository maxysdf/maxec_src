package idv.maxy.maxec.biz.product.dao;

import static java.util.stream.Collectors.toList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import idv.maxy.maxec.biz.product.model.Product;
import idv.maxy.maxec.biz.product.vo.BasePageParamVO;
import idv.maxy.maxec.core.util.GenericUtil;
import idv.maxy.maxec.core.vo.ParamTuple;
import idv.maxy.maxec.core.vo.Tuple;

@Repository
public class ProductComplexDao {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public <S,T> Page<T> pageQuery(
		int pageNo, int pageSize, String sort, boolean sortAsc,
		List<ParamTuple> paramTuples,
		Function<Map<String, Object>, String> queryStringMapper,
		Function<Map<String, Object>, String> sortStringMapper,
		Function<S,T> resultMapper,
		Class<T> resultClass
	) {
		// param
		Map<String, Object> params = new LinkedHashMap<>();
		paramTuples.forEach(t -> params.put(t.getV1(), t.getV2()));
		
		// query
		String qryStr = queryStringMapper.apply(params);
		
		// count
		String cqryStr = String.format("select count(*) %s", qryStr);
		Query cqry = em.createQuery(cqryStr);
		params.forEach((k,v)-> cqry.setParameter(k, v));
		Long cnt = GenericUtil.cast(cqry.getSingleResult(), Long.class);
		
		// sort (TODO)
		
		// query
		Query qry = em.createQuery(qryStr)
				.setFirstResult(pageNo*pageSize)
				.setMaxResults(pageSize);
		params.forEach((k,v)-> qry.setParameter(k, v));
		List<S> slist = qry.getResultList();

		List<T> tlist = slist.stream().map(resultMapper).collect(toList());
		
		return new PageImpl<>(tlist, PageRequest.of(pageNo, pageSize), cnt);
	}
	
	@SuppressWarnings("unchecked")
	public Page<Product> findAllAvailable(
			List<String> keywords, String sort, boolean sortAsc, 
			int pageNo, int pageSize) {
		Map<String, Object> params = new LinkedHashMap<>();
		boolean hasKeyword = keywords != null && !keywords.isEmpty();
		if(hasKeyword) { params.put("kws", keywords); }
		
		String qryStr = new StringBuilder()
			.append("from Product p ")
			.append("where coalesce(p.isDeleted,'N')<>'Y' ")
			.append(hasKeyword ? "and (lower(p.name) in (:kws) or lower(p.sku) in (:kws)) " : "")
			.toString();
		
		// count
		String cqryStr = String.format("select count(*) %s", qryStr);
		Query cqry = em.createQuery(cqryStr);
		params.forEach((k,v)-> cqry.setParameter(k, v));
		Long cnt = GenericUtil.cast(cqry.getSingleResult(), Long.class);
		
		// query
		Query qry = em.createQuery(qryStr)
				.setFirstResult(pageNo*pageSize)
				.setMaxResults(pageSize);
		params.forEach((k,v)-> qry.setParameter(k, v));
		List<Product> list = qry.getResultList();

		return new PageImpl<>(list, PageRequest.of(pageNo, pageSize), cnt);
	}
}
