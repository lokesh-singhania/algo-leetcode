package algo.string.zigzag;

import algo.string.ZigZag;

import java.util.Arrays;

public class Rows implements ZigZag {
    @Override
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        Arrays.setAll(rows, t->new StringBuilder());
        int ra=0;
        for(int i=0,r=0;i<s.length();i++,r += ra){
            rows[r].append(s.charAt(i));
            if(r==numRows-1){
                ra = -1;
            }else if(r==0){
                ra = 1;
            }
        }
        return String.join("",rows);
    }
}
