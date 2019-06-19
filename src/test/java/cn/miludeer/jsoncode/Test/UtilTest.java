package cn.miludeer.jsoncode.Test;

import cn.miludeer.jsoncode.util.StringSplit;
import org.junit.Test;

/**
 * program: jsoncode
 * <p>
 * description: ${description}
 * <p>
 * author: lujinfei
 * <p>
 * create: 2019-06-19 23:52
 **/
public class UtilTest {

    @Test
    public void aa() {
        String[] ret = StringSplit.SplitWithDotsInkey("$.abc.dfg.gg.\"er.ty\".yy");

        System.out.println(ret);
    }
}
