package algo.april;

import algo.april.impl.btp.Iterative;
import algo.april.impl.btp.Recursive;
import algo.pojo.TreeNode;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class BinaryTreePathsTest {

    private BinaryTreePaths service;

    public BinaryTreePathsTest(BinaryTreePaths service) {
        this.service = service;
    }

    @Factory
    private static Object[] factory(){
        return new Object[]{
                new BinaryTreePathsTest(new Recursive()),
                new BinaryTreePathsTest(new Iterative())
        };
    }

    @DataProvider
    private Object[][] data(){
        return new Object[][]{
                {new Integer[]{},new String[]{}},
                {new Integer[]{1},new String[]{"1"}},
                {new Integer[]{1,2},new String[]{"1->2"}},
                {new Integer[]{1,2,null,3},new String[]{"1->2->3"}},
                {new Integer[]{1,2,3},new String[]{"1->2","1->3"}},
                {new Integer[]{1,2,5,3,4,6,7,null,null,8},new String[]{"1->2->3","1->2->4->8","1->5->6","1->5->7"}}
        };
    }


    @Test(dataProvider = "data")
    public void test(Integer[] treeArray,String[] pathsArray){
        TreeNode root = TreeNode.fromArray(treeArray);
        Assert.assertEquals(service.binaryTreePaths(root), Arrays.stream(pathsArray).collect(Collectors.toSet()));
    }
}