package io.codebyexample.springbootjpa.core.exception;

/**
 * @author huypva
 */
public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException(String message) {
    super(message);
  }
}
