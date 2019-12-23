package mobi.rayson.common.configuration;

import java.io.IOException;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import mobi.rayson.common.utils.JacksonUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static mobi.rayson.common.configuration.RabbitMQConfiguration.QUEUE_POINT;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-08-28
 *  Time: 下午2:53
 *  Description:
 **/
@Component
@Slf4j
public class CustomerPointListener {

  @Resource
  private CustomerPointService customerPointService;

  @Resource
  private JacksonUtils jacksonUtils;

  @RabbitHandler
  @RabbitListener(queues = QUEUE_POINT)
  public void receive(Message message) throws IOException {
    CustomerPointLog pointLog = jacksonUtils.convertFromByte(message.getBody(), CustomerPointLog.class);
    log.info("Message processing...");
    //customerPointService.handlePoint(customerPointLog);
    log.info("Message processed...");
  }
}
