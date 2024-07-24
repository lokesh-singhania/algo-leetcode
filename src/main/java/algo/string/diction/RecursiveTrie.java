package algo.string.diction;

public class RecursiveTrie extends Trie {

    public RecursiveTrie() {
        super();
    }

    public void addWord(String word) {
        root = put(root, word, 0);
    }

    private Node put(Node node, String s, int i) {
        if (node == null) node = new Node();
        if (i == s.length()) {
            node.end = true;
            return node;
        }
        int ci = s.charAt(i) - 'a';
        node.next[ci] = put(node.next[ci], s, i + 1);
        return node;
    }

}
