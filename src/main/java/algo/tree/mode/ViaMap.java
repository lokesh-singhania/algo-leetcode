package algo.tree.mode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import algo.annotations.Complexity;
import algo.annotations.ComplexityValue;
import models.TreeNode;
import algo.tree.Mode;
import algo.util.ArrayUtil;

@Complexity(time = ComplexityValue.LINEAR, space = ComplexityValue.LINEAR)
public class ViaMap implements Mode {

	// Perform a bfs/dfs and populate the frequency map ->
	// find max Freq via map traversal
	// find keys with that frequency in another traversal
	@Override
	public int[] mode(TreeNode root) {

		Map<Integer, Integer> freq = new HashMap<>();
		populateFrequencies(root, freq);

		int maxFreq = maxValue(freq);

		Collection<Integer> modes = withFreq(freq, maxFreq);

		return ArrayUtil.toArray(modes);
	}

	private Collection<Integer> withFreq(Map<Integer, Integer> map, int value) {
		Collection<Integer> keysWithGivenValue = new ArrayList<>();
		for(var entry: map.entrySet()) {
			if(entry.getValue()==value) {
				keysWithGivenValue.add(entry.getKey());
			}
		}
		return keysWithGivenValue;
	}

	private int maxValue(Map<Integer, Integer> map) {
		return map.values().stream().max(Integer::compare).orElse(0);
	}

	private void populateFrequencies(TreeNode node, Map<Integer, Integer> freq) {
		if (node != null) {
			freq.merge(node.val, 1, (old, one) -> old + one);
			populateFrequencies(node.left, freq);
			populateFrequencies(node.right, freq);
		}
	}

}
