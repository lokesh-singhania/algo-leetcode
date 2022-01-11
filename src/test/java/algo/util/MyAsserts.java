package algo.util;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MyAsserts {

	public static void assertEqualsIgnoreOrder(int[] a,int[] b) {
		var s1 = toSet(a);
		var s2 = toSet(b);
		assertEquals(s1, s2);
	}
	
	private  static Set<Integer> toSet(int[] a){
		return Arrays.stream(a).mapToObj(Integer::valueOf).collect(Collectors.toSet());
	}
}
