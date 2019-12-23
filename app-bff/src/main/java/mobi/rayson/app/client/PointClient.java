package mobi.rayson.app.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "point-service", fallbackFactory = PointClientFallbackFactory.class)
public interface PointClient {
    @RequestMapping(value = "/point/{userNo}", method = RequestMethod.PUT)
    void update(@PathVariable("userNo") String userNo);
}
