package io.codebyexample.springbootjpa.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author huypva
 * */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
