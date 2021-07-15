package ArraysAndString;

public class SetMatrixZeros {

    public static void setZeros (int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean row = false, col = false;

        // check for zero values and set the initial boxes as zero and the flags to true
        for (int i = 0;i < rows;i++) {
            for (int j = 0;j < cols;j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if(i == 0) row = true;
                    if(j == 0) col = true;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(row) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(col) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    static void print2dArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }

    /*---------Test code------------------*/
    public static void main (String[] args) {
        int[][] array = {{1,8,9},
                        {4,0,6},
                        {1,2,3}};
        print2dArray(array);
        System.out.println();
        setZeros(array);
        print2dArray(array);
    }
}
