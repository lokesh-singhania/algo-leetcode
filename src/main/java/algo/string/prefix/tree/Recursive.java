package algo.string.prefix.tree;

public class Recursive extends Trie {

    public Recursive() {
        super();
    }

    @Override
    public void insert(String word) {
        root = put(root, word, 0);
    }

    private Node put(Node node, String s, int i) {
        if (node == null) {
            node = new Node();
        }
        if (i == s.length()) {
            node.end = true;
            return node;
        }
        int ci = s.charAt(i) - 'a';
        node.next[ci] = put(node.next[ci], s, i + 1);
        return node;
    }

    @Override
    protected Node prefixSearch(String prefix) {
        return prefixSearch(root, prefix, 0);
    }

    private Node prefixSearch(Node node, String s, int i) {
        if (node == null) {
            return null;
        }
        if (i == s.length()) {
            return node;
        }
        return prefixSearch(node.next[s.charAt(i) - 'a'], s, i + 1);
    }

}
