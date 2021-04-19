package algo.pojo;

import java.util.Objects;

public class TreeNode {

	public TreeNode left;
	public TreeNode right;
	public final int value;

//	public static TreeNode fromArray(int[] values) {
//		
//	}
	
	public TreeNode(int value) {
		this.value = value;
	}

	public TreeNode(int value, TreeNode left, TreeNode right) {
		this(value);
		this.left = left;
		this.right = right;
	}

	public boolean hasLeftChild() {
		return Objects.nonNull(left);
	}

	public boolean hasRightChild() {
		return Objects.nonNull(right);
	}

	public static int compare(TreeNode p,TreeNode q){
		return Integer.compare(p.value,q.value);
	}

	@Override
	public String toString() {
		return "TreeNode [value=" + value + "]";
	}
	
}
