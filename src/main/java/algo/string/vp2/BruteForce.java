package algo.string.vp2;

public class BruteForce implements ValidPalindrome2{

	@Override
	public boolean validPalindrome(String s) {
		if(isPalindrome(s)) return true;
		StringBuilder sb = new StringBuilder(s);
		for(int i=0;i<=s.length()-1;i++) {
			char c = sb.charAt(i);
			sb=sb.deleteCharAt(i);
			if(isPalindrome(sb)) return true;
			sb.insert(i, c);
		}
		return false;
	}
	
	boolean isPalindrome(CharSequence chars) {
		for(int i=0;i<=(chars.length()-1)/2;i++) {
			if(chars.charAt(i)!=chars.charAt(chars.length()-i-1)) {
				return false;
			}
		}
		return true;
	}

}
