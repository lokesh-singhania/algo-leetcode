package algo.string;

import algo.string.ladder.TrieNeighbors;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class WordLadderTest {

    WordLadder service = new TrieNeighbors();

    @DataProvider(name = "ladderLengthData")
    public Object[][] createData() {
        return new Object[][] {
                {"hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"), 5},
                {"hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"), 0},
                {"hot","dog",Arrays.asList("hot","dog"),0},
                {"ab","xy",Arrays.asList("xy","xb"),3}
        };
    }

    @Test(dataProvider = "ladderLengthData")
    public void testLadderLength(String beginWord, String endWord, List<String> wordList, int expected) {
        int result = service.ladderLength(beginWord, endWord, wordList);
        assertEquals(result, expected);
    }
}
