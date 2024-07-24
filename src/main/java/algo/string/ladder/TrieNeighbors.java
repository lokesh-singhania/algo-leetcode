package algo.string.ladder;

import algo.string.WordLadder;

import java.util.*;

public class TrieNeighbors implements WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Trie trie = new Trie();
        wordList.forEach(trie::add);

        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        trie.delete(beginWord);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                String candidate = q.remove();
                if (candidate.equals(endWord)) {
                    return count;
                }
                for (var neigh : trie.neighbors(candidate)) {
                    trie.delete(neigh);
                    q.add(neigh);
                }
            }
        }
        return 0;
    }

    class Trie {
        class Node {
            Node[] next;

            Node() {
                next = new Node[26];
            }
        }

        Node root;

        Trie() {
            root = new Node();
        }

        public void add(String s) {
            Node node = root;
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (node.next[i] == null) {
                    node.next[i] = new Node();
                }
                node = node.next[i];
            }
        }

        public List<String> neighbors(String s) {
            List<String> neighbors = new ArrayList<>();
            Node node = root;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length() && node != null; i++) {
                char c = s.charAt(i);
                int ci = c - 'a';
                for (int j = 0; j < 26; j++) {
                    if (j == ci || node.next[j] == null) {
                        continue;
                    }
                    sb.append((char)('a'+j));
                    String neighbor = getNeighbor(node.next[j], s, i+1, sb);
                    if (neighbor != null) {
                        neighbors.add(neighbor);
                    }
                    sb.setLength(i);
                }
                sb.append(c);
                node = node.next[c - 'a'];
            }

            return neighbors;
        }

        public void delete(String s) {
            root = delete(root, s, 0);
        }

        private Node delete(Node node, String s, int i) {
            if (i == s.length()) {
                return null;
            }
            if (node == null) {
                return null;
            }
            char c = s.charAt(i);
            int ci = c - 'a';
            node.next[ci] = delete(node.next[ci], s, i + 1);
            boolean any = Arrays.stream(node.next)
                    .anyMatch(Objects::nonNull);
            return any ? node : null;
        }

        private String getNeighbor(Node node, String s, int i, StringBuilder sb) {
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                int ci = c - 'a';
                if (node.next[ci] == null) {
                    return null;
                }
                sb.append(c);
                node = node.next[ci];
            }
            return sb.toString();
        }
    }
}
