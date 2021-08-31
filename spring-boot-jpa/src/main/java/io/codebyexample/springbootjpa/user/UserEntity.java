package io.codebyexample.springbootjpa.user;

import javax.persistence.*;
import javax.persistence.Id;
import lombok.*;

/**
 * @author huypva
 * */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User")
@Entity
@Data
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private int userId;

  @Column(name = "user_name")
  private String userName;
}
