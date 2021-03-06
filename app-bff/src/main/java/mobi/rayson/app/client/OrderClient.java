package mobi.rayson.app.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "order-service")
public interface OrderClient {
    @RequestMapping(value = "/order/{userNo}", method = RequestMethod.POST)
    void add(@PathVariable("userNo") String userNo);
}
