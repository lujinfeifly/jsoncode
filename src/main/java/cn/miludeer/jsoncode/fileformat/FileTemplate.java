package cn.miludeer.jsoncode.fileformat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import cn.miludeer.jsoncode.JsonCode;

/**
 * @author lujinfei
 * Created on 2021-05-07
 */
public class FileTemplate {

    private static final String END = "ERROR_END_END";

    private final List<Line>  templates;


    public FileTemplate(File file) throws Exception {
        templates = new ArrayList<Line>();
        try{
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String s = null;
            int index = 0;
            while((s = br.readLine())!=null){  //使用readLine方法，一次读一行
                index ++ ;  // 每次读取一行
                templates.add(new Line(index, s));
            }
            br.close();
        }catch(Exception e){
            // 跑出错误
            e.printStackTrace();
        }

        int loop = 0;
        for(Line line: templates) {
            if(line.index == 10) {
                loop ++;
            }
            if(line.index == 11) {
                loop --;
            }
        }
        if(loop != 0) {
            throw new Exception();
        }
    }


    public String parseResult(String jsonString) {
        StringBuffer sb = new StringBuffer();
        int n = 0;
        int size = templates.size();

        String loopTemp = null;
        Integer loopBegin = null;
        boolean isback = false;
        Stack<StackItem> stack = new Stack<StackItem>();
        for(; n < size; n++) {
            Line line = templates.get(n);
            switch (line.type) {
                case 10:  // 循环开始
                    if(!isback) {
                        String[] temp = JsonCode.getValueList(jsonString, line.words.get(1).content);
                        stack.push(new StackItem(temp));
                    }
                    StackItem item = stack.peek();
                    loopTemp = item.getNext();
                    loopBegin = n;
                    continue;
                case 11:  // 循环结束
                    if(END.equals(loopTemp)) { // 结束
                        stack.pop();
                    } else {                               // 没有结束，跳转到下一个
                        n = loopBegin - 1;
                        isback = true;
                    }
                    continue;
                default: // 非循环等段落式的内容
                {
                    if(END.equals(loopTemp)) {
                        continue;
                    }
                    for(Word word: line.words) {
                        if(word.type == 0) {
                            sb.append(word.content);
                        } else {
                            if(word.content.startsWith("$")) { // 整个结构替换
                                try {
                                    String tempDefault = JsonCode.getValue(jsonString, word.content);
                                    sb.append(tempDefault);
                                } catch (Exception ex) {
                                }
                            }
                            if(word.content.startsWith("@")) { // 段落替换
                                try {
                                    String tempDefault = JsonCode.getValue(loopTemp,
                                            word.content.replace('@','$'));
                                    sb.append(tempDefault);
                                } catch (Exception ex) {
                                }
                            }
                        }
                    }
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static class StackItem {
        List<String> list;
        int index;

        public StackItem(List<String> list) {
            this.list = list;
            this.index = -1;
        }

        public StackItem(String[] list) {
            this.list = Arrays.asList(list);
            this.index = -1;
        }

        public String getNext() {
            int size = (list == null)?0:list.size();
            this.index ++ ;
            if(this.index > size - 1) {
                return END;
            }
            return list.get(this.index);
        }
    }


    public static class Line {
        private int index;
        private int type;         // 行的类型 (10 for 循环)(11 end for)
        private List<Word> words;

        public Line(int index, String content) throws Exception {
            this.index = index;

            // 初始化words
            words = new ArrayList<Word>();
            int len = content.length();
            StringBuffer sb = new StringBuffer();
            boolean begin = true;

            for(int i = 0; i < len; i++) {
                char x = content.charAt(i);

                if(x == '{') {    // 开始
                    words.add(new Word(sb.toString(), 0));
                    sb = new StringBuffer();
                    begin = true;
                    continue;
                }

                if(x == '}') {
                    if(!begin) {
                        throw new Exception("");
                    }
                    words.add(new Word(sb.toString(), 1));
                    sb = new StringBuffer();
                    continue;
                }

                sb.append(x);
            }
            String temp = sb.toString();
            if(temp.length() != 0) {
                words.add(new Word(temp, 0));
            }


            // 检查关键字
            int count = words.size();
            int i = 0;
            for(Word word:words) {
                if("for".equals(word.content.trim().toLowerCase())) {  // 循环开始
                    if(i > 0 || count < 2 || count > 3) {
                        throw new Exception();
                    }
                    if(words.get(1).type == 0) {
                        throw new Exception();
                    }
                    if(count == 3 && !"".equals(words.get(2).content.trim())) {
                        throw new Exception();
                    }
                    type = 10;
                }
                if("end".equals(word.content.trim().toLowerCase())) {  // 循环结束
                    if(i > 0) {
                        throw new Exception();
                    }
                    if(count != 1) {
                        throw new Exception();
                    }
                    type = 11;
                }
                i++;
            }
        }
    }

    public static class Word {
        private String content;
        private int type;

        public Word(String content, int type) {
            this.content = content;
            this.type = type;
        }
    }
}
