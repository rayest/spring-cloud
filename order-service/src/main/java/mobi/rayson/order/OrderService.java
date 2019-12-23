package mobi.rayson.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
@Slf4j
public class OrderService {

    @Resource
    private OrderRepository orderRepository;

    public void add(String userNo) {
        String orderNo = UUID.randomUUID().toString();
        OrderEntity orderEntity = new OrderEntity().setOrderNo(orderNo).setUserNo(userNo);
        orderRepository.save(orderEntity);
    }
}
