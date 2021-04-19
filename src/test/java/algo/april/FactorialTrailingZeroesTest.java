package algo.april;

import algo.april.impl.ftz.BruteForce;
import algo.april.impl.ftz.Elegant;
import algo.april.impl.ftz.Recursive;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactorialTrailingZeroesTest {

    private FactorialTrailingZeroes service;


    public FactorialTrailingZeroesTest(FactorialTrailingZeroes service) {
        this.service = service;
    }

    @Factory
    private static Object[] factory(){
        return new Object[]{
                new FactorialTrailingZeroesTest(new Elegant()),
                new FactorialTrailingZeroesTest(new Recursive())
        };
    }

    @DataProvider
    private Object[][] data() {
        return new Object[][]{
                {1,0,"lessThanFiveHasNoTrailingZeroes"},
                {5,1,"FiveFactorialHasOneTrailingZero"},
                {9,1,"Numbers before 10 have One Trailing Zero"},
                {25,6,"Powers of five are counted correctly"}
        };
    }

    @Test(dataProvider = "data")
    public void test(int number, int trailingZeroes, String message) {
        Assert.assertEquals(service.trailingZeroes(number),trailingZeroes,message);
    }

}
