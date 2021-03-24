package algo.stack.medium;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import algo.pojo.TreeNode;
import algo.stack.medium.impl.bsti.ControlledRecursion;
import algo.stack.medium.impl.bsti.StoringTraversal;
import algo.stack.medium.impl.bsti.LazyExecution;

public class BinarySearchTreeIteratorTest {

	private Class<? extends BinarySearchTreeIterator> implClass;
	
	@Factory
	private static Object[] factory() {
		return new Object[] {
			new BinarySearchTreeIteratorTest(LazyExecution.class),
			new BinarySearchTreeIteratorTest(StoringTraversal.class),
			new BinarySearchTreeIteratorTest(ControlledRecursion.class)
		};
	}
	
	public BinarySearchTreeIteratorTest(Class<? extends BinarySearchTreeIterator> implClass) {
		this.implClass = implClass;
	}

	@DataProvider
	private Object[][] data(){
		return new Object[][] {
			{null,Collections.emptyList(),"empty"},
			{new TreeNode(1),Arrays.asList(1),"singleNode"},
			{new TreeNode(1,new TreeNode(2),new TreeNode(3)), Arrays.asList(2,1,3),"simpleChildrenCase"}
		};
	}
	
	@Test(dataProvider = "data")
	public void test(TreeNode root,List<Integer> expectedOrder,String message) throws Exception {
		List<Integer> iterationResult=new ArrayList<Integer>();
		BinarySearchTreeIterator iterator = implClass.getConstructor(TreeNode.class).newInstance(root);
		while(iterator.hasNext()) {
			iterationResult.add(iterator.next());
		}
		assertEquals(iterationResult, expectedOrder, message);
	}
	
}
