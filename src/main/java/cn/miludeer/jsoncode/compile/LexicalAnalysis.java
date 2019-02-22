package cn.miludeer.jsoncode.compile;

import java.util.LinkedList;

import static cn.miludeer.jsoncode.compile.Common.*;

/**
 * program: jsoncode
 * description: 词法分析过程
 * author: lujinfei
 * create: 2019-02-22 10:37
 **/
public class LexicalAnalysis {

    /**
     * 字符常数的码为1，数字常数数为2，保留字为3，运算符为4，界符为5，json路径为6
     * @param line
     */

    public static String[] key = {"size"};

    public static int keyLen = 2;

    public static LinkedList<LexicalItem> parse(String line) {

        LinkedList<LexicalItem> ret = new LinkedList<LexicalItem>();
        int len = line.length();
        for(int i=0;i<len;i++) {
            int b = 0;   // 类型编号
            int begin = 0, end = 0;
            String temp;
            if (isBlank(line.charAt(i))){
                continue;
            } else {
                if (isLetter(line.charAt(i)))      //是否为字母
                {
                    begin = i;
                    do
                    {
                        i++;
                    } while (isDigit(line.charAt(i)) || isLetter(line.charAt(i)));   //常数||标识符
                    end = i;

                    temp = line.substring(begin, end);

                    //  计算关键字
                    int a = 0;
                    while(a < keyLen) {
                        if(temp.equals(key[a])) {
                            b = 3;
                            break;
                        }
                    }

                    b = 1;

                    LexicalItem item = new LexicalItem(b, temp);
                    ret.addLast(item);
                    // todo加入
                } else if (isDigit(line.charAt(i))) {
                    begin = i;
                    while (isDigit(line.charAt(i))){
                        i++;
                    }
                    end = i;
                    temp =  line.substring(begin, end);

                    LexicalItem item = new LexicalItem(2, temp);
                    ret.addLast(item);
                } else if (isDelimiter(line.charAt(i))) {      //界符
                    LexicalItem item = new LexicalItem(5, String.valueOf(line.charAt(i)));
                    i++;
                } else if (isOperators(line.charAt(i))) {      //运算符
                    LexicalItem item;
                    if ((line.charAt(i) == '>' || line.charAt(i) == '<') && line.charAt(i+1) == '=') {
                        item = new LexicalItem(4, line.substring(i, i+2));
                        i += 2;
                    }
                    else{
                        item = new LexicalItem(4, line.substring(i, i+1));
                        i+= 1;
                    }
                    ret.addLast(item);
                } else if(line.charAt(i) == '$') { // json
                    begin = i;
                    while (isDigit(line.charAt(i))
                            || isLetter(line.charAt(i))
                            || line.charAt(i) == '.') {
                        i++;
                    }
                    end = i;
                    temp =  line.substring(begin, end);
                    LexicalItem item = new LexicalItem(6, temp);
                    ret.addLast(item);
                }
                else{
                    // 其他
                }
            }
        }
        return ret;
    }
}
