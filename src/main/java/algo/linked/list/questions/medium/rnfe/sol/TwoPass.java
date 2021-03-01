package algo.linked.list.questions.medium.rnfe.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.medium.rnfe.RemoveNthFromEnd;

public class TwoPass implements RemoveNthFromEnd {

	@Override
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int size = getSize(head);
		if (size == 0 || n == 0)
			return null;
		
		ListNode preHead = new ListNode(0, head);
		ListNode preNode = getNode(head, size - n);
		preNode.next = preNode.next.next;
		return preHead.next;
	}

	private ListNode getNode(ListNode head, int index) {
		ListNode node = head;
		for (int i = 1; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	private int getSize(ListNode head) {
		int i = 0;
		ListNode node = head;
		while (node != null) {
			node = node.next;
			i++;
		}
		return i;
	}

}
