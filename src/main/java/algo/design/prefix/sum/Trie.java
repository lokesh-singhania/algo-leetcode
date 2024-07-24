package algo.design.prefix.sum;

import algo.design.PrefixSum;

import java.util.Optional;

public abstract class Trie implements PrefixSum {
    Node root;

    public Trie() {
        root = new Node();
    }

    public int sum(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length() && node != null; i++) {
            int ci = prefix.charAt(i) - 'a';
            node = node.next[ci];
        }
        return Optional.ofNullable(node)
                .map(nd -> nd.sum)
                .orElse(0);
    }

    class Node {
        IterativeTrie.Node[] next;
        int sum;
        int val;

        Node() {
            next = new IterativeTrie.Node[26];
        }
    }
}
