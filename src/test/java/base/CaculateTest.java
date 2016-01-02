package base;

import org.junit.Assert;
import org.junit.Test;
import simple.Caculate;

/**
 * Created by bruce on 2/7/2015.
 */
public class CaculateTest {
    @Test
    public void testCaculate() {
        String input = "5*((13*6-5)-(4*5+6)+7)-7";
        double res = Caculate.caculating(input);
        double real = 5*((13*6-5)-(4*5+6)+7)-7;
        Assert.assertEquals(real, res, 0.00000001);
    }

}
