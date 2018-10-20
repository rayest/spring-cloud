package mobi.rayson.exception;

import lombok.Data;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-08
 *  Time: 下午3:27
 *  Description:
 **/
@Data
public class HttpResponse {
    private String code ;
    private String message;

    public HttpResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
