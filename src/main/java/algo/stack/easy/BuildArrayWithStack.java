package algo.stack.easy;

import java.util.List;

/*
 * https://leetcode.com/problems/build-an-array-with-stack-operations/submissions/
 */
public interface BuildArrayWithStack {

	String PUSH ="Push";
	
	String POP="Pop";
	
	
	List<String> buildArray(int[] target, int n);
}
