package algo.design.prefix.sum;

public class RecursiveTrie extends Trie {

    public RecursiveTrie() {
        super();
    }

    public void insert(String key, int val) {
        add(root, key, 0, val);
    }

    private Result add(Node node, String s, int i, int val) {
        if (node == null) {
            node = new Node();
        }
        if (i == s.length()) {
            int diff = val - node.val;
            node.sum += diff;
            node.val = val;
            return new Result(node, diff);
        }
        int ci = s.charAt(i) - 'a';
        Result result = add(node.next[ci], s, i + 1, val);
        node.next[ci] = result.node;
        node.sum += result.diff;
        return new Result(node, result.diff);
    }

    record Result(Node node, int diff) {
    }

}


