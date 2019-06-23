package cn.miludeer.jsoncode;

import java.util.LinkedList;

/**
 * program: jsoncode
 * <p>
 * description: ${description}
 * <p>
 * author: lujinfei
 * <p>
 * create: 2019-06-23 14:27
 **/
public class Util {
    public static String[] splitWithCompase(String abc) {
        if(abc == null) {
            return null;
        }

        LinkedList<String> ret = new LinkedList<String>();
        int len = abc.length();
        StringBuilder sb = new StringBuilder();
        int inc = 0;
        char before = 0x00;
        while(inc < len) {
            char now = abc.charAt(inc);
            if(before == '\\') {
                sb.deleteCharAt(sb.length() - 1);
                sb.append(now);
            } else {
                if(now == '.') {
                    ret.addLast(sb.toString());
                    sb = new StringBuilder();
                } else {
                    sb.append(now);
                }
            }
            before = now;
            inc++;
        }
        ret.addLast(sb.toString());

        int lenret = ret.size();
        String[] arrays = new String[lenret];
        for(int i = 0; i<lenret; i++) {
            arrays[i] = ret.get(i);
        }
        return arrays;
    }
}
