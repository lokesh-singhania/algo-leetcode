package algo.util;

import java.util.Collection;

public final class ArrayUtil {

	private ArrayUtil() {
	}
	
	public static <T> boolean isEmpty(T[] a) {
		return a==null || a.length==0;
	}

	
	public static boolean isEmpty(int[] a) {
		return a==null || a.length==0;
	}
	
	public static int[] array(int... values) {
		return values;
	}

	public static int minIndex(int[] nums, int lo, int hi) {
		int min=nums[lo];
		int minIndex=lo;
		for(int i=lo+1;i<=hi;i++) {
			int element = nums[i];
			if(element<min) {
				min=element;
				minIndex=i;
			}
		}
		return minIndex;
	}

	public static int[] toArray(Collection<Integer> coll) {
		return coll.stream().mapToInt(Integer::intValue).toArray();
	}
		
}
