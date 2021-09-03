package io.codebyexample.springbootjpa;

import io.codebyexample.springbootjpa.configuration.MySQLTestContainer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringBootJpaApplicationTests extends MySQLTestContainer {

	@Test
	void contextLoads() {
	}

}
