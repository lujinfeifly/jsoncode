package cn.miludeer.jsoncode.Test;

import cn.miludeer.jsoncode.JsonCode;
import org.junit.Test;

/**
 * program: jsoncode
 * description: ${description}
 * author: lujinfei
 * create: 2019-02-17 10:49
 **/
public class JsonCodeTest {



    @Test
    public void testkey() {

        String json = "{1 : {123 :\"vvvvv\",   \"fg\"     : { \"2\" :\"ererer\",\"list\":[1,eeee,{\"\\[\"}]}}}";

        String code = JsonCode.getValue(json,"$.1.fg.2");

        System.out.println(code);
    }

    @Test
    public void testkey2() {

        String json = "{\"json\":{\"a\":{\"www\":\"ff\",\"rrr\":[\"v1\",\"v2\"]},\"b\":{\"www\":\"4567ttt\",\"rrr\": [\"v1\", \"v2\"]},\"vv\":5678}}";

        String code = JsonCode.getValue(json,"$.json.b");

        System.out.println(code);
    }

    @Test
    public void testList() {

        String json = "{\"ss\":{\"sss\":\"vvvvv\",\"fg\":{\"f\":\"ererer\",\"list\":[1,eeee,{\"\\[\"}]}}}";

        String code = JsonCode.getValue(json,"$.ss.fg.list");

        System.out.println(code);
    }

    @Test
    public void testListArray() {

        String json = "{\"ss\":{\"sss\":\"vvvvv\",\"fg\":{\"f\":\"ererer\",\"list\":[1,eeee,{\"\\[\"}]}}}";

        String[] code = JsonCode.getValueList(json,"$.ss.fg.list");

        for(int i = 0;i<code.length; i++) {
            System.out.println(i + ":" + code[i]);
        }
    }

    @Test
    public void testListRegular() {
        String json = "{\"ss\":{\"sss\":\"vvvvv\",\"fg\":{\"f\":\"ererer\",\"list\":[1,eeee,{\"\\[\"}]}}}";

        String code = JsonCode.calExpressionResult(json,"listsize($.ss.fg.list)");

        System.out.println(code);
    }

    @Test
    public void testListRegular2() {
        String json = "{\"ss\":{\"sss\":\"vvvvv\",\"fg\":{\"f\":\"ererer\",\"list\":[1,eeee,{\"\\[\"}]}}}";

        String code = JsonCode.calExpressionResult(json,"(listsize($.ss.fg.list))");

        System.out.println(code);
    }

    @Test
    public void testListRegular21() {
        String json = "{\"ss\":{\"sss\":\"vvvvv\",\"fg\":{\"f\":\"ererer\",\"list\":[1,eeee,{\"\\[\"}]}}}";

        String code = JsonCode.calExpressionResult(json,"(listsize($.ss.fg.list) + listsize($.ss.fg.list)) * (1+listsize($.ss.fg.list)) + listsize($.ss.fg.list) = 27");

        System.out.println(code);
    }

    @Test
    public void testListRegular3() {
        String json = "{\"ss\":{\"sss\":\"vvvvv\",\"fg\":{\"f\":\"ererer\",\"list\":[133,eeee,{\"\\[\"}]}}}";

        String code = JsonCode.calExpressionResult(json,"listget($.ss.fg.list , 1)");

        System.out.println(code);
    }

    @Test
    public void testListRegular4() {
        String json = "{\"ss\":{\"sss\":\"vvvvv\",\"fg\":{\"f\":\"ererer\",\"list\":[{\"dfv\":8}]}}}";

        String code = JsonCode.calExpressionResult(json,"listfind($.ss.fg.list , dfv, 8)");

        System.out.println(code);
    }

    @Test
    public void testListRegular7() {
        String json = "{\"ss\":{\"sss\":\"vvvvv\",\"fg\":{\"f\":\"ererer\",\"list\":[{\"dfv\":8,\"tg\":\"sfvgbggb\"},{\"rrr\":7}]}}}";

        String code = JsonCode.calExpressionResult(json,"listfind($.ss.fg.list , rrr, 7).rrr");

        System.out.println(code);
    }



}
