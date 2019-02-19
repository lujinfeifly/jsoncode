package cn.miludeer.jsoncode.Test;

import cn.miludeer.jsoncode.JsonCode;
import org.junit.Test;

/**
 * program: jsoncode
 * <p>
 * description: ${description}
 * <p>
 * author: lujinfei
 * <p>
 * create: 2019-02-17 10:49
 **/
public class JsonCodeTest {

    @Test
    public void testList() {

        String json = "{\"ss\":{\"sss\":\"vvvvv\",\"fg\":{\"f\":\"ererer\",\"list\":[1,eeee,{\"\\[\"}]}}}";

        String code = JsonCode.getValue(json,"*.ss.fg.list");

        System.out.println(code);
    }

    @Test
    public void testkey() {

        String json = "{\"ss\":{\"sss\":\"vvvvv\",\"fg\":{\"f\":\"ererer\",\"list\":[1,eeee,{\"\\[\"}]}}}";

        String code = JsonCode.getValue(json,"*.ss.fg.f");

        System.out.println(code);
    }



}
