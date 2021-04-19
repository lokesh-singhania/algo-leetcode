package algo.april;

import algo.april.impl.va.Array;
import algo.april.impl.va.SingleArray;
import algo.april.impl.va.Sorting;
import algo.april.impl.va.SubLinear;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class ValidAnagramTest {

    private ValidAnagram service;

    public ValidAnagramTest(ValidAnagram service) {
        this.service = service;
    }

    @Factory
    private static Object[] factory() {
        return new Object[]{
                new ValidAnagramTest(new Array()),
                new ValidAnagramTest(new SingleArray()),
                new ValidAnagramTest(new SubLinear()),
                new ValidAnagramTest(new Sorting())
        };
    }

    @DataProvider
    private Object[][] data() {
        return new Object[][]{
                {"a", "a", true, "same character"},
                {"a", "b", false, "same length, different character"},
                {"a", "aj", false, "different lengths"},
                {"abcd", "bcad", true, "same characters in different positions"},
                {"abdf", "abef", false, "one character different"},
        };
    }

    @Test(dataProvider = "data")
    public void test(String a, String b, boolean result, String message) {
        Assert.assertEquals(service.isAnagram(a, b), result, message);
    }
}
