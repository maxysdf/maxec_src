package idv.maxy.maxec.biz.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import idv.maxy.maxec.biz.customer.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, String> {

	@Query(value="from Customer c "
			+ "left join fetch c.customerGroup g "
			+ "where c.status = :status "
			+ "and (c.username = :username or c.email = :email)  ")
	public Customer findByUsernameOrEmail(
			@Param("username") String username, 
			@Param("email") String email,
			@Param("status") String status);
}
