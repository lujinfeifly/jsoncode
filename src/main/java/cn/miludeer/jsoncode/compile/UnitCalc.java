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

        if(v.charAt(0) == '|' || v.charAt(0) == '&') {
            boolean ba = a.equals("true");
            boolean bb = b.equals("true");

            switch(v.charAt(0)) {
                case '|':
                    return String.valueOf(ba || bb);
                case '&':
                    return String.valueOf(ba && bb);
                default:
                    return "null";
            }
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

    public static String doProcedure(String func, List<LexicalItem> param) {
        if(func.equals("listsize")) {
            if(param.size() != 1) {
                throw new RuntimeException();
            }
            return String.valueOf(JsonCode.getValueList(param.get(0).cm, "$").length);
        } else if(func.equals("listfind")) {
            if (param.size() != 3) {
                throw new RuntimeException();
            }
            return JsonCode.findJson(param.get(2).cm, param.get(1).cm, param.get(0).cm);
        } else if(func.equals("listget")) {
            if(param.size() != 2) {
                throw new RuntimeException();
            }
            return String.valueOf(JsonCode.getValueList(param.get(1).cm, "$")[Integer.parseInt(param.get(0).cm)]);
        } else {
            throw new RuntimeException();
        }
    }
}
