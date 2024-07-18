package algo.tree.mode;

import static algo.util.ArrayUtil.toArray;

import java.util.ArrayList;
import java.util.Collection;

import models.TreeNode;
import algo.tree.Mode;

public class Inorder implements Mode {

	class Modes {
		int freq;
		Collection<Integer> values;

		public Modes(int freq, Collection<Integer> values) {
			super();
			this.freq = freq;
			this.values = values;
		}

	}

	class Candidate {
		int value;
		int freq;
		public Candidate(int value, int freq) {
			this.value = value;
			this.freq = freq;
		}
	}

	Candidate candidate;
	Modes modes;

	public Inorder() {
		modes = new Modes(0, new ArrayList<>());
	}

	@Override
	public int[] mode(TreeNode root) {
		inorder(root);
		updateModIfNecessary();
		return toArray(modes.values);
	}

	void inorder(TreeNode node) {
		if (node == null)
			return;

		inorder(node.left);

		check(node.val);

		inorder(node.right);

	}

	private void check(int value) {
		if (candidate == null) {
			candidate = new Candidate(value, 1);
		} else if (candidate.value != value) {
			// update mod
			updateModIfNecessary();
			// refresh candidate
			candidate.freq = 1;
			candidate.value = value;
		} else {
			candidate.freq++;
		}
	}

	void updateModIfNecessary() {
		if (modes.freq < candidate.freq) {
			modes.freq = candidate.freq;
			modes.values.clear();
			modes.values.add(candidate.value);
		} else if (modes.freq == candidate.freq) {
			modes.values.add(candidate.value);
		}
	}
}
