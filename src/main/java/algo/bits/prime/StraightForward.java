package algo.bits.prime;

import algo.bits.PrimeBits;

public class StraightForward implements PrimeBits {

    @Override
    public int primeBits(int left, int right) {
        int count=0;
        for(int i=left;i<=right;i++){
            int bits = bitCount(i);
            if(prime(bits)){
                count++;
            }
        }
        return count;
    }

    private boolean prime(int n){
        if(n==1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
    private int bitCount(int n) {
        int bitCount=0;
        while(n>0){
            if(n%2==1) bitCount++;
            n/=2;
        }
        return bitCount;
    }

}
