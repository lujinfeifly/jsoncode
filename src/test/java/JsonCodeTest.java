import cn.miludeer.jsoncode.JsonCode;
import org.junit.Test;

/**
 * program: jsoncode
 * <p>
 * description: ${description}
 * <p>
 * author: lujinfei
 * <p>
 * create: 2019-02-17 10:49
 **/
public class JsonCodeTest {

    @Test
    public void test() {

        String json = "{\"ss\":{\"sss\":\"vvvvv\",\"fg\":{\"f\":\"ererer\"}}}";

        String code = JsonCode.getValue(json,"*.ss.fg");

        System.out.println(code);
    }

}
