package algo.linked.list.questions.intersection.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.intersection.Intersection;

public class Interleaving implements Intersection {

	@Override
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode nodeA = headA, nodeB = headB;

		while (nodeA != nodeB) {
			nodeA = nodeA == null ? headB : nodeA.next;
			nodeB = nodeB == null ? headA : nodeB.next;
		}
		return nodeA;
	}

}
