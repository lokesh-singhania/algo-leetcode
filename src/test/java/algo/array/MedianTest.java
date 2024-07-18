package algo.array;

import algo.array.median.Median;
import algo.array.median.OneAfterAnother;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MedianTest {

    Median service = new OneAfterAnother();

    @Test(dataProvider = "data")
    void test(int[] a1,int[] a2,double expected ){
        Assert.assertEquals(service.findMedianSortedArrays(a1,a2),expected);
    }

    @DataProvider(name="data")
    public Object[][] data(){
        return new Object[][]{
                new Object[]{new int[]{1,3},new int[]{2},2},
                new Object[]{new int[]{1},new int[]{2},1.5},
                new Object[]{new int[]{1,3},new int[]{2,4},2.5},
                new Object[]{new int[]{2,3},new int[]{1,4},2.5},
                new Object[]{new int[]{2,2,4,4}, new int[]{2,2,4,4},3},
                new Object[]{new int[]{0,0},new int[]{0,0},0}
        };
    }
}
