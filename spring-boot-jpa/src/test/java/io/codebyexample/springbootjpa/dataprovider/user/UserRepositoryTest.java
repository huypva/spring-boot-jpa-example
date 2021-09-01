package io.codebyexample.springbootjpa.dataprovider.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * @author huypva
 */
@DataJpaTest
class UserRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private UserRepository userRepository;

  @Test
  void givenExistingUserUsernameWhenFindUserByUsernameThenReturnUser() {
    UserDto user = new UserDto(1, "Huy");
    entityManager.persist(user);

    Optional<UserDto> userOptional = userRepository.findUserByUserName(user.getUserName());

    assertThat(userOptional).isPresent();
    assertThat(userOptional.get()).usingRecursiveComparison().isEqualTo(user);
  }
}