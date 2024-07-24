package algo.string.prefix.score;

import algo.annotations.Source;
import algo.string.PrefixScoreSum;

import static java.util.Arrays.stream;

public class Trie implements PrefixScoreSum {
    Node root = new Node();

    @Override public int[] sumPrefixScores(String[] words) {
        stream(words).forEach(this::addWord);

        return stream(words)
                .mapToInt(this::sum)
                .toArray();
    }

    private void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int ci = word.charAt(i) - 'a';
            node.count++;
            if (node.next[ci] == null) {
                node.next[ci] = new Node();
            }
            node = node.next[ci];
        }
        node.count++;
    }

    int sum(String word) {
        int sum = 0;
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            node = node.next[word.charAt(i) - 'a'];
            sum += node.count;
        }
        return sum;
    }

    class Node {
        Node[] next;
        int count;

        Node() {
            next = new Node[26];
            count = 0;
        }
    }
}
