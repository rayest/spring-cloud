package mobi.rayson.ticket;

import mobi.rayson.user.User;
import mobi.rayson.exception.BusinessException;
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
public class TicketService {

    @Resource
    private RestTemplate restTemplate;

    public Ticket buyTicket(Integer userId) {
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
}
