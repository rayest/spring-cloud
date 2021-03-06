package mobi.rayson.login;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2019-03-05
 *  Time: 9:45 AM
 *  Description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO implements Serializable {
  private String phone;
  private String verificationCode;
  private String deviceId;
}
