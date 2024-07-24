package algo.string.prefix.tree;

import algo.string.PrefixTree;

import java.util.Optional;

public abstract class Trie implements PrefixTree {
    protected Node root;

    public Trie() {
        root = new Node();
    }

    public boolean search(String word) {
        return Optional.ofNullable(prefixSearch(word))
                .map(n -> n.end)
                .orElse(false);
    }

    public boolean startsWith(String prefix) {
        return prefixSearch(prefix) != null;
    }

    protected abstract Node prefixSearch(String prefix);

    protected class Node {
        Node[] next;
        boolean end;

        Node() {
            next = new Node[26];
        }
    }
}
