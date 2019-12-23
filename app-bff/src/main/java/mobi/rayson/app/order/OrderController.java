package mobi.rayson.app.order;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/order/{userNo}")
    public void add(@PathVariable("userNo") String userNo){
        orderService.add(userNo);
    }
}
