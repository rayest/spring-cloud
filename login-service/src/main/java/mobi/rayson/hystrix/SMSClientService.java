package mobi.rayson.hystrix;

import org.apache.http.HttpResponse;
import org.springframework.stereotype.Service;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2019-03-05
 *  Time: 10:14 AM
 *  Description: 调用服务 sms-service。略。用服务内对象组合实现
 **/
@Service
public class SMSClientService {
  public HttpResponse verify(String phone, String service, String verificationCode) {
    // 如果是单独的 sms-service 服务，可以将此修改为通过 hystrix 实现的服务间调用
    return null;
  }
}
