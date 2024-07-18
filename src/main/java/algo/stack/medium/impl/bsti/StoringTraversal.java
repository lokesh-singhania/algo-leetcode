package algo.stack.medium.impl.bsti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import models.TreeNode;
import algo.stack.medium.BinarySearchTreeIterator;

public class StoringTraversal implements BinarySearchTreeIterator{

	private List<Integer> values;
	private int pointer;
	
	public StoringTraversal(TreeNode root) {
		if(Objects.isNull(root)) {
			values = Collections.emptyList();
		}else {
			values = new ArrayList<>();
			inorder(root);
			pointer=0;
		}
	}
	
	private void inorder(TreeNode node) {
		if(node.hasLeftChild()) {
			inorder(node.left);
		}
		values.add(node.val);
		if(node.hasRightChild()) {
			inorder(node.right);
		}
	}

	@Override
	public boolean hasNext() {
		return pointer<=values.size()-1;
	}

	@Override
	public int next() {
		return values.get(pointer++);
	}

}
