package mobi.rayson.ticket;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-18
 *  Time: 下午9:26
 *  Description:
 **/
@RestController
public class TicketController {

    @Resource
    private TicketService ticketService;

    @PostMapping("/ticket/user/{userId}")
    public ResponseEntity buy(@PathVariable("userId") Integer userId){
        Ticket ticket = ticketService.buy(userId);
        return ResponseEntity.ok(ticket);
    }
}
