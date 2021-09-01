package idv.maxy.maxec.biz.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import idv.maxy.maxec.biz.customer.dao.CustomerDao;
import idv.maxy.maxec.biz.customer.model.Customer;
import idv.maxy.maxec.biz.customer.model.CustomerAttribute;
import idv.maxy.maxec.biz.customer.model.CustomerAttributeMap;
import idv.maxy.maxec.biz.customer.model.CustomerGroup;

@SpringBootTest(webEnvironment=WebEnvironment.NONE)
@Transactional
@ActiveProfiles("customer")
public class CustomerDaoImpl {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Test @Rollback(false)
	public void testSave() {
		
		CustomerGroup g = new CustomerGroup();
		g.setCode("MEMBER");
		g.setName("會員");
		
		CustomerAttribute caGender = new CustomerAttribute();
		caGender.setCode("GENDER");
		caGender.setName("Gender");
		caGender.setDisplayName("性別");
		caGender.setCustomerGroup(g);
		
		CustomerAttribute caMemberId = new CustomerAttribute();
		caMemberId.setCode("MEMBER_ID");
		caMemberId.setName("Member ID");
		caMemberId.setDisplayName("會員號碼");
		caMemberId.setCustomerGroup(g);
		
		g.getCustomerAttributes().add(caGender);
		g.getCustomerAttributes().add(caMemberId);
		
		Customer c = new Customer();
		c.setName("Max Chen");
		c.setUsername("maxysdf");
		c.setEmail("maxy@mail2000.com.tw");
		c.setStatus(Customer.STATUS_ENABLED);
		c.setPassword(BCrypt.hashpw("a7jtmaim", BCrypt.gensalt()));
		c.setCustomerGroup(g);
		g.getCustomers().add(c);
		
		CustomerAttributeMap camGender = new CustomerAttributeMap();
		camGender.setValue("M");
		camGender.setCustomer(c);
		camGender.setCustomerAttribute(caGender);
		caGender.getCustomerAttributeMaps().add(camGender);

		CustomerAttributeMap camMemberId = new CustomerAttributeMap();
		camMemberId.setValue("EC202109010000021");
		camMemberId.setCustomer(c);
		camMemberId.setCustomerAttribute(caGender);
		caMemberId.getCustomerAttributeMaps().add(camMemberId);
		
		c.getCustomerAttributeMaps().add(camGender);
		c.getCustomerAttributeMaps().add(camMemberId);
		
		customerDao.save(c);
	}
	
}
