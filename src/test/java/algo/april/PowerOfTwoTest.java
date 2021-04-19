package algo.april;

import algo.april.impl.pot.BitCount;
import algo.april.impl.pot.BitManipulation;
import algo.april.impl.pot.Maths;
import algo.april.impl.pot.Recursive;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class PowerOfTwoTest {

    private PowerOfTwo service;

    public PowerOfTwoTest(PowerOfTwo service) {
        this.service = service;
    }

    @Factory
    private static Object[] factory(){
        return new Object[]{
          new PowerOfTwoTest(new BitManipulation()),
                new PowerOfTwoTest(new Maths()),
                new PowerOfTwoTest(new Recursive()),
                new PowerOfTwoTest(new BitCount())
        };
    }

    @DataProvider
    private  Object[][] data(){
        return  new Object[][]{
                {0,false},
                {1,true},
                {2,true},
                {10, false},
                {256,true},
                {65536,true},
                {-2,false}
        };
    }

    @Test(dataProvider = "data")
    public void test(int number,boolean result){
        Assert.assertEquals(service.isPowerOfTwo(number),result);
    }
}
