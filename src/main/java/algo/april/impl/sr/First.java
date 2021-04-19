package algo.april.impl.sr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import algo.april.SummaryRanges;
import algo.util.ArrayUtil;

// It should have struck me that I can do binary search
public class First extends SummaryRangesImpl {

	@Override
	public List<String> summaryRanges(int[] a) {
		if (ArrayUtil.isEmpty(a)) {
			return Collections.emptyList();
		}
		if (a.length == 1) {
			return Collections.singletonList(String.valueOf(a[0]));
		}

		int start = a[0];
		int end;
		List<String> result = new ArrayList<>();
		int lastIndex = a.length - 1;
		for (int i = 0; i < a.length - 1; i++) {
			if (isConsecutive(a[i + 1], a[i])) {
				continue;
			}
			end = a[i];
			result.add(createEntry(start, end));
			start = a[i + 1];
		}
		end = a[lastIndex];
		result.add(createEntry(start, end));
		return result;
	}

	private boolean isConsecutive(int a, int b) {
		return Math.abs(a - b) == 1;
	}

}
