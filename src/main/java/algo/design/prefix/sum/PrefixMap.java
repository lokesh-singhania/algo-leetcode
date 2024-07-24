package algo.design.prefix.sum;

import algo.design.PrefixSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class PrefixMap implements PrefixSum {

    Map<String, Integer> prefixes;
    Map<String, Integer> keys;

    public PrefixMap() {
        prefixes = new HashMap<>();
        keys = new HashMap<>();
    }

    public void insert(String key, int val) {
        val -= Optional.ofNullable(keys.put(key, val))
                .orElse(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < key.length(); i++) {
            sb.append(key.charAt(i));
            prefixes.merge(sb.toString(), val, Integer::sum);
        }
    }

    public int sum(String prefix) {
        return prefixes.getOrDefault(prefix, 0);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */