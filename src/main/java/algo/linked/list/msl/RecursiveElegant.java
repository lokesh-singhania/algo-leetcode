package algo.linked.list.msl;

import algo.linked.list.pojo.ListNode;

public class RecursiveElegant implements Merge2SortedLists {

	@Override
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode toPick = l1.val < l2.val ? l1 : l2;
		ListNode other = l1.val < l2.val ? l2 : l1;
		toPick.next = mergeTwoLists(toPick.next, other);
		return toPick;
	}

}
