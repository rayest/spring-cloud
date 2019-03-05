package mobi.rayson.login;

import java.util.Date;
import mobi.rayson.hystrix.SMSClientService;
import mobi.rayson.log.LoginLog;
import mobi.rayson.log.LoginPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-18
 *  Time: 下午1:43
 *  Description:
 **/
@Service
public class LoginService {

  @Resource
  private CustomerLoginMapper customerLoginMapper;

  @Resource
  private SMSClientService smsClientService;

  @Resource
  private LoginPublisher loginPublisher;

  @Resource
  private CustomerPointPublisher customerPointPublisher;

  public LoginVO login(LoginDTO loginDTO) throws Exception {
    String phone = loginDTO.getPhone();
    smsClientService.verify(phone, LoginConstant.SMS_LOGIN, loginDTO.getVerificationCode());
    verifyCustomerAndLogin(loginDTO);
    saveLoginLog(loginDTO);
    customerPointPublisher.handlePoint(loginDTO);
    return new LoginVO();
  }

  private void saveLoginLog(LoginDTO loginDTO) {
    LoginLog loginLog = buildLoginLog(loginDTO);
    loginPublisher.recordLog(loginLog);
  }

  private LoginLog buildLoginLog(LoginDTO loginDTO) {
    return LoginLog.builder()
        .customerId(1)
        .loginIp("127.0.0.1")
        .loginTime(new Date())
        .loginType(1)
        .build();
  }

  private void verifyCustomerAndLogin(LoginDTO loginDTO) throws Exception {
    if (!phoneIsExist(loginDTO.getPhone())) {
      throw new Exception("手机号不存在");
    }
    updateLogin(loginDTO.getPhone());
  }

  private void updateLogin(String phone) {
    customerLoginMapper.update(phone);
  }

  private boolean phoneIsExist(String phone) {
    return true;
  }
}
