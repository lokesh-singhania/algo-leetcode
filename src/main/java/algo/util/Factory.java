package algo.util;

import java.util.function.IntPredicate;

public final class Factory {

	private Factory() {
	}
	
	public static final int[] EMPTY_ARRAY=new int[0];

	public static final IntPredicate NON_ZERO=a->a!=0;

	public static final String ARROW="->";
}
