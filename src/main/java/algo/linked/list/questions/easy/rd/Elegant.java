package algo.linked.list.questions.easy.rd;

import algo.linked.list.pojo.ListNode;

public class Elegant implements RemoveDuplicates{

	@Override
	public ListNode removeDuplicates(ListNode head) {
		ListNode node = head;
		while(node!=null && node.next!=null) {
			if(node.val==node.next.val) {
				node.next=node.next.next;
			}else {
				node = node.next;
			}
		}
		return head;
	}

}
