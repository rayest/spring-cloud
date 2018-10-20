package mobi.rayson.ticket;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-18
 *  Time: 下午9:26
 *  Description:
 **/
@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Resource
    private TicketService ticketService;

    @PostMapping("/user/{userId}")
    public ResponseEntity buy(@PathVariable("userId") Integer userId){
        Ticket ticket = ticketService.buy(userId);
        return ResponseEntity.ok(ticket);
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity update(@RequestBody Ticket ticket, @PathVariable("userId") Integer userId){
        ticket = ticketService.update(ticket, userId);
        return ResponseEntity.ok(ticket);
    }
}
