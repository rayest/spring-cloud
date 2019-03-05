package mobi.rayson.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-18
 *  Time: 下午1:41
 *  Description: 登录服务
 **/
@RestController
public class LoginController {

  @Resource
  private LoginService loginService;

  @PostMapping("/login")
  public ResponseEntity login(@RequestBody LoginDTO loginDTO) throws Exception {
    LoginVO loginVO = loginService.login(loginDTO);
    return ResponseEntity.ok(loginVO);
  }
}
