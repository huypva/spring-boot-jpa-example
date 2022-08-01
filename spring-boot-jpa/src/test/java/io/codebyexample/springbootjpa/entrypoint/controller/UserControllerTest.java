package io.codebyexample.springbootjpa.entrypoint.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.codebyexample.springbootjpa.core.service.UserService;
import io.codebyexample.springbootjpa.dataprovider.user.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

/**
 * @author huypva
 */
@WebMvcTest(UserController.class)
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  @Test
  void givenOneUserWhenGetUserByUserNameThenReturnStatusOkAndJsonArrayWithOneUser() throws Exception {
    String api = "/api/user?username=Huy";
    UserDto userDto = new UserDto(1, "Huy");

    given(userService.getUserByName("Huy")).willReturn(userDto);

    ResultActions resultActions = mockMvc.perform(get(api))
        .andDo(print());

    resultActions.andExpect(status().isOk())
        .andExpect(jsonPath("$.userId", is(userDto.getUserId())))
        .andExpect(jsonPath("$.userName", is(userDto.getUserName())));
  }

}