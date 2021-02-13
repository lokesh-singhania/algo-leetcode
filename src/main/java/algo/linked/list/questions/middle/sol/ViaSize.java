package algo.linked.list.questions.middle.sol;

import algo.linked.list.pojo.ListNode;
import algo.linked.list.questions.middle.Middle;
//Get size, go to size/2+1 
public class ViaSize implements Middle{

	@Override
	public ListNode getMiddle(ListNode head) {
		int size = size(head);
		
		return getNthNode(head,size/2+1);
	}

	private ListNode getNthNode(ListNode head, int n) {
		int i=1;
		ListNode node = head;
		while(node!=null && i<n) {
			i++;
			node = node.next;
		}
		return node;
	}

	private int size(ListNode head) {
		int i=0;
		ListNode node = head;
		while(node!=null) {
			i++;
			node = node.next;
		}
		return i;
	}

	
}
