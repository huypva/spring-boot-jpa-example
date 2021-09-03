package io.codebyexample.springbootjpa.configuration;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * @author huypva
 */
@Testcontainers
public class MySQLTestContainer {

  @Container
  private static final MySQLContainer<?> MYSQL_CONTAINER = new MySQLContainer<>("mysql:8.0.25")
      .withUrlParam("characterEncoding", "UTF-8")
      .withUrlParam("serverTimezone", "UTC")
      .withUsername("root")
      .withPassword("password")
      .withDatabaseName("spring_boot_jpa_example")
      .withEnv("MYSQL_ROOT_PASSWORD", "password")
      .withInitScript("init.sql");

  @DynamicPropertySource
  private static void setTestProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", MYSQL_CONTAINER::getJdbcUrl);
    registry.add("spring.datasource.username", MYSQL_CONTAINER::getUsername);
    registry.add("spring.datasource.password", MYSQL_CONTAINER::getPassword);
  }

}
