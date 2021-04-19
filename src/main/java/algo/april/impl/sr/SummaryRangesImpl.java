package algo.april.impl.sr;

import algo.april.SummaryRanges;

public abstract class SummaryRangesImpl implements SummaryRanges{

	protected String createEntry(int start, int end) {
		return start != end ? start + "->" + end : String.valueOf(start);
	}

}