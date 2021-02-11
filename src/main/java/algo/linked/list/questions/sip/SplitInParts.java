package algo.linked.list.questions.sip;

import algo.linked.list.pojo.ListNode;

public class SplitInParts {

	public ListNode[] splitListIntoParts(ListNode head, int k) {
		int n = size(head);
		ListNode node = head;
		ListNode[] parts = new ListNode[k];
		int p = 0;
		int remaining = n;
		while (remaining > 0) {
			parts[p] = node;
			int partSize = divideEqually(remaining, k - p);
			for (int j = 1; j < partSize; j++, node = node.next, remaining--);
			ListNode buffer = node.next;
			node.next = null;
			node = buffer;
			remaining--;
			p++;
		}
		return parts;
	}

	int size(ListNode root) {
		int i = 0;
		ListNode node = root;
		while (node != null) {
			node = node.next;
			i++;
		}
		return i;
	}

	int divideEqually(int totalItems, int parts) {
		return totalItems % parts == 0 ? totalItems / parts : totalItems / parts + 1;
	}
}
