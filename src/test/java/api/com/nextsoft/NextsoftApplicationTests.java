package api.com.nextsoft;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import api.com.nextsoft.controllers.ClienteController;

@SpringBootTest
class NextsoftApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@Test
	void contextLoads() throws Exception {
	
	}

}
