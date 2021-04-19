package algo.april;

import algo.april.impl.hw.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class HammingWeightTest {

    private HammingWeight service;

    public HammingWeightTest(HammingWeight service) {
        this.service = service;
    }

    @Factory
    private static Object[] factory(){
        return new Object[]{
                new HammingWeightTest(new BitShift()),
                new HammingWeightTest(new InbuiltMethod()),
                new HammingWeightTest(new Masking()),
                new HammingWeightTest(new MaskingStream()),
                new HammingWeightTest(new BitManipulation())
        };
    }

    @DataProvider
    private Object[][] data(){
        return new Object[][]{
                {0b1,1},
                {0b11111111111111111111111111111101,31}
        };
    }

    @Test(dataProvider = "data")
    public void test(int input, int bits){
        Assert.assertEquals(service.hammingWeight(input),bits);
    }
}
