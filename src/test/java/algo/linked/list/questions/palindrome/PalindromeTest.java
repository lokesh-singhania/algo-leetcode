package algo.linked.list.questions.palindrome;

import static algo.linked.list.ListUtil.createList;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import algo.linked.list.ListUtil;
import algo.linked.list.pojo.ListNode;

public class PalindromeTest {

	Palindrome sol=new Better();

	@Test
	public void nullList() {
		test(null,true);
	}
	
	@Test
	public void singleNode() {
		test(new ListNode(1),true);
	}
	
	@Test
	public void evenNodesNotPalindrome() {
		test(createList(1,2,3,4),false);
	}
	
	@Test
	public void evenNodesPalindrome() {
		test(createList(1,2,2,1),true);
	}
	
	@Test
	public void oddNodesNotPalindrome() {
		test(createList(1,2,3,4,5),false);
	}
	
	@Test
	public void oddNodesPalindrome() {
		test(createList(1,2,4,2,1),true);
	}
	
	void test(ListNode input, boolean output) {
		assertEquals(sol.isPalindrome(input),output);
	}
}
