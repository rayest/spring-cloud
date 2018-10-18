package mobi.rayson.exception;

import org.springframework.test.util.ReflectionTestUtils;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-18
 *  Time: 下午9:40
 *  Description:
 **/
public class BusinessException extends RuntimeException {

    private int code;
    private String message;

    public BusinessException(Object object) {
        this.code = (int) ReflectionTestUtils.invokeGetterMethod(object, "code");
        this.message = (String) ReflectionTestUtils.invokeGetterMethod(object, "message");
    }
}
