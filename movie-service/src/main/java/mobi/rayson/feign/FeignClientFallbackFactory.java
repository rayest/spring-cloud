package mobi.rayson.feign;

import feign.hystrix.FallbackFactory;
import mobi.rayson.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {

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
