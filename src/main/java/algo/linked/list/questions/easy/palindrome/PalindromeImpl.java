package algo.linked.list.questions.easy.palindrome;

import algo.linked.list.pojo.ListNode;

public class PalindromeImpl implements Palindrome {

	@Override
	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		int size = size(head);
		ListNode middleNode = getNthNode(head, (size + 1) / 2);
		ListNode b = reverse(middleNode.next);

		ListNode a = head;
		boolean isPal = true;
		while (b != null) {
			if (a.val != b.val) {
				isPal = false;
				break;
			}
			a = a.next;
			b = b.next;
		}

		return isPal;
	}

	int size(ListNode head) {
		int size = 0;
		while (head != null) {
			head = head.next;
			size++;
		}
		return size;
	}

	ListNode getNthNode(ListNode head, int n) {
		for (int i = 1; i < n; i++) {
			head = head.next;
		}
		return head;
	}

	ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}

}
