package algo.tree.inorder;

import java.util.List;

import algo.tree.pojo.Node;

public interface Traversal {

	<V> List<V> elements(Node<V> root);
	
//	<V> Iterator<V> elementsIterator(Node<V> root);
}
