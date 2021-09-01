package io.codebyexample.springbootjpa.dataprovider.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author huypva
 * */
public interface UserRepository extends JpaRepository<UserDto, Integer> {

  Optional<UserDto> findUserByUserName(String username);
}
