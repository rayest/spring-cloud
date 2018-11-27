package mobi.rayson.ticket;

import lombok.extern.slf4j.Slf4j;
import mobi.rayson.exception.BusinessException;
import mobi.rayson.feign.UserFeignClient;
import mobi.rayson.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-18
 *  Time: 下午9:32
 *  Description:
 **/
@Service
@Slf4j
public class TicketService {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private UserFeignClient userFeignClient;

    @Value("${from}")
    private String from;

    public Ticket buy(Integer userId) {
        log.info("From: {}", from);
        ResponseEntity responseEntity = restTemplate.getForEntity("http://localhost:8001/user/" + userId, User.class);
        User user = (User) responseEntity.getBody();
        if (user == null) {
            throw new BusinessException(TicketCodes.USER_IS_NOT_EXIST);
        }
        if (user.getBalance().compareTo(new BigDecimal(30)) < 0) {
            throw new BusinessException(TicketCodes.USER_BALANCE_IS_NOT_ENOUGH);
        }
        Ticket ticket = new Ticket();
        ticket.setName("旺角卡门");
        ticket.setUserId(user.getId());
        return ticket;
    }

    public Ticket update(Ticket ticket, Integer userId) {
        User user = userFeignClient.findById(userId);
        if (user == null) {
            throw new BusinessException(TicketCodes.USER_IS_NOT_EXIST);
        }
        Ticket updatedTicket = new Ticket();
        updatedTicket.setName(ticket.getName());
        updatedTicket.setUserId(user.getId());
        return updatedTicket;
    }
}
