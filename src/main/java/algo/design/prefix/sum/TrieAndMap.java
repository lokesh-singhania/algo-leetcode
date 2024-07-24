package algo.design.prefix.sum;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TrieAndMap extends Trie {
    Map<String, Integer> keyValues;

    TrieAndMap() {
        super();
        keyValues = new HashMap<>();
    }

    @Override
    public void insert(String key, int val) {
        int n = key.length();
        Node node = root;
        val -= Optional.ofNullable(keyValues.put(key, val))
                .orElse(0);
        for (int i = 0; i < n; i++) {
            int ci = key.charAt(i) - 'a';
            node.sum += val;
            if (node.next[ci] == null) {
                node.next[ci] = new Node();
            }
            node = node.next[ci];
        }
        node.val = val;
        node.sum += val;
    }
}
