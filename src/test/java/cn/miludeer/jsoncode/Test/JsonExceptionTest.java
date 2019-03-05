package cn.miludeer.jsoncode.Test;

import cn.miludeer.jsoncode.JsonCode;
import cn.miludeer.jsoncode.exception.JsonCodeException;
import org.junit.Test;

/**
 * program: jsoncode
 * description: ${description}
 * author: lujinfei
 * create: 2019-02-27 10:36
 **/
public class JsonExceptionTest {


    @Test
    public void testkey() {

        try {
            String json = "{3:5,\"0\":890}";

            String code = JsonCode.getValue(json, "$.0");

            System.out.println(code);
        }catch(JsonCodeException ex) {
            System.out.println(ex.toString());
        }
    }


    @Test
    public void testListRegular21() {
        String json = "{\"ss\":{\"sss\":\"vvvvv\",\"fg\":{\"f\":\"ererer\",\"list\":[1,eeee,{\"\\[\"}]}}}";

        String code = JsonCode.calExpressionResult(json,"(listsize($.ss.fg.list) + listsize($.ss.fg.list)) * (1+listsize($.ss.fg.list)) + listsize($.ss.fg.list) == 28");

        System.out.println(code);
    }

    @Test
    public void testListRegular22() {
        try {
            String json = "{\"ss\":{\"sss\":\"vvvvv\",\"fg\":{\"f\":\"ererer\",\"list\":[1,eeee,{\"\\[\"}]}}}";

            String code = JsonCode.calExpressionResult(json, "(2*8)");

            System.out.println(code);
        }catch(JsonCodeException ex) {
            System.out.println(ex.toString());
        }
    }
}
