package idv.maxy.maxec.biz.customer;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import idv.maxy.maxec.biz.vo.MessageVO;

@SpringBootTest(webEnvironment=WebEnvironment.NONE)
@Transactional
@ActiveProfiles("customer")
public class CustomerMQTest {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Test
	public void testMQ() {
		MessageVO msg = new MessageVO();
		msg.setId(UUID.randomUUID().toString());
		msg.setMessage("this is test");
		msg.setTimestamp(System.currentTimeMillis());
		rabbitTemplate.convertAndSend("mail.queue", msg);
	}
	
	
}
