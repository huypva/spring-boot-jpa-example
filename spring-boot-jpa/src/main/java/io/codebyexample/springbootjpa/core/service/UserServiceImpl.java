package io.codebyexample.springbootjpa.core.service;

import io.codebyexample.springbootjpa.core.exception.UserNotFoundException;
import io.codebyexample.springbootjpa.dataprovider.user.UserDto;
import io.codebyexample.springbootjpa.dataprovider.user.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author huypva
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto getUserByName(String username) {
        return userRepository.findUserByUserName(username)
            .orElseThrow(() -> new UserNotFoundException(String.format("Not found user by name %s", username)));
    }
}
