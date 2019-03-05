package mobi.rayson.log;

import org.springframework.context.ApplicationEvent;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2019-03-05
 *  Time: 11:04 AM
 *  Description:
 **/
public class LoginEvent extends ApplicationEvent {
  public LoginEvent(LoginLog loginDTO) {
    super(loginDTO);
  }
}
