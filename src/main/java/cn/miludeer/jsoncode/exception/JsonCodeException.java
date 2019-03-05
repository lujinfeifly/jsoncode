package cn.miludeer.jsoncode.exception;

/**
 * program: jsoncode
 * description: 错误处理
 * author: lujinfei
 * create: 2019-02-27 10:10
 **/
public class JsonCodeException extends RuntimeException{

//    public static int  10000   20000 规则表达式有错误

    private int code;
    private String msg;

    public JsonCodeException(int code) {
        this.code = code;
        switch (code) {
            case 10001:
                msg = "key is must a long or a String with double comma";
                break;
            case 10002:
                msg = "the end of the key must has the ':' and with the value.";
                break;
            case 10003:
                msg = "the json String perhaps is a half.";
                break;
            case 20001:
                msg = "expression error, not has a value.";
                break;
            case 20002:       // 没有答案，stack中还有值
                msg = "expression error, cal result failed.";
                break;
            case 20003:       // 答案不是一个值，而是一个表示符号错误。
                msg = "expression error, cannot cal last result.";
                break;

            default:


        }
    }

    public JsonCodeException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonCodeException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
