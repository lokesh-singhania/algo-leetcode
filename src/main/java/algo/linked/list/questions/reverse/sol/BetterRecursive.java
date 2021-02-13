package algo.linked.list.questions.reverse.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.reverse.ReverseLinkedList;

public class BetterRecursive implements ReverseLinkedList {

	@Override
	public ListNode reverse(ListNode node) {
		if (node == null || node.next == null) {
			return node;
		}
		ListNode newHead = reverse(node.next);
		node.next.next = node;
		node.next = null;
		return newHead;
	}

}
