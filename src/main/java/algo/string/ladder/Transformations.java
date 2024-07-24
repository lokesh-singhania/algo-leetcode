package algo.string.ladder;

import algo.string.WordLadder;

import java.util.*;

public class Transformations implements WordLadder {

    Queue<String> q;
    Set<String> words;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        q = new ArrayDeque<>();
        words = new HashSet<>(wordList);
        add(beginWord);

        int count = 0;
        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String s = q.remove();
                if (s.equals(endWord)) {
                    return count;
                }
                StringBuilder sb = new StringBuilder(s);
                for (int j = 0; j < s.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        var t = sb.toString();
                        if (words.contains(t)) {
                            add(t);
                        }
                    }
                    sb.setCharAt(j, s.charAt(j));
                }
            }
        }
        return 0;
    }

    void add(String a) {
        q.add(a);
        words.remove(a);
    }
}
