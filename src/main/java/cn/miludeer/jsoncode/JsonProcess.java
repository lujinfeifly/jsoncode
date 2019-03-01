package cn.miludeer.jsoncode;

import cn.miludeer.jsoncode.compile.Common;
import cn.miludeer.jsoncode.compile.LexicalAnalysis;
import cn.miludeer.jsoncode.compile.LexicalItem;
import cn.miludeer.jsoncode.compile.UnitCalc;
import cn.miludeer.jsoncode.element.IndexResult;
import cn.miludeer.jsoncode.exception.JsonCodeException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * program: jsoncode
 * description: ${description}
 * author: lujinfei
 * create: 2019-02-20 13:14
 **/
public class JsonProcess {

    protected static String calExpression(String json, String expression) {
        LinkedList<LexicalItem> list = LexicalAnalysis.parse(expression);
        // todo 依次处理元素 字符常数的码为1，数字常数数为2，保留字为3，运算符为4，界符为5，json路径为6, json 不带$的为7

        Stack<LexicalItem> stack = new Stack<LexicalItem>();

        int size = list.size();
        for(int i= 0 ; i< size; i++) {
            LexicalItem item = list.get(i);
            switch (item.type) {
                case 3:                // 函数的使用
                    stack.push(item);
                    break;
                case 4:
                    stack.push(item);
                    break;
                case 5:  // 目前认为只有（）
                    List<LexicalItem> param = new ArrayList<LexicalItem>();
                    if(item.cm.charAt(0) == ')') {
                        LexicalItem item2 = stack.pop();
                        if(item2.type == 1) {
                            LexicalItem item3 = stack.pop();
                            if(item3.cm.charAt(0) == '(') { // 优先级的括号
                                param.add(item2);
                            } else if(item3.cm.charAt(0) == ',') {
                                LexicalItem item4 = stack.pop();
                                LexicalItem item5 = stack.pop();
                                param.add(item2);
                                param.add(item4);
                                while (item4 != null && (item4.type == 1 || item4.type == 2)
                                        && item5.cm.charAt(0) == ',') {
                                    item4 = stack.pop();
                                    item5 = stack.pop();
                                    param.add(item4);
                                }

                            }
                            if(!stack.isEmpty()) {
                                LexicalItem item6 = stack.pop();
                                if (item6 != null && item6.type == 1) { // 准备调用函数
                                    String bb = UnitCalc.doProcedure(item6.cm, param);
                                    stack.push(new LexicalItem(1, bb));
                                } else {
                                    stack.push(item6);
                                    stack.push(param.get(0));
                                }
                            } else {
                                stack.push(item2);
                            }
                        }
                    } else {
                        stack.push(item);
                    }
                    break;
                case 1:
                case 2:
                case 6:
                    if(item.type == 1 && "(".equals(list.get(i+1).cm)) { // 成立标示是个函数
                        stack.push(item);
                        continue;
                    }

                    LexicalItem th;
                    if(item.type == 6) {
                        String value = JsonCode.getValue(json, item.cm);
                        th = new LexicalItem(1, value);
                    } else {
                        th = item;
                    }
                    if(stack.empty()) {
                        stack.push(th);
                    } else {
                        LexicalItem item2 = stack.pop();
                        if(item2.type == 4) {
                            LexicalItem item3 = stack.pop();
                            String temp = UnitCalc.TwoCompare(item3.cm, th.cm, item2.cm);
                            stack.push(new LexicalItem(1, temp));
                        } else {
                            stack.push(item2);
                            stack.push(new LexicalItem(1, th.cm));
                        }
                    }
                    break;
                case 7:  // 这个是计算前面表达式的值的内容，取stack中的数。
                    LexicalItem itemFore = stack.pop();
                    if(itemFore == null) {
                        throw new RuntimeException(); // 内容为空
                    }
                    if(itemFore.type != 1) {
                        throw new RuntimeException(); // 内容不对
                    }
                    String calcRes = JsonCode.getValue(itemFore.cm, "$" + item.cm);
                    stack.push(new LexicalItem(1, calcRes));
                    break;
            }
        }

        LexicalItem item2 = stack.pop();
        if(item2 != null) {
            return item2.cm;
        }else {
            return "null";
        }
    }

    protected static String[] cutForList(String json) {
        List<String> list = new ArrayList<String>();

        int i = 1;
        boolean isContent2 = false;  // 引号包含的内容
        char temp = json.charAt(i);
        int floor = 0;

        IndexResult result = new IndexResult();
        result.a = i;

        while(true) {
            if(isContent2) {
                switch (temp) {
                    case '\\':
                        i++;
                        break;
                    case '"':
                        isContent2 = false;
                        break;
                }
            } else {
                switch (temp) {
                    case '"': // 如果遇到这种情况就说明有字符串
                        isContent2 = !isContent2;
                        break;
                    case ',':
                    case ']':
                        if(floor == 0) {
                            result.b = i;
                            list.add(json.substring(result.a, result.b));
                            result.a = i+1;
                        }
                        break;
                    case '{':
                        floor++;
                        break;
                    case '}':
                        floor--;
                        break;
                }
            }
            i++;

            if(i== json.length()) {
                break;
            }
            temp = json.charAt(i);
        }

        String[] ret = new String[list.size()];

        int index = 0;
        for(String a : list) {
            ret[index] = a;
            index++;
        }

        return ret;
    }

