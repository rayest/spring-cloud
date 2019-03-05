package mobi.rayson.log;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2019-03-05
 *  Time: 11:13 AM
 *  Description:
 **/
@Data
@Builder
public class LoginLog {
  private int customerId;
  private Date loginTime;
  private String loginIp;
  private int loginType;
}
