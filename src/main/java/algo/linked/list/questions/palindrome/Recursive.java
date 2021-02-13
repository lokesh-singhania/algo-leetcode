package algo.linked.list.questions.palindrome;

import algo.linked.list.pojo.ListNode;

public class Recursive implements Palindrome{

	@Override
	public boolean isPalindrome(ListNode head) {
		
		return new Finder(head).isPalindrome(head);
	}

	static class Finder{
		ListNode startingNode;
		public Finder(ListNode node) {
			this.startingNode = node;
		}
		
		boolean isPalindrome(ListNode endingNode) {
			if(endingNode==null) return true;
			if(endingNode.val != startingNode.val) {
				return false;
			}
			boolean value = isPalindrome(endingNode.next);
			startingNode=startingNode.next;
			return value;
			
		}
	}
}
