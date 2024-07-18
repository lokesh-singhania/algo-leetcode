package algo.random.open.lock;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OpenLockTest {

    OpenLock service= new OpenLockBfs();

    @Test(dataProvider = "data")
    void test(String[] deadends, String target, int result){
        int calculated = service.openLock(deadends, target);
        Assert.assertEquals(calculated,result);
    }

    @DataProvider(name = "data")
    public Object[][] data(){
        return new Object[][]{
            new Object[]{new String[]{},"0000",0}
                ,new Object[]{new String[]{},"0001",1}
        };
    }
}
