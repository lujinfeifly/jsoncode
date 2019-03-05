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
