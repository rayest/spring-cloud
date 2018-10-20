package mobi.rayson.feign;

import feign.hystrix.FallbackFactory;
import mobi.rayson.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
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
@FeignClient(value = "user-service", fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Integer id);
}

@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{

    private static final Logger logger = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        return id -> {
            logger.info("fallback; reason: {}", cause);
            User user = new User();
            user.setId(0);
            user.setUsername("默认用户");
            return user;
        };
    }
}
