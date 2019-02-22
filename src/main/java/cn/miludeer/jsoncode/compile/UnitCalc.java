package cn.miludeer.jsoncode.compile;

import cn.miludeer.jsoncode.JsonCode;

import java.util.List;

/**
 * program: jsoncode
 * description: ${description}
 * author: lujinfei
 * create: 2019-02-22 13:20
 **/
public class UnitCalc {
    public static String TwoCompare(String a, String b, String v) {
        if(v.charAt(0) == '=') {
            return String.valueOf(a.equals(b));
        }

        Integer ia = Integer.parseInt(a);
        Integer ib = Integer.parseInt(b);
        switch (v.charAt(0)) {
            case '>':
                if(v.length()==1) {
                    return String.valueOf(ia>ib);
                }
                return String.valueOf(ia>=ib);
            case '<':
                if(v.length()==1) {
                    return String.valueOf(ia<ib);
                }
                return String.valueOf(ia<=ib);
            case '+':
                return String.valueOf(ia + ib);
            case '-':
                return String.valueOf(ia - ib);
            case '*':
                return String.valueOf(ia * ib);
            case '/':
                return String.valueOf(ia / ib);
            default:
                return "null";
        }

    }

    public static String doProcedure(String json,String func, List<LexicalItem> param) {
        if(func.equals("count")) {
            if(param.size() != 1) {
                throw new RuntimeException();
            }
            return String.valueOf(JsonCode.getValueList(json, param.get(0).cm).length);
        } else {
            throw new RuntimeException();
        }
    }
}
