package algo.linked.list.questions.easy.llc.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.easy.llc.LinkedListCycle;

public class TwoPointers implements LinkedListCycle{

	@Override
	public boolean hasCycle(ListNode head) {
		ListNode slow  = head;
		ListNode fast = head;
		boolean hasCycle = false;
		while(!isLastOrPenultimate(fast)) {
			slow= slow.next;
			fast = fast.next.next;
			if(slow==fast) {
				hasCycle = true;
				break;
			}
		}
		return hasCycle;
	}

	private boolean isLastOrPenultimate(ListNode fast) {
		return fast==null || fast.next==null;
	}

}
