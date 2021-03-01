package algo.linked.list.questions.medium.rnfe.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.medium.rnfe.RemoveNthFromEnd;

public class OnePass implements RemoveNthFromEnd {

	@Override
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null) return null;
		
		ListNode preHead = new ListNode(0, head);
		ListNode first = preHead;
		ListNode second = preHead;
		for (int i = 1; i <= n+1; i++) {
			first =first.next;	
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return preHead.next;
	}

}
