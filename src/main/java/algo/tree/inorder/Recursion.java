package algo.tree.inorder;

import java.util.LinkedList;
import java.util.List;

import algo.tree.pojo.Node;

public class Recursion<V> {

	List<V> elements;
	
	Recursion(Node<V> root){
		elements = new LinkedList<>();
		inorder(root);
	}
	
	void inorder(Node<V> node) {
		if(node == null)
			return;
		
		inorder(node.left);
		elements.add(node.value);
		inorder(node.right);
	}
	
	List<V> elements(){
		return elements;
	}

}
