package idv.maxy.maxec.biz.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import idv.maxy.maxec.biz.customer.model.CustomerGroup;

public interface CustomerGroupDao extends JpaRepository<CustomerGroup, String> {

	@Query(value="from CustomerGroup cg where cg.code = :code")
	public CustomerGroup findByCode(@Param("code") String code);
}
