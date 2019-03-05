package mobi.rayson.login;

import javax.annotation.Resource;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static mobi.rayson.configuration.RabbitMQConfiguration.QUEUE_POINT;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2019-03-05
 *  Time: 4:09 PM
 *  Description:
 **/
@Component
public class CustomerPointPublisher {

  @Resource
  private RabbitTemplate rabbitTemplate;

  public void handlePoint(LoginDTO loginDTO) {
    rabbitTemplate.convertAndSend(QUEUE_POINT, loginDTO);
  }
}
