package algo.linked.list.questions.easy.palindrome;

import algo.linked.list.pojo.ListNode;

public class Recursive implements Palindrome{

	ListNode left; 
	
	@Override
	public boolean isPalindrome(ListNode head) {
		if(head==null) return true;
		left=head;
		return check(head);
	}

	private boolean check(ListNode node) {
		if(node.next==null) return node.val==left.val;
		boolean result = check(node.next);
		left=left.next;
		return result && node.val==left.val;
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
