package algo.string.vp2;

public class Optimal implements ValidPalindrome2 {

	@Override
	public boolean validPalindrome(String s) {
		return isValidPalindrome(s.toCharArray(), 0, s.length() - 1, 1);
	}

	private boolean isValidPalindrome(char[] charArray, int i, int j, int roomLeft) {

		while(i<j) {
			if(charArray[i]!=charArray[j]) {
				if(roomLeft>0) {
					return isValidPalindrome(charArray, i+1, j, roomLeft-1) || isValidPalindrome(charArray, i, j-1, roomLeft-1); 
				}else {
					return false;
				}
			}
			i++;
			j--;
		}
		return true;
	}

}
