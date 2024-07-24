package algo.string.diction;

import algo.string.WordDictionary;

import java.util.HashSet;
import java.util.Set;

public class MapAndBacktracking implements WordDictionary {


    Set<String> words;

    public MapAndBacktracking() {
        words = new HashSet<>();
    }

    public void addWord(String word) {
        words.add(word);
    }


    public boolean search(String word) {
        return find(word, 0, new StringBuilder());
    }

    private boolean find(String s, int i, StringBuilder tillNow) {
        if (i == s.length()) {
            return words.contains(tillNow.toString());
        }
        char c = s.charAt(i);
        if (c == '.') {
            for (char d = 'a'; d <= 'z'; d++) {
                tillNow.append(d);
                if (find(s, i + 1, tillNow)) {
                    return true;
                }
                removeLast(tillNow);
            }
        } else {
            tillNow.append(c);
            if (find(s, i + 1, tillNow)) {
                return true;
            }
            removeLast(tillNow);
        }
        return false;
    }

    private void removeLast(StringBuilder sb) {
        sb.setLength(sb.length() - 1);
    }
}
