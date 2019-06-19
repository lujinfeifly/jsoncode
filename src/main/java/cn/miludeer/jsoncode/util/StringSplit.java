package cn.miludeer.jsoncode.util;

import cn.miludeer.jsoncode.exception.JsonCodeException;

import java.util.ArrayList;

/**
 * program: jsoncode
 * description: 字符串进行切分处理
 * author: lujinfei
 * create: 2019-06-19 22:47
 **/
public class StringSplit {

    public static String[] SplitWithDotsInkey(String path) {
        if(path == null) {
            return null;
        }

        ArrayList<String> list = new ArrayList<String>();
        int off = 0;
        int next = 0;
        int len = path.length();
        boolean inquata = false;
        for(int i=0; i<len; i++) {
            if(i == len - 1) { // 如果已经是最后一个了
                String temp = null;
                switch (path.charAt(i)) {
                    case '.':
                        throw new JsonCodeException(30001, "");
                    case '"':
                        if(inquata) {
                            inquata = false;
                            temp = path.substring(off + 1, len - 1);
                            list.add(temp);
                        } else {
                            throw new JsonCodeException(30001, "");
                        }
                        break;
                    default:
                        temp = path.substring(off, len);
                        list.add(temp);
                }
                break;
            }

            char b = path.charAt(i);
            switch(b) {
                case '.':
                    if(!inquata) {
                        next = i;
                        String temp = null;
                        if(path.charAt(off) == '"' && path.charAt(next - 1) == '"') {
                            temp = path.substring(off + 1, next - 1);
                        } else {
                            temp = path.substring(off, next);
                        }
                        list.add(temp);
                        off = i + 1;
                    }
                    break;
                case '"':
                    if(inquata) {
                        if(path.charAt(i+1) != '.' ) {
                            throw new JsonCodeException(30001, "");
                        }
                        inquata = false;
                    } else {
                        if(path.charAt(i-1) != '.') {
                            throw new JsonCodeException(30001, "");
                        }
                        inquata = true;
                    }
                    break;
                default:
            }
        }
        if(inquata) {
            throw new JsonCodeException(30001, "");
        }

        String[] ret = new String[list.size()];
        int i = 0;
        for (String item:
             list) {
            ret[i] = item;
            i++;
        }

        return ret;
    }
}
