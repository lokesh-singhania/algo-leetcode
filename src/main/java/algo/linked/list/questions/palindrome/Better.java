package algo.linked.list.questions.palindrome;

import algo.linked.list.pojo.ListNode;
//No need to get size, can get middle using 2 pointers
public class Better implements Palindrome{

	@Override
	public boolean isPalindrome(ListNode head) {
		if(head==null || head.next==null) return true;
		
		ListNode middle = getMiddle(head);
		ListNode a = head;
		ListNode b = reverse(middle);
		while(b!=null) {
			if(b.val!=a.val) {
				return false;
			}
			b=b.next;
			a=a.next;
		}
		return true;
	}

	private ListNode reverse(ListNode node) {
		if(node ==null || node.next==null) {
			return node;
		}
		ListNode newHead = reverse(node.next);
		node.next.next = node;
		node.next = null;
		return newHead;
	}

	private ListNode getMiddle(ListNode head) {
		ListNode oneStep = head;
		ListNode twoStep = head;
		while(twoStep!=null && twoStep.next!=null) {
			oneStep = oneStep.next;
			twoStep = twoStep.next.next;
		}
		return oneStep;
	}

}
