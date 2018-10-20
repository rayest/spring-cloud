package mobi.rayson.feign;

import mobi.rayson.user.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-20
 *  Time: 上午11:22
 *  Description:
 **/
@FeignClient(value = "user-service")
public interface UserFeignClient {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Integer id);
}
