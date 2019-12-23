package mobi.rayson.ticket;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-10-18
 *  Time: 下午9:38
 *  Description:
 **/
public enum TicketCodes {
    USER_IS_NOT_EXIST("001", "用户不存在"),
    USER_BALANCE_IS_NOT_ENOUGH("002", "用户余额不足");

    private String code;
    private String message;

    TicketCodes(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }
}
