package cn.miludeer.jsoncode;

import cn.miludeer.jsoncode.element.IndexResult;

import static cn.miludeer.jsoncode.JsonProcess.*;

/**
 * program: jsoncode
 * description: 操作方法入口类，这里面是所有调用的方法的集合地。
 * author: lujinfei
 * create: 2019-02-17 10:33
 **/
public class JsonCode {

    /**
     * 从某个字符串获取制定目标的值。
     * @param jsonStr 目标json字符串
     * @param expression 指定标识
     * @return 以字符串返回的值，如果类型为list直接返回json的列表字符串
     */
    public static String getValue(String jsonStr, String expression) {
        if(jsonStr == null || jsonStr.length() == 0 ||
                expression == null || expression.length() == 0 || expression.charAt(0) != '$') {
            return null;
        }

        String[] list = expression.split("\\.");
        if(!list[0].equals("$")) {
            return null;
        }

        int count = list.length;
        int a = 0;
        int b = jsonStr.length();
        for(int i=1; i<count; i++) {
            IndexResult result = anylise(jsonStr, a,b,list[i]);
            a = result.a;
            b = result.b;
            if(a == -1) {
                return null;
            }
        }

        return jsonStr.substring(a,b);
    }

    /**
     * 从json字符串中火气指定标识的list的列表，返回为String[],如果对象不为数组结构的，则返回null
     * @param jsonStr 目标json字符串
     * @param expression 指定标示
     * @return 返回的字符串表示的列表
     */
    public static String[] getValueList(String jsonStr, String expression) {
        String dis = getValue(jsonStr, expression);
        if(dis == null || dis.length()<1 || dis.charAt(0) != '[') {
            return null;
        }

        return cutForList(dis);
    }


    /**
     * 计算表达式结果
     * @param jsonStr 目标json字符串
     * @param expression 指定表达式
     * @return 计算的结果
     */
    public String calExpressionResult(String jsonStr, String expression) {
        if(jsonStr == null || expression == null) {
            return null;
        }

        return calExpression(jsonStr, expression);
    }

}
