package mobi.rayson.login;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-18
 *  Time: 下午1:44
 *  Description:
 **/
@Repository
public interface CustomerLoginMapper {
  void update(@Param("phone") String phone);
}
