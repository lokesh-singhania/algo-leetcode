package algo.linked.list.questions.easy.middle.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.easy.middle.Middle;

public class TwoPointers implements Middle{

	@Override
	public ListNode getMiddle(ListNode head) {
		ListNode oneStep = head;
		ListNode twoStep = head;
		while(twoStep!=null && twoStep.next!=null) {
			oneStep = oneStep.next;
			twoStep = twoStep.next.next;
		}
		return oneStep;
	}

}