    protected static IndexResult anylise(String jsonStr, int beginId, int endId, String key){
        while(Common.isBlank(jsonStr.charAt(beginId))) {
            beginId++;
        }

        if(jsonStr.charAt(beginId) != '{' || beginId >= endId) {   // 如果第一个值不为{ 代表不是json，如果超过了，则数值有问题
            return null;
        }

        IndexResult result = new IndexResult();
        result.a = -1;

        boolean isContent = false;
        boolean isfake = false;
        boolean enterKey = true;
        boolean isMatch = false;

        for(int i = beginId + 1; i<endId; i++) {

            char temp = jsonStr.charAt(i);

            if(isfake) continue;        // 遇到转义的直接跳过去

            switch (temp) {
                case '\\':
                    isfake = true;
                    continue;
                case ',':
                    enterKey = true;
                    continue;
            }

            if(enterKey) {  // 如果是key，则进行匹配
                String thisKey;
                int begin = beginId;
                while(Common.isBlank(temp)) { // 去除空格
                    i++;
                    temp = jsonStr.charAt(i);
                }

                if(Common.isDigit(temp)) {  // 如果是数字
                    begin = i;
                    while(Common.isDigit(temp)) {
                        i++;
                        temp = jsonStr.charAt(i);
                    }
                    thisKey = jsonStr.substring(begin, i);
                } else {                    // 如果是字符串
                    if(temp != '"') {
                        throw new JsonCodeException(1001);
                    }
                    i++;
                    temp = jsonStr.charAt(i);
                    begin = i;
                    char fore = ' ';
                    while(temp != '"' && fore != '\\') {
                        i++;
                        fore = temp;
                        temp = jsonStr.charAt(i);
                    }
                    thisKey = jsonStr.substring(begin, i);
                    i++;
                }
                temp = jsonStr.charAt(i);
                while(Common.isBlank(temp)) { // 去除空格
                    i++;
                    temp = jsonStr.charAt(i);
                }

                if(temp != ':') {
                    throw new JsonCodeException(1001);
                } else { // key已经成立
                    if(thisKey.equals(key)) {
                        isMatch = true;
                    } else {
                        isMatch = false;
                    }
                    enterKey = false;
                    continue;
                }
            }

            if(!enterKey) {
                while (Common.isBlank(temp)) { // 去除空格
                    i++;
                    temp = jsonStr.charAt(i);
                }

                    if (temp == '"') { // 值是string
                        i++;
                        result.a = i;
                        temp = jsonStr.charAt(i);
                        while (temp != '"') {
                            i++;
                            temp = jsonStr.charAt(i);
                            if (temp == '\\') {
                                i += 2;
                                temp = jsonStr.charAt(i);
                            }
                        }
                        result.b = i;
                        if(isMatch) {
                            return result;
                        } else {
                            continue;
                        }
                    } else if (temp == '[') {  // 数组的方式。
                        result.a = i;
                        i++;
                        boolean isCintent2 = false;
                        temp = jsonStr.charAt(i);
                        int floor = 0;
                        floor++;
                        cycle2:
                        while (true) {
                            if (isCintent2) {
                                switch (temp) {
                                    case '\\':
                                        i++;
                                        break;
                                    case '"':
                                        isCintent2 = false;
                                        break;
                                }
                            } else {
                                switch (temp) {
                                    case '[':
                                        floor++;
                                        break;
                                    case ']':
                                        floor--;
                                        if (floor == 0) {
                                            result.b = i + 1;
                                            break cycle2;
                                        }
                                        break;
                                    case '"':
                                        isCintent2 = !isCintent2;
                                        break;
                                    case '\\':
                                        i++; // 跳过下一个
                                        break;
                                }
                            }
                            i++;
                            temp = jsonStr.charAt(i);
                        }
                        if(isMatch) {
                            return result;
                        } else {
                            continue;
                        }
                    } else {  // 值里面可能是int或还是一个json
                        result.a = i;
                        int floor = 0;
                        boolean isCintent2 = false;
                        cycle:
                        while (true) {
                            if (isCintent2) {
                                switch (temp) {
                                    case '\\':
                                        i++; // 跳过下一个
                                        break;
                                    case '"':
                                        isCintent2 = false;
                                        break;
                                }
                            } else {
                                switch (temp) {
                                    case '\\':
                                        i++; // 跳过下一个
                                        break;
                                    case '"':
                                        isCintent2 = !isCintent2;
                                        break;
                                    case '{':
                                        floor++;
                                        break;
                                    case '}':
                                        if (floor == 0) {
                                            result.b = i;
                                            break cycle;
                                        } else {
                                            floor--;
                                        }
                                        break;
                                    case ',':
                                        if (floor == 0) { // 这里就结束了，返回
                                            result.b = i;
                                            i--;
                                            break cycle;
                                        }
                                }
                            }
                            i++;
                            temp = jsonStr.charAt(i);
                        }
                        if(isMatch) {
                            return result;
                        } else {
                            continue;
                        }
                    }
            }
        }
        result.a = -1;
        return result;
    }


}
