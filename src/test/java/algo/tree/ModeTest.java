package algo.tree;

import static algo.util.MyAsserts.assertEqualsIgnoreOrder;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsNoOrder;

import org.testng.annotations.Test;

import models.TreeNode;
import algo.tree.mode.Inorder;

public class ModeTest {

	Mode impl = new Inorder();
	
	@Test
	public void singleMod() {
		assertEquals(impl.mode(TreeNode.fromArray(new Integer[] {1,2,3,4,5,1})),new int[] {1});
		
	}
	

	@Test
	void multipleModes() {
		assertEqualsIgnoreOrder(impl.mode(TreeNode.fromArray(new Integer[] {3,2,4,1,null,null,5})),new int[] {1,2,3,4,5});
	}
}
