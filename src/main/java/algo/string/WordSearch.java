package algo.string;

import java.util.HashSet;
import java.util.Set;

class WordSearch {
    private Set<Integer> visited = new HashSet<>();
    private String s;
    private char[][] board;
    private int cols, rows;

    public boolean exist(char[][] board, String word) {
        s=word;
        this.board = board;

        rows = board.length;
        cols = board[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(backtrack(0,r,c)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrack(int si,int r,int c){
        if(board[r][c]==s.charAt(si)){
            if(si==s.length()-1){
                return true;
            }
            visited.add(r*cols+c);
            int[][] neighbors = {{r-1,c},{r+1,c},{r,c-1},{r,c+1}};
            for(int[] neigh:neighbors){
                int x = neigh[0], y = neigh[1];
                if(x<0 || x==rows || y<0 || y==cols){
                    continue;
                }
                if(visited.contains(x*cols+y)){
                    continue;
                }
                if(backtrack(si+1,x,y)){
                    return true;
                }
            }
            visited.remove(r*cols+c);
        }
        return false;
    }
}