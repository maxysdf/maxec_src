package idv.maxy.maxec.biz.customer.service.impl;

import java.util.UUID;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idv.maxy.maxec.biz.customer.dao.CustomerDao;
import idv.maxy.maxec.biz.customer.dao.CustomerGroupDao;
import idv.maxy.maxec.biz.customer.model.Customer;
import idv.maxy.maxec.biz.customer.model.CustomerGroup;
import idv.maxy.maxec.biz.customer.service.CustomerService;
import idv.maxy.maxec.biz.customer.vo.CustomerVO;
import idv.maxy.maxec.core.util.StringUtil;

/**
 * 
 * @author Max Chen
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CustomerGroupDao customerGroupDao;
	
	
	private Function<Customer, CustomerVO> M2V_CUSTOMER = m -> {
		if(m == null) { return null; }
		
		CustomerVO v = new CustomerVO();
		v.setId(m.getId());
		v.setEmail(m.getEmail());
		v.setName(m.getEmail());
		v.setUsername(m.getUsername());
		
		CustomerGroup g = m.getCustomerGroup();
		if(g != null) {
			v.setGroupCode(g.getCode());
		}
		
		return v;
	};
	
	
	
	
	@Transactional
	public void register(String name, String groupCode, String username, String password, String email) throws Exception {
		if(StringUtil.isEmptyOrNull(name)) { throw new Exception("no name"); }
		if(StringUtil.isEmptyOrNull(username)) { throw new Exception("no username"); }
		
		CustomerGroup group = customerGroupDao.findByCode(groupCode);
		if(group == null) { throw new Exception("invalid group: " + groupCode); }
		
		Customer customer = new Customer();
		customer.setCustomerGroup(group);
		customer.setName(name);
		customer.setEmail(email);
		customer.setUsername(username);
		customer.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
		customer.setStatus(Customer.STATUS_ENABLED);
		group.getCustomers().add(customer);
		
		customerDao.save(customer);
	}
	
	@Transactional
	public void deregister(String username, String id) throws Exception {
		if(StringUtil.isEmptyOrNull(username)) { throw new Exception("no username"); }
		
		Customer customer = customerDao.findById(id).orElse(null);
		if(customer == null) { throw new Exception("no customer for id: " + id); }
		
		String cusername = customer.getUsername();
		if(!username.equals(cusername)) {
			throw new Exception("username not match");
		}
		
		// dereg.
		customer.setEmail(null);
		customer.setUsername(null);
		customer.setStatus(Customer.STATUS_DISABLED);
		customer.setIsDeleted(true);
	}
	
	
	@Override
	public CustomerVO login(String credential, String password) {
		Customer customer = customerDao.findByUsernameOrEmail(credential, credential, Customer.STATUS_ENABLED);
		if(customer == null) { return null; }
		
		boolean pwdchk = BCrypt.checkpw(password, customer.getPassword());
		if(!pwdchk) { return null; }
		
		return M2V_CUSTOMER.apply(customer);
	}
}
