package algo.string;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AtomTest {

    private final Atom service = new Atom();

    @Test(dataProvider = "data")
    void test(String formula,String expected){
        var actual=service.countOfAtoms(formula);
        Assert.assertEquals(actual,expected);
    }

    @DataProvider(name="data")
    public Object[][] data(){
        return new Object[][]{
                new Object[]{"H","H"},
                new Object[]{"HO","HO"},
                new Object[]{"H2O","H2O"},
                new Object[]{"O2H","HO2"}
        };
    }
}
