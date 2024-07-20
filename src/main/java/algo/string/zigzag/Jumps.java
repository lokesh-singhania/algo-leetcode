package algo.string.zigzag;

import algo.string.ZigZag;

public class Jumps implements ZigZag {
    @Override
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        int n = s.length();
        int jump = 2*(numRows-1);
        var sb = new StringBuilder(s.length());
        for(int row=0;row<numRows;row++){
            for(int left=0,right=jump;left+row<n;left+=jump,right+=jump){
                int first = left+row;
                sb.append(s.charAt(first));

                int second = right-row;
                if(row==0 || row==numRows-1 || second>=n){
                    continue;
                }
                sb.append(s.charAt(second));
            }
        }
        return sb.toString();
    }
}
