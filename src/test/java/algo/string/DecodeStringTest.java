package algo.string;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DecodeStringTest {

    DecodeString service = new DecodeString();

    @Test(dataProvider = "test")
    void test(String input,String output){
        Assert.assertEquals(service.decodeString(input),output);
    }

    @DataProvider(name="test")
    Object[][] data(){
        return new Object[][]{
                new Object[]{"2[ab]","abab"},
                new Object[]{"2[ab2[xz]]","abxzxzabxzxz"}
        };
    }
}
