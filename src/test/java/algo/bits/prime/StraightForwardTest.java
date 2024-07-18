package algo.bits.prime;

import algo.bits.PrimeBits;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StraightForwardTest {

    PrimeBits service=new StraightForward();

    @Test(dataProvider = "test")
    void primeBits(int left,int right,int expected){
        assertEquals(service.primeBits(left,right),expected);
    }

    @DataProvider(name="test")
    public Object[][] testData(){
        return new Object[][]{
                {14,16,1},
                {3,6,3},
                {6,10,4},
                {10,15,5}
        };
    }
}