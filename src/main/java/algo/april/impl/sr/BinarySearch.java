package algo.april.impl.sr;

import java.util.List;

public class BinarySearch extends  ExponentialBreakpointSearch{
    @Override
    protected int findNextBreakpoint(int[] nums, int start,int end) {
        while(start<end){
            int mid=start+(end-start+1)/2;
            if(nums[mid]-nums[start]==mid-start){
                start=mid;
            }else{
                end=mid-1;
            }
        }
        return start;
    }
}
