package algo.linked.list.questions.easy.msl;

import algo.linked.list.pojo.ListNode;

public class ManipulatingOlderElegant implements Merge2SortedLists {

	@Override
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode preHead = new ListNode();
		ListNode node = preHead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				node.next = l1;
				l1 = l1.next;
			} else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}
		node.next = l1 == null ? l2 : l1;
		return preHead.next;
	}

}
