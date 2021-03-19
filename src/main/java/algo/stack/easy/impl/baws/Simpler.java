package algo.stack.easy.impl.baws;

import java.util.ArrayList;
import java.util.List;

import algo.stack.easy.BuildArrayWithStack;

public class Simpler implements BuildArrayWithStack {

	@Override
	public List<String> buildArray(int[] target, int n) {
		List<String> list = new ArrayList<String>();
		int i = 0;
		int j = 0;
		while (i++ <= n && j < target.length) {
			list.add("Push");
			if (target[j] == i)
				j++;
			else
				list.add("Pop");
		}

		return list;
	}
}
