package mobi.rayson.app.order;

import mobi.rayson.app.client.OrderClient;
import mobi.rayson.app.client.PointClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private OrderClient orderClient;

    @Resource
    private PointClient pointClient;

    public void add(String userNo) {
        orderClient.add(userNo);
        pointClient.update(userNo);
    }
}
