package hu.bme.mit.train.system;

import org.junit.Assert;
import org.junit.Test;

public class SelfTest {
    private int testval = 5;
    @Test
    public void selfTest(){
        Assert.assertEquals(5, testval);
    }


}
