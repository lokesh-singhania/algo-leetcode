package algo.linked.list.questions.easy.intersection;

import java.util.HashSet;
import java.util.Set;

import algo.linked.list.pojo.ListNode;
// Keep a set of visited nodes, if any node is visited, it is common
// O(n+m) O(max(n,m))
public class TrackingVisited implements IntersectionNode{

	@Override
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> visitedNodes = new HashSet<>();
		ListNode node = headA;
		while(node!=null) {
			visitedNodes.add(node);
			node=node.next;
		}
		node = headB;
		while(node!=null) {
			if(visitedNodes.contains(node)) {
				return node;
			}
			node = node.next;
		}
		return null;
	}

}
