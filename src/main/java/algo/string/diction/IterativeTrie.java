package algo.string.diction;

public class IterativeTrie extends Trie {
    @Override
    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int ci = word.charAt(i) - 'a';
            if (node.next[ci] == null) {
                node.next[ci] = new Node();
            }
            node = node.next[ci];
        }
        node.end = true;
    }
}
