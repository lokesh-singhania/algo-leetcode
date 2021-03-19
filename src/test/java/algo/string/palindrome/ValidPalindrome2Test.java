package algo.string.palindrome;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import algo.string.vp2.BruteForce;
import algo.string.vp2.ValidPalindrome2;

public class ValidPalindrome2Test {

	ValidPalindrome2 service = new BruteForce();

	public class PalindromesWithoutDeletion {

		@Test
		public void testSingleChar() {
			assertEquals(service.validPalindrome("a"), true);
		}

		@Test
		public void test2() {
			assertEquals(service.validPalindrome("aba"), true);
		}

		@Test
		public void testEvenChars() {
			assertEquals(service.validPalindrome("abba"), true);
		}

		@Test
		public void testOddChars() {
			test(true, "abcba");
		}
	}

	void testTrue(String input) {
		test(true, input);
	}
	
	void testFalse(String input) {
		test(false, input);
	}

	void test(boolean expected, String input) {
		assertEquals(service.validPalindrome(input), expected);
	}

	public class PalindromesWithDeletion {
		@Test
		public void testAtEnd() {
			testTrue("bbc");
		}

		@Test
		public void testInMiddle_Odd() {
			testTrue("bacb");
		}
		
		@Test
		public void testInMiddle_Even() {
			testTrue("abcbla");
		}
	}
	
	public class NotPalindrome{
		@Test
		public void testEvenFrequencyOfChars() {
			testFalse("aabb");
		}
		
		@Test
		public void testRandom() {
			testFalse("abcde");
		}
	}
}
