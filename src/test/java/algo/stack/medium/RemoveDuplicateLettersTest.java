package algo.stack.medium;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import algo.stack.medium.impl.rdl.RemoveDuplicateLettersImpl;
import algo.stack.medium.impl.rdl.ViaStreams;
@Ignore
public class RemoveDuplicateLettersTest {

	private RemoveDuplicateLetters rdl;

	@Factory
	private static Object[] factory() {
		return new Object[] {
				new RemoveDuplicateLettersTest(new RemoveDuplicateLettersImpl()),
				new RemoveDuplicateLettersTest(new ViaStreams())
		};
	}

	public RemoveDuplicateLettersTest(RemoveDuplicateLetters rdl) {
		this.rdl = rdl;
	}

	@DataProvider
	private Object[][] data() {
		return new Object[][] {
				{ "", "", "empty" },
				{ "a", "a", "singleCharacter" },
				{ "cab", "cab", "noDuplicatesShouldReturnSame" },
				{ "cc", "c", "singleDuplicateCharacter" },
				{ "ccdcyddab", "cdyab", "multipleDuplicateCharacters" }
		};
	}

	@Test(dataProvider = "data")
	public void test(String input, String output, String message) {
		assertEquals(rdl.removeDuplicate(input), output, message);
	}
}
