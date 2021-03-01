package algo.linked.list.questions.easy.palindrome;

import algo.linked.list.pojo.ListNode;

//No instance variable
public class RecursiveElegant implements Palindrome {

	@Override
	public boolean isPalindrome(ListNode head) {
		ListNode preHead = new ListNode(0,head);
		return isPalindrome(preHead, head);
	}

	boolean isPalindrome(ListNode left, ListNode right) {
		if (right == null)
			return true;
		boolean result = isPalindrome(left, right.next);
		result = result && left.next.val == right.val;
		left.next = left.next.next;
		return result;
	}

}
