package algo.linked.list.questions.binary.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.binary.ConvertBinaryNumberToInteger;

public class BitShift implements ConvertBinaryNumberToInteger{

	@Override
	public int getDecimalValue(ListNode head) {
		int number =0;
		ListNode node = head;
		while(node!=null) {
			number = number << 1 | node.val;
			node = node.next;
		}
		return number;
	}

}
