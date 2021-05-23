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

        String[] list = Util.splitWithCompase(expression);//expression.split("\\.");
        if(!list[0].equals("$")) {
            return null;
        }

        int count = list.length;
        int a = 0;
        int b = jsonStr.length();
        for(int i=1; i<count; i++) {
            IndexResult result = anylise(jsonStr, a,b,list[i]);
            if(result == null) {
                return null;
            }
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
        if("[]".equals(dis)) {
            return new String[]{};
        }

        return cutForList(dis);
    }

    /**
     * list查找某个key为value的json 元素。条件是jsonStr为list结构，每个元素为正常的json
     * @param jsonStr 目标json字符串
     * @param key json中的key值
     * @param value 对应的value对照值
     * @return 返回满足条件的json字符串
     */
    public static String findJson(String jsonStr, String key, String value) {
        String[] list = getValueList(jsonStr, "$");
        for(int i = 0;i< list.length; i++) {
            String fetch = getValue(list[i], "$."+key);
            if(value.equals(fetch)) {
                return list[i];
            }
        }
        return null;
    }


    /**
     * 计算表达式结果
     * @param jsonStr 目标json字符串
     * @param expression 指定表达式
     * @return 计算的结果
     */
    public static String calExpressionResult(String jsonStr, String expression) {
        if(jsonStr == null || expression == null) {
            return null;
        }

        return calExpression(jsonStr, expression);
    }

}
