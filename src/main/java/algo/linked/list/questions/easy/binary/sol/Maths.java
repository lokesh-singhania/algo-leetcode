package algo.linked.list.questions.easy.binary.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.easy.binary.ConvertBinaryNumberToInteger;

public class Maths implements ConvertBinaryNumberToInteger {

	@Override
	public int getDecimalValue(ListNode head) {
		int n = 0;
		ListNode node = head;
		while (node != null) {
			n = n * 2 + node.val;
			node = node.next;
		}
		return n;
	}

}
