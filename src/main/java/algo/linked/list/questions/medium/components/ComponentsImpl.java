package algo.linked.list.questions.medium.components;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import algo.linked.list.pojo.ListNode;

//TODO: Other solutions
public class ComponentsImpl implements ConnectedComponents {
	public int numComponents(ListNode head, int[] G) {
		if (head == null || G == null)
			return 0;

		Set<Object> set = Arrays.stream(G)
				.mapToObj(i -> (Integer) i)
				.collect(Collectors.toSet());
		ListNode node = head;
		int number = G.length;
		while (node != null && node.next != null) {
			if (!set.contains(node.val)) {
				node = node.next;
				continue;
			}
			node = node.next;
			while (node != null && set.contains(node.val)) {
				number--;
				node = node.next;
			}
		}
		return number;
	}
}
