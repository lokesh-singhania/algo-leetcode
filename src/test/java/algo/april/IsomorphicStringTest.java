package algo.april;

import algo.april.impl.is.Array;
import algo.april.impl.is.Concise;
import algo.april.impl.is.LookupTables;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IsomorphicStringTest {

    private IsomorphicStrings service;

    public IsomorphicStringTest(IsomorphicStrings service) {
        this.service = service;
    }

    @Factory
    private static Object[] factory() {
        return new Object[]{
                new IsomorphicStringTest(new LookupTables()),
                new IsomorphicStringTest(new Array()),
                new IsomorphicStringTest(new Concise())
        };
    }

    @DataProvider
    private Object[][] data() {
        return new Object[][]{
                {"", "", true},
                {"a", "a", true},
                {"a", "b", true},
                {"ab", "cd", true},
                {"ab", "cc", false},
                {"aba", "dfd", true},
                {"aba", "ddf", false},
                {"foo","bar",false},
                {"13","42",true}
        };
    }

    @Test(dataProvider = "data")
    public void test(String a1, String a2, boolean areIsomorphic) {
        Assert.assertEquals(service.isIsomorphic(a1, a2), areIsomorphic);
    }
}
