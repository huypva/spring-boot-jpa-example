package io.codebyexample.springbootjpa.dataprovider.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huypva
 * */
@Repository
public interface UserRepository extends JpaRepository<UserDto, Integer> {

  Optional<UserDto> findUserByUserName(String username);
}
