package cn.miludeer.jsoncode.compile;

/**
 * program: jsoncode
 * <p>
 * description: ${description}
 * <p>
 * author: lujinfei
 * <p>
 * create: 2019-02-22 10:42
 **/
public class Common {
    public static boolean isLetter(char ch){   //isLetter 标识符
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) return true;
        else return false;
    }

    public static boolean isDigit(char ch){    //isDigit 常数
        if (ch >= '0' && ch <= '9') return true;
        else return false;
    }

    public static boolean isOperators(char ch){// isOperators 运算符
        if (ch == '+' || ch == '*' || ch == '-' || ch == '/' || ch == '=' || ch == '<' || ch == '>') return true;
        else return false;
    }

    public static boolean isDelimiter(char ch){// isDelimiter 界符
        if (ch == ',' || ch == ';' || ch == '.' || ch == '(' || ch == ')' || ch == '[' || ch == ']' || ch == '{' || ch == '}' || ch == '#') return true;
        else return false;
    }

    public static boolean isBlank(char ch){
        if (ch == ' ' || ch == '\t') return true;
        else return false;
    }
}
