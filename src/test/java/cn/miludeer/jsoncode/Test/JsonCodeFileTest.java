package cn.miludeer.jsoncode.Test;

import java.io.File;

import org.junit.Test;

import cn.miludeer.jsoncode.fileformat.FileTemplate;
import cn.miludeer.jsoncode.fileformat.FileTemplate.Line;

/**
 * @author lujinfei
 * Created on 2021-05-07
 */
public class JsonCodeFileTest {

    @Test
    public void bb() {
        try {
//            Line line = new Line(1, "adddd {$.fggg} dsfvg {vvtgg()}sfvbgrbbtt  ");
//            Line line2 = new Line(1, " for {$.fggg} ");
//            Line line3 = new Line(1, "end ");

            String value = "{\"abc\": [{\"v\": 123, \"inner\": [{},{},{},{}]}, {\"v\": \"iop\",\"inner\": [{},{},{}]}]}";

            File file = new File("/Users/lujinfei/data/et.ff");
            FileTemplate template = new FileTemplate(file);

            String ret = template.parseResult(value);

            System.out.println("aaaaa: \n" + ret);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
