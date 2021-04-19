package algo.april.impl.sr;

import java.util.ArrayList;
import java.util.List;

import algo.april.SummaryRanges;

public class ExponentialBreakpointSearch extends  SummaryRangesImpl{
	@Override
	public List<String> summaryRanges(int[] a) {
		int startIndex=0;
		List<String> ranges=new ArrayList<>();
		while(startIndex< a.length) {
			int endIndex=findNextBreakpoint(a,startIndex, a.length-1);
			ranges.add(createEntry(a[startIndex], a[endIndex]));
			startIndex=endIndex+1;
		}
		return ranges;
	}

	protected int findNextBreakpoint(int[] nums, int start, int end) {
		if(start==nums.length-1){
			return start;
		}
		int distance=1;
		int distanceUpperBound=end-start;
		int distanceLowerBound=0;
		while(distanceLowerBound<distanceUpperBound){
			if(nums[start+distance]-nums[start]==distance){
				distanceLowerBound=distance;
				distance=Math.min(distanceUpperBound,distance*2);
			}else{
				distanceUpperBound=distance-1;
				distance=distanceLowerBound+(distance-distanceLowerBound)/2;
			}
		}
		return start+distanceLowerBound;
	}

}
