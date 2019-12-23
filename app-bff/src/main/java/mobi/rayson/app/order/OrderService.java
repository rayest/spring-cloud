package mobi.rayson.app.order;

import lombok.extern.slf4j.Slf4j;
import mobi.rayson.app.client.OrderClient;
import mobi.rayson.app.client.PointClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class OrderService {

    @Resource
    private OrderClient orderClient;

    @Resource
    private PointClient pointClient;

    public void add(String userNo) {
        log.info("新增订单");
        orderClient.add(userNo);

        log.info("增加积分");
        pointClient.update(userNo);

        log.info("用户 {} 下单完成.", userNo);
    }
}
