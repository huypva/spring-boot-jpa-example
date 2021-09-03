package io.codebyexample.springbootjpa.dataprovider.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import io.codebyexample.springbootjpa.configuration.MySQLTestContainer;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author huypva
 */
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class UserRepositoryTest extends MySQLTestContainer {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private UserRepository userRepository;

  @Test
  void givenExistingUserUsernameWhenFindUserByUsernameThenReturnUser() {
    UserDto user = new UserDto(1, "Huy");

    Optional<UserDto> userOptional = userRepository.findUserByUserName(user.getUserName());

    assertThat(userOptional).isPresent();
    assertThat(userOptional.get()).usingRecursiveComparison().isEqualTo(user);
  }
}