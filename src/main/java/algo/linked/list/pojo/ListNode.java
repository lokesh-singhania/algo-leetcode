package algo.linked.list.pojo;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + val;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListNode other = (ListNode) obj;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (next!=other.next)
			return false;
		if (val != other.val)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next.val + "]";
	}
	
}