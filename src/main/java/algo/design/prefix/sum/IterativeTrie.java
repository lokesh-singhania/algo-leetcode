package algo.design.prefix.sum;

public class IterativeTrie extends Trie {

    public IterativeTrie() {
        super();
    }

    @Override
    public void insert(String key, int val) {
        int n = key.length();
        Node node = root;
        for (int i = 0; i < n; i++) {
            int ci = key.charAt(i) - 'a';
            node.sum += val;
            if (node.next[ci] == null) {
                node.next[ci] = new Node();
            }
            node = node.next[ci];
        }
        if (node.val > 0) {
            int diff = node.val;
            node = root;
            for (int i = 0; i < n; i++) {
                int ci = key.charAt(i) - 'a';
                node.sum -= diff;
                node = node.next[ci];
            }
        }
        node.sum += val - node.val;
        node.val = val;
    }

}
