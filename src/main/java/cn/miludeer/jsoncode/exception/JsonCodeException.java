package cn.miludeer.jsoncode.exception;

/**
 * program: jsoncode
 * description: 错误处理
 * author: lujinfei
 * create: 2019-02-27 10:10
 **/
public class JsonCodeException extends RuntimeException{

//    public static int

    private int code;
    private String msg;

    public JsonCodeException(int code) {
        this.code = code;
    }

    public JsonCodeException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
