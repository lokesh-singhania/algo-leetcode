package algo.linked.list.msl;

import algo.linked.list.pojo.ListNode;

public class CreatingNew implements Merge2SortedLists {

	@Override
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode preHead = new ListNode();
		ListNode node = preHead;
		while (l1 != null || l2 != null) {
			int nextValue;
			if (l1 == null) {
				nextValue = l2.val;
				l2 = l2.next;
			} else if (l2 == null) {
				nextValue = l1.val;
				l1 = l1.next;
			} else if (l1.val < l2.val) {
				nextValue = l1.val;
				l1 = l1.next;
			} else {
				nextValue = l2.val;
				l2 = l2.next;
			}

			node.next = new ListNode(nextValue);
			node = node.next;
		}

		return preHead.next;
	}

}
