package mobi.rayson.log;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2019-03-05
 *  Time: 11:09 AM
 *  Description:
 **/
@Service
public class CustomerLoginLogService {

  @Resource
  private CustomerLoginLogMapper customerLoginLogMapper;

  public void recordLog(LoginLog loginLog) {
    customerLoginLogMapper.save(loginLog);
  }
}
