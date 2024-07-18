package algo.matrix;

public class TopLitz {


    boolean toe(int[][] matrix){
        int numberOfColumns=matrix[0].length;
        for(int col=0;col<numberOfColumns;col++){
            int element = matrix[0][col];
            for(int row=1;row<matrix.length && row+col<numberOfColumns;row++){
                if(matrix[row][col+row]!=element){
                    return false;
                }
            }
        }
        return true;
    }
}
