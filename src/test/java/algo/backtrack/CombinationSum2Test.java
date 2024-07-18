package algo.backtrack;

import algo.backtrack.cs2.PreCompute;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CombinationSum2Test {

    CombinationSum2 service = new PreCompute();

    @Test(dataProvider = "data")
    void test(List<Integer> candidates, int target) {
        System.out.println(
                service.combinationSum2(candidates.stream().mapToInt(Integer::intValue).toArray()
                        , target));
    }

    @DataProvider(name = "data")
    public Object[][] data(){
        return new Object[][]{
          new Object[]{Arrays.asList(1,1),2},
          new Object[]{Arrays.asList(10,1,2,7,6,1,5),8},
                new Object[]{Arrays.asList(2,5,2,1,2),5}

        };
    }
}
