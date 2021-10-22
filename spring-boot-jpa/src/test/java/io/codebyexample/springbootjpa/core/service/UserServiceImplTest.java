package io.codebyexample.springbootjpa.core.service;

import static org.assertj.core.api.Assertions.assertThat;

import io.codebyexample.springbootjpa.dataprovider.user.UserDto;
import io.codebyexample.springbootjpa.dataprovider.user.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author huypva
 */
@ExtendWith(SpringExtension.class)
@Import(UserServiceImpl.class)
public class UserServiceImplTest {

  @Autowired
  private UserService userService;

  @MockBean
  private UserRepository userRepository;

  @Test
  void givenExistingUserWhenGetUserByUserNameThenReturnUser() {
    UserDto userDefault = new UserDto(1, "Huy");

    Mockito.when(userRepository.findUserByUserName("Huy")).thenReturn(Optional.of(userDefault));

    UserDto user = userService.getUserByName("Huy");
    assertThat(user).usingRecursiveComparison().isEqualTo(userDefault);
  }

}