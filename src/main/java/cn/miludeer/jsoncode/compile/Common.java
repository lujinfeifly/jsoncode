package cn.miludeer.jsoncode.compile;

/**
 * program: jsoncode
 * description: 判断字符类型的类
 * author: lujinfei
 * create: 2019-02-22 10:42
 **/
public class Common {
    public static boolean isLetter(char ch){   //isLetter 标识符
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch == '\\') return true;
        else return false;
    }

    public static boolean isDigit(char ch){    //isDigit 常数
        if (ch >= '0' && ch <= '9') return true;
        else return false;
    }

    public static boolean isOperators(char ch){// isOperators 运算符
        if (ch == '+' || ch == '*' || ch == '-' || ch == '/' || ch == '=' || ch == '<' || ch == '>' || ch == '|' || ch == '&') return true;
        else return false;
    }

    public static boolean isDelimiter(char ch){// isDelimiter 界符
        if (ch == ',' || ch == ';' || ch == '(' || ch == ')' || ch == '[' || ch == ']' || ch == '{' || ch == '}' || ch == '#') return true;
        else return false;
    }

    public static boolean isBlank(char ch){
        if (ch == ' ' || ch == '\t' || (int)ch == 160) return true;
        else return false;
    }

    public static boolean isDot(char ch) {
        if(ch == '.') return true;
        else return false;
    }
}
