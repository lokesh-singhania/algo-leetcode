package algo.matrix;

import algo.matrix.conditions.ReversePostOrder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConditionsTest {

    Conditions service = new ReversePostOrder();

    @Test(dataProvider = "data")
    void test(int k, int[][] rowConditions, int[][] colConditions, int[][] result) {
        int[][] matrix = service.buildMatrix(k, rowConditions, colConditions);
        Assert.assertEquals(matrix, result);
    }

    @DataProvider(name = "data")
    public Object[][] data() {
        int[][] a = {{1, 2}, {3, 2}};
        int[][] b = {{2, 1}, {3, 2}};
        int[][] r = {{3, 0, 0}, {0, 0, 1}, {0, 2, 0}};
        return new Object[][]{
                new Object[]{3, a, b, r}
        };
    }

}
