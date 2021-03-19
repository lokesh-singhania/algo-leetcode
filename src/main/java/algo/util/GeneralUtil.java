package algo.util;

public final class GeneralUtil {

	private GeneralUtil() {
	}
	
	public static <T> boolean isEmpty(T[] a) {
		return a==null || a.length==0;
	}

	
	public static boolean isEmpty(int[] a) {
		return a==null || a.length==0;
	}
}
