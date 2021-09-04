package idv.maxy.maxec.biz.content.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import idv.maxy.maxec.biz.content.model.Ad;

public interface AdDao extends JpaRepository<Ad, String> {
	
	@Query(value="from Ad a "
			+ "where a.code = :code "
			+ "and now() between a.startTime and a.endTime")
	public Ad findByCode(@Param("code") String code);
}
