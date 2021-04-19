package algo.april;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import algo.april.impl.sr.BinarySearch;
import algo.april.impl.sr.ExponentialBreakpointSearch;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import algo.april.impl.sr.First;

public class SummaryRangesTest {

    private SummaryRanges summaryRanges;

    public SummaryRangesTest(SummaryRanges summaryRanges) {
        this.summaryRanges = summaryRanges;
    }

    @Factory
    private static Object[] factory() {
        return new Object[]{
                new SummaryRangesTest(new First()),
                new SummaryRangesTest(new ExponentialBreakpointSearch()),
                new SummaryRangesTest(new BinarySearch())
        };
    }

    @DataProvider
    private Object[][] data() {
        return new Object[][]{
                {new int[]{}, new String[]{}},
                {new int[]{1}, new String[]{"1"}},
                {new int[]{1, 2, 3}, new String[]{"1->3"}},
                {new int[]{1, 3}, new String[]{"1", "3"}},
                {new int[]{3, 4,5, 7}, new String[]{"3->5", "7"}},
                {new int[]{1, 3, 4, 5, 7}, new String[]{"1", "3->5", "7"}}
        };
    }

    @Test(dataProvider = "data")
    public void test(int[] nums, String[] expectedOutput) {
        assertEquals(summaryRanges.summaryRanges(nums), Arrays.asList(expectedOutput));
    }
}
