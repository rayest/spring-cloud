package mobi.rayson.login;

import lombok.Data;

import java.math.BigDecimal;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-18
 *  Time: 上午11:53
 *  Description:
 **/
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private BigDecimal balance;
}
