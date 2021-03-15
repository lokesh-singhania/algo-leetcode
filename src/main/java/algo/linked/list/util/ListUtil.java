package algo.linked.list.util;

import algo.linked.list.pojo.ListNode;

public final class ListUtil {

	private ListUtil() {
	}
	
	public static ListNode createList(int... values) {
		if (values == null)
			return null;
		ListNode head = new ListNode(values[0]);
		ListNode prev = head;
		for (int i = 1; i < values.length; i++) {
			ListNode node = new ListNode(values[i]);
			prev.next = node;
			prev = node;
		}
		return head;
	}

	public static class ListEnds {
		public final ListNode head;
		public final ListNode tail;

		public ListEnds(ListNode head, ListNode tail) {
			this.head = head;
			this.tail = tail;
		}
	}

	public static boolean equalValueList(ListNode head1, ListNode head2) {
		while (head1 != null && head2 != null) {
			if (head1.val != head2.val) {
				break;
			} else {
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		return head1 == null && head2 == null;
	}

}
