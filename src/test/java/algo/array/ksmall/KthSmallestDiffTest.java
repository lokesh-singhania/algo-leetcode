package algo.array.ksmall;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class KthSmallestDiffTest {

    KthSmallestDiff service = new Incremental();

    @Test(dataProvider = "data")
    void test(int[] a,int k, int expected){
        Assert.assertEquals(service.smallestDistancePair(a,k),expected);
    }

    @DataProvider(name="data")
    public Object[][] data(){
        return new Object[][]{
                new Object[]{new int[]{1,1,1},2,0},
                new Object[]{new int[]{1,6,1},3,5}
        };
    }
}
