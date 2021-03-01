package algo.linked.list.questions.easy.intersection;

import algo.linked.list.pojo.ListNode;

public class TwoPointers implements IntersectionNode {

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
