package mobi.rayson.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-18
 *  Time: 下午1:41
 *  Description:
 **/
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity findById(@PathVariable("id") Integer id){
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
}
