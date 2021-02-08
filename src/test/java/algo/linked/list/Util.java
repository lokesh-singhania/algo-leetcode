package algo.linked.list;

public class Util {

	static ListNode createList(int... values) {
		ListNode head = new ListNode(values[0]);
		ListNode prev = head;
		for (int i = 1; i < values.length; i++) {
			ListNode node = new ListNode(values[i]);
			prev.next = node;
			prev = node;
		}
		return head;
	}
	

}
