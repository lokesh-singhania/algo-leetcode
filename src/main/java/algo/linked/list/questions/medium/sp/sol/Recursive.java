package algo.linked.list.questions.medium.sp.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.medium.sp.SwapPairs;

public class Recursive implements SwapPairs {

	@Override
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		ListNode first = head;
		ListNode second = first.next;
		first.next = swapPairs(second.next);
		second.next = first;
		return second;
	}

}
