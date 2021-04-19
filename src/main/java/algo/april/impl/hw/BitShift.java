package algo.april.impl.hw;

import algo.april.HammingWeight;

//Signed and unsigned bitshift operators
public class BitShift implements HammingWeight {
    @Override
    public int hammingWeight(int n) {
        int weight=0;
        while(n!=0){
            if((n&1)==1){
                weight++;
            }
            n>>>=1;
        }
        return weight;
    }

    public static void main(String[] args) {
        int result = new BitShift().hammingWeight(-3);
        System.out.println(result);
    }
}
