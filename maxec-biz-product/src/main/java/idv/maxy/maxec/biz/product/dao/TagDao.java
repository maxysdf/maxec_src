package idv.maxy.maxec.biz.product.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import idv.maxy.maxec.biz.product.model.Tag;

/**
 * 
 * @author Max Chen
 *
 */
public interface TagDao extends JpaRepository<Tag, String> {
	
	/**
	 * 
	 * @param types
	 * @return
	 */
	@Query(value="from Tag t where t.type in (:types) order by t.sort ")
	public List<Tag> findAllTagByTypes(@Param("types") List<String> types);
	
}
