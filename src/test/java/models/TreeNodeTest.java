package models;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import algo.tree.lib.TreeFunctions;

public class TreeNodeTest {

  @Test
  public void depthTest() {
	  TreeFunctions treeFunctions = new TreeFunctions();
	  assertEquals(treeFunctions.depth(null), 0);
	  assertEquals(treeFunctions.depth(new TreeNode(2)), 1);
	  assertEquals(treeFunctions.depth(TreeNode.fromArray(new Integer[] {1,2,null})), 2);
  }
}
