package cn.miludeer.jsoncode;

import cn.miludeer.jsoncode.element.IndexResult;

import java.util.ArrayList;
import java.util.List;

/**
 * program: jsoncode
 * <p>
 * description: ${description}
 * <p>
 * author: lujinfei
 * <p>
 * create: 2019-02-20 13:14
 **/
public class JsonProcess {

    public static String[] cutForList(String json) {
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

    public static IndexResult anylise(String jsonStr, int beginId, int endId, String key){
        if(jsonStr.charAt(beginId) != '{') {
            return null;
        }

        IndexResult result = new IndexResult();
        result.a = -1;

        boolean isContent = false;
        boolean isfake = false;
        boolean enterKey = true;
        boolean isMatch = false;

        for(int i=beginId + 1; i<endId; i++) {

            char temp = jsonStr.charAt(i);

            if(isfake) continue;        // 遇到转义的直接跳过去

            switch (temp) {
                case '\\':
                    isfake = true;
                    continue;
                case ':':
                    enterKey = false;
                    continue;
                case ',':
                    enterKey = true;
                    continue;
            }

            if(enterKey) {  // 如果是key，则进行匹配
                if(temp == '"') {
                    i++;
                    temp = jsonStr.charAt(i);
                }
                int j = 0;
                int keyLen = key.length();
                while(j<keyLen && temp == key.charAt(j)) {
                    j++;
                    i++;
                    temp = jsonStr.charAt(i);
                    if(temp == '"' || temp == ':') {
                        break;
                    }
                }
                if(j == key.length() && jsonStr.charAt(i) == '"') { // 匹配上
                    isMatch = true;
                    continue;
                } else { // 没有匹配上

                }
            }

            if(!enterKey && isMatch) {   // 到了value，且是内容，且是匹配上的
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
                    return result;
                } else if(temp == '[') {  // 数组的方式。
                    result.a = i;
                    i++;
                    boolean isCintent2 = false;
                    temp = jsonStr.charAt(i);
                    int floor = 0;
                    floor++;
                    cycle2:             while(true) {
                        if(isCintent2) {
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
                                    floor ++;
                                    break;
                                case ']':
                                    floor--;
                                    if(floor == 0) {
                                        result.b = i+1;
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
                    return result;
                } else{  // 值里面可能是int或还是一个json
                    result.a = i;
                    int floor = 0;
                    boolean isCintent2 = false;
                    cycle:              while(true) {
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
                                    if(floor == 0) {
                                        result.b = i;
                                        break cycle;
                                    } else {
                                        floor--;
                                    }
                                    break;
                                case ',':
                                    if (floor == 0) { // 这里就结束了，返回
                                        result.b = i;
                                        break cycle;
                                    }
                            }
                        }
                        i++;
                        temp = jsonStr.charAt(i);
                    }
                    return result;
                }
            }
        }
        return result;
    }
}