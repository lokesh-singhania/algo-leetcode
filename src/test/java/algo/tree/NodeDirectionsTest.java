package algo.tree;

import algo.pojo.TreeNode;
import algo.tree.node.directions.LCA;
import algo.tree.node.directions.NodeDirections;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NodeDirectionsTest {

    NodeDirections service = new LCA();

    @Test(dataProvider = "d")
    void test(Integer[] nodes,int start,int dest,String result){
        Assert.assertEquals(service.getDirections(TreeNode.fromArray(nodes),start,dest),result);
    }

    @DataProvider(name = "d")
    public Object[][] data(){
        return new Object[][]{
                new Object[]{new Integer[]{5,1,2,3,null,6,4},3,6,"UURL"}
                ,new Object[]{new Integer[]{1,2},1,2,"L"}
                ,new Object[]{new Integer[]{0,1,2},1,2,"UR"}
                ,new Object[]{new Integer[]{0,1,2},2,1,"UL"}
                ,new Object[]{new Integer[]{1,2},2,1,"U"},
                new Object[]{new Integer[]{13,5,4,7,null,8,6,3,null,null,12,9,1,null,null,11,null,null,10,null,null,null,null,2},3,2,"UUURLLL"}
                ,new Object[]{new Integer[]{0,1,2,null,4,5},4,5,"UURL"}

        };
    }
}
