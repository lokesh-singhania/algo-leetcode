package algo.april;

import algo.april.impl.rsq.Naive;
import algo.april.impl.rsq.Sophisticated;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.function.Function;

import static org.testng.Assert.*;

public class RangeSumQueryTest {

    private Function<int[], RangeSumQuery> newRange;
    private RangeSumQuery instance;

    public RangeSumQueryTest(Function<int[], RangeSumQuery> newRange) {
        this.newRange = newRange;
    }

    @Factory
    private static Object[] factory() {
        return new Object[]{
                new RangeSumQueryTest(Naive::new),
                new RangeSumQueryTest(Sophisticated::new)
        };
    }

    @BeforeClass
    void init() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        instance = newRange.apply(numbers);
    }

    @DataProvider
    private Object[][] data() {
        return new Object[][]{
                {0, 0, 1, "left most"},
                {6, 6, 7, "right most"},
                {0, 1, 3, "consecutive left and right"},
                {3, 5, 15, "gap between left and right"},
                {0, 6, 28, "whole array"}
        };
    }

    @Test(dataProvider = "data")
    private void test(int left, int right, int result, String message) {
        assertEquals(instance.sumRange(left, right), result, message);
    }

}