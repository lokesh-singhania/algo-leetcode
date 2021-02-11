package algo.linked.list.questions.llc.sol;

import java.util.HashSet;
import java.util.Set;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.llc.LinkedListCycle;

public class Visited implements LinkedListCycle {

	@Override
	public boolean hasCycle(ListNode head) {
		Set<ListNode> visited = new HashSet<>();
		ListNode node = head;
		while(node!=null) {
			if(visited.contains(node)) return true;
			node = node.next;
		}
		return false;
	}

}
