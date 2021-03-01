package algo.linked.list.questions.medium.rnfe.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.medium.rnfe.RemoveNthFromEnd;

public class Recursive implements RemoveNthFromEnd {

	@Override
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;
		ListNode preHead = new ListNode(0, head);
		new Helper(n + 1).removeFromEnd(preHead);
		return preHead.next;
	}

	static class Helper {
		int n;

		Helper(int n) {
			this.n = n;
		}

		void removeFromEnd(ListNode node) {
			if (node == null)
				return;
			removeFromEnd(node.next);
			n--;
			if (n == 0) {
				node.next = node.next.next;
			}
		}

	}

}
