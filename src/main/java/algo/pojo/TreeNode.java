package algo.pojo;

import java.util.Objects;

public class TreeNode {

	public TreeNode left;
	public TreeNode right;
	public final int value;

	public static TreeNode fromArray(Integer[] values) {
		return createTreeNode(values,0);
	}

	private static TreeNode createTreeNode(Integer[] values, int index) {
		if(index>=values.length || values[index]==null){
			return null;
		}
		return new TreeNode(values[index],createTreeNode(values,2*index+1),createTreeNode(values,2*index+2));
	}

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

	public boolean isLeaf(){
		return left==null && right==null;
	}

	public static int compare(TreeNode p,TreeNode q){
		return Integer.compare(p.value,q.value);
	}

	@Override
	public String toString() {
		return "TreeNode [value=" + value + "]";
	}
	
}
