package algo.string.diction;

import algo.string.WordDictionary;

public abstract class Trie implements WordDictionary {
    Node root;

    public Trie() {
        root = new Node();
    }

    public boolean search(String word) {
        return find(root, word, 0);
    }

    private boolean find(Node node, String s, int i) {
        if (node == null) {
            return false;
        }
        if (i == s.length()) {
            return node.end;
        }
        char c = s.charAt(i);
        int ci = c - 'a';
        if (c == '.') {
            for (Node child:node.next) {
                if (child == null) continue;
                if (find(child, s, i + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            return find(node.next[ci], s, i + 1);
        }
    }

    class Node {
        Node[] next = new Node[26];
        boolean end;
    }
}
