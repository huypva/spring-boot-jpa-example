package io.codebyexample.springbootjpa.entrypoint.controller;

import io.codebyexample.springbootjpa.core.service.UserService;
import io.codebyexample.springbootjpa.dataprovider.user.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huypva
 */
@RestController
public class UserController {

  private UserService userService;

  @GetMapping("/api/user")
  public UserDto getUser(@RequestParam(name = "username") String userName) {
    return userService.getUserByName(userName);
  }
}
