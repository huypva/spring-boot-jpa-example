package io.codebyexample.springbootjpa.core.service;


import io.codebyexample.springbootjpa.dataprovider.user.UserDto;

/**
 * @author huypva
 */
public interface UserService {

  UserDto getUserByName(String userName);
}
