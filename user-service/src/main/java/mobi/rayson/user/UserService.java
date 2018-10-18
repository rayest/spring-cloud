package mobi.rayson.user;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-18
 *  Time: 下午1:43
 *  Description:
 **/
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findById(Integer id) {
        return userRepository.findById(id);
    }
}
