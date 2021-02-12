package algo.linked.list.questions.remove.duplicates;

import java.util.Objects;

import algo.linked.list.pojo.ListNode;

public class FirstAttempt implements RemoveDuplicates {

	@Override
	public ListNode removeDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		
		ListNode prev = head;
		ListNode node = head.next;
		while (node != null) {
			if (Objects.nonNull(prev) && prev.val != node.val) {
				prev.next = node;
				prev = node;
			}
			node = node.next;
		}
		prev.next=null;
		
		return head;
	}

}
