package cn.miludeer.jsoncode.compile;

/**
 * program: jsoncode
 * description: 词法分析的结果存储单元
 * author: lujinfei
 * create: 2019-02-22 11:40
 **/
public class LexicalItem {
    public int type;
    public String cm;

    public LexicalItem(int type, String cm) {
        this.type = type;
        this.cm = cm;
    }
}
