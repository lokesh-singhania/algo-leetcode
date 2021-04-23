package algo.april;

import algo.april.impl.mn.BruteForce;
import algo.april.impl.mn.Lookup;
import algo.april.impl.mn.Math;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MissingNumberTest {

    private final MissingNumber service;

    public MissingNumberTest(MissingNumber service) {
        this.service = service;
    }

    @Factory
    private static Object[] tests() {
        return new Object[]{
                new MissingNumberTest(new BruteForce()),
                new MissingNumberTest(new Lookup()),
                new MissingNumberTest(new Math())
        };
    }

    @DataProvider
    private Object[][] data() {
        return new Object[][]{
                {new int[]{1, 2, 3}, 0},
                {new int[]{3, 2, 4, 0}, 1},
                {new int[]{2, 1, 0}, 3}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] numbers, int missingNumber) {
        assertEquals(service.missingNumber(numbers), missingNumber);
    }
}