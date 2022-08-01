package io.codebyexample.springbootjpa.core.service;

import io.codebyexample.springbootjpa.dataprovider.user.UserDto;
import io.codebyexample.springbootjpa.dataprovider.user.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author huypva
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

  @InjectMocks
  private UserServiceImpl userService;

  @Mock
  private UserRepository userRepository;

  @Test
  void givenExistingUserWhenGetUserByUserNameThenReturnUser() {
    UserDto userDefault = new UserDto(1, "Huy");

    Mockito.when(userRepository.findUserByUserName("Huy")).thenReturn(Optional.of(userDefault));

    UserDto user = userService.getUserByName("Huy");
    Assertions.assertEquals(user, userDefault);
  }

}