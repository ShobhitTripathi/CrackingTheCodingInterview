package ArraysAndString;

public class RotateMatrix {

    static int[][] rotate(int[][] arr) {
        //reverse the array
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int[] temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        //Transpose the matrix
        for (int i = 0; i < arr.length;i++) {
            for (int j = i + 1;j < arr[i].length;j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        return arr;
    }

    static void print2dArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }

    public static void main (String[] args) {
        int[][] array = {{7,8,9},
                         {4,5,6},
                         {1,2,3}};
        print2dArray(array);
        System.out.println();
        int[][] afterRotate =  rotate(array);
        print2dArray(afterRotate);
    }
}
