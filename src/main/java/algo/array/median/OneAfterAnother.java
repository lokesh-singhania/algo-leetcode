package algo.array.median;

public class OneAfterAnother implements Median {

    public static void main(String[] args) {
        var a1=new int[]{2,2,4,4};
        int[] a2={2,2,4,4};
        System.out.println( new OneAfterAnother().findMedianSortedArrays(a1,a2));
    }

    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { // [1,1], [1,1]
        int n1 = nums1.length; // 2
        int n2 = nums2.length;// 1
        int n = n1+n2; // 4
        int lessElements = (n-1)/2; //1
        int medianIndex = findMedianIndex(nums1,nums2,lessElements); // 0
        if(medianIndex==-1){
            var t = nums1;
            nums1 = nums2;
            nums2 = t;
            medianIndex = findMedianIndex(nums1, nums2, lessElements);
        }
        if(n%2==0){
            //find an element with lessElements+1
            int firstMedian = nums1[medianIndex];//2
            lessElements++;
            var otherMedianIndex = findMedianIndex(nums1, nums2, lessElements);
            if(otherMedianIndex==-1){
                var t = nums1;
                nums1 = nums2;
                nums2 = t;
                otherMedianIndex = findMedianIndex(nums1, nums2,lessElements);
            }
            var otherMedian = nums1[otherMedianIndex];
            return (double) (firstMedian + otherMedian) /2;
        }else{
            return nums1[medianIndex];
        }
    }

    // Returns index of first array with = lessElements in both arrays, -1 if not found
    int findMedianIndex(int[] a1,int[] a2, int requiredLessElements){// [1,3] [2,4] 2
        int low=0;// 0
        int high = a1.length-1;// 1
        while(low<=high){//0<0 - true
            int mid = (low+high)/2;
            int element = a1[mid];
            var lesser1 = lesserCounts(a1,element,true);
            var lesser2 = lesserCounts(a2,element,false);
            int minLesser = lesser1[0]+lesser2[0]; // 1
            int maxLesser = lesser1[1]+lesser2[1];
            if(maxLesser<requiredLessElements){ //
                low = mid+1; //
            }else if(minLesser>requiredLessElements){// 2>1
                high = mid-1; //
            }else{
                return mid;
            }
        }
        return -1;
    }


    int[] lesserCounts(int[] a,int value,boolean excludeSelf){
        var min = lesserCount(a,value);
        var max = min;
        if(min<a.length && a[min]==value){
            max = lesserCount(a,value+1);
            if(excludeSelf){
                max = Math.max(min,max-1);
            }
        }
        return new int[]{min,max};
    }

    int lesserCount(int[] a,int value){
        int low = 0;
        int high = a.length-1;

        while(low<=high){
            int mid = (low+high+1)/2;
            if(a[mid] >= value){// towards left inc.
                high = mid-1;
            }else if(a[mid] < value){// right
                low = mid+1;
            }
        }
        return high+1;
    }
 }
