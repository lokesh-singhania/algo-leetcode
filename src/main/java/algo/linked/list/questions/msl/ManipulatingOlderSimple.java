package algo.linked.list.questions.msl;

import algo.linked.list.pojo.ListNode;

public class ManipulatingOlderSimple implements Merge2SortedLists {

	@Override
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode preHead = new ListNode();
		ListNode node = preHead;
		while (l1 != null || l2 != null) {
			ListNode nextNode;
			if (l1 != null && l2 != null) {
				if (l1.val < l2.val) {
					nextNode = l1;
					l1 = l1.next;
				} else {
					nextNode = l2;
					l2 = l2.next;
				}
			} else {
				if (l1 == null) {
					nextNode = l2;
					l2 = l2.next;
				} else {
					nextNode = l1;
					l1 = l1.next;
				}
			}
			node.next = nextNode;
			node = node.next;
		}
		return preHead.next;
	}

}
