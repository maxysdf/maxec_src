package idv.maxy.maxec.biz.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import idv.maxy.maxec.biz.customer.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, String> {

}
