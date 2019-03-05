package mobi.rayson.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2019-03-05
 *  Time: 1:34 PM
 *  Description:
 **/
@Configuration
public class RabbitMQConfiguration {
  public static final String QUEUE_POINT = "point";
  public static final String EXCHANGE = "login_point";

  @Bean
  Queue pointQueue() {
    return new Queue(QUEUE_POINT, false);
  }

  @Bean
  TopicExchange exchange() {
    return new TopicExchange(EXCHANGE);
  }

  @Bean
  Binding binding(Queue queue, TopicExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(QUEUE_POINT);
  }

  @Bean
  CustomerPointListener customerPointListener() {
    return new CustomerPointListener();
  }

  @Bean
  public MessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter();
  }
}
