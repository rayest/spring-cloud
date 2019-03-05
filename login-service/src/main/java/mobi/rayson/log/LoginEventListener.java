package mobi.rayson.log;

import javax.annotation.Resource;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2019-03-05
 *  Time: 11:07 AM
 *  Description:
 **/
@Component
public class LoginEventListener implements ApplicationListener<LoginEvent> {

  @Resource
  private CustomerLoginLogService customerLoginLogService;

  @Override
  public void onApplicationEvent(LoginEvent loginEvent) {
    LoginLog loginLog = (LoginLog) loginEvent.getSource();
    customerLoginLogService.recordLog(loginLog);
  }
}
