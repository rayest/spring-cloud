package mobi.rayson.login;

import lombok.Data;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2019-03-05
 *  Time: 9:45 AM
 *  Description:
 **/
@Data
public class LoginDTO {
  private String phone;
  private String verificationCode;
  private String deviceId;
}
