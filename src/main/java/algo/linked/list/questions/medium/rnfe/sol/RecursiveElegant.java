package algo.linked.list.questions.medium.rnfe.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.medium.rnfe.RemoveNthFromEnd;

public class RecursiveElegant implements RemoveNthFromEnd {

	@Override
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		if (removeFromEnd(head, n) == n) {
			head = head.next;
		}
		return head;
	}

	private int removeFromEnd(ListNode node, int n) {
		if (node == null)
			return 0;
		int indexFromEnd = removeFromEnd(node.next, n);
		if (indexFromEnd == n) {
			node.next = node.next.next;
		}
		return indexFromEnd + 1;
	}
}
