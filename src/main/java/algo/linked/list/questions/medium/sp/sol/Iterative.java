package algo.linked.list.questions.medium.sp.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.medium.sp.SwapPairs;

public class Iterative implements SwapPairs {

	@Override
	public ListNode swapPairs(ListNode head) {
		ListNode first = head;
		ListNode preHead = new ListNode(-1, head);
		ListNode prev = preHead;
		while (first != null && first.next != null) {
			ListNode second = first.next;
			first.next = second.next;
			second.next = first;
			prev.next = second;
			
			prev = first;
			first = first.next;
		}
		return preHead.next;
	}

}
