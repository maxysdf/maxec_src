package idv.maxy.maxec.biz.product.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import idv.maxy.maxec.biz.product.model.Product;
import idv.maxy.maxec.core.util.GenericUtil;

@Repository
public class ProductComplexDao {
	
	@PersistenceContext
	private EntityManager em;
	
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
			.append(hasKeyword ? "and (lower(p.name) in :kws or lower(p.sku) in :kws) " : "")
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
