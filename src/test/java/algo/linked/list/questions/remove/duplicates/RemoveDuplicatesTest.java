package algo.linked.list.questions.remove.duplicates;

import static algo.linked.list.ListUtil.createList;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import algo.linked.list.ListUtil;
import algo.linked.list.pojo.ListNode;

public class RemoveDuplicatesTest {

	RemoveDuplicates sol = new Elegant();

	
	public RemoveDuplicatesTest(RemoveDuplicates sol) {
		this.sol = new FirstAttempt();
	}

	public RemoveDuplicatesTest() {
		super();
	}

	@Test
	public void nullInput() {
		test(createList(null), null);
	}
	
	@Test
	public void oneDuplicate() {
		test(createList(1,1,2,3), createList(1,2,3));
	}
	
	@Test
	public void manyDuplicates() {
		test(createList(1,2,2,3,3,3,4,4), createList(1,2,3,4));
	}
	
	
	@Test
	public void noDuplicates() {
		test(createList(1,2,3),createList(1,2,3));
	}
	

	private void test(ListNode input, ListNode expected) {
		ListNode output = sol.removeDuplicates(input);
		assertTrue(ListUtil.equalList(expected , output));
	}
	
}