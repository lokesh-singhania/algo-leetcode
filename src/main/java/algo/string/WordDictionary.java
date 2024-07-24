package algo.string;

import algo.annotations.Source;

@Source("https://leetcode.com/problems/design-add-and-search-words-data-structure/")
public interface WordDictionary {

    void addWord(String word);
    boolean search(String word);
}
