import java.util.Arrays;
import java.util.Scanner;

public class hills {

    static int row, col;
    static int descenso[][];
    static int matrix[][];

    static int maximo(int a, int b, int c, int d) {
        int arr[] = {a, b, c, d};
        Arrays.sort(arr);
        return arr[3];
    }

    static int maxDepth(int path, int i, int j) {
        if (matrix[i][j] >= path) {
            return 0;
        } 
        else {
            if (descenso[i][j] > 0) {
                return 1 + descenso[i][j];
            } 
            else {
                descenso[i][j] = descenso[i][j] == -2 ? maximo(maxDepth(matrix[i][j], i+1, j), maxDepth(matrix[i][j], i-1, j), maxDepth(matrix[i][j], i, j+1), maxDepth(matrix[i][j], i, j-1)) : descenso[i][j];

                return 1 + descenso[i][j] ;
            }
        }

    }

    static int longest() {

        descenso = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == (row - 1) || j == 0 || j == (col - 1)) {
                    descenso[i][j] = -1;
                } else {
                    descenso[i][j] = -2;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == (row - 1) || j == 0 || j == (col - 1)) {
                    descenso[i][j] = -1;
                } else {
                    if (matrix[i][j] != 101) {
                        descenso[i][j] = maximo(maxDepth(matrix[i][j], i + 1, j), maxDepth(matrix[i][j], i - 1, j), maxDepth(matrix[i][j], i, j + 1), maxDepth(matrix[i][j], i, j - 1));
                    }
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (descenso[i][j] > max) {
                    max = descenso[i][j];
                }
            }
        }

        return max;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        for (int c = 0; c < cases; c++) {
            String name = scan.next();
            row = scan.nextInt() + 2;
            col = scan.nextInt() + 2;
            matrix = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == 0 || i == (row - 1) || j == 0 || j == (col - 1)) {
                        matrix[i][j] = 101;
                    } else {
                        matrix[i][j] = scan.nextInt();
                    }
                }
            }
            int large = longest()+1;
            System.out.println(name + ": " + large);
        }
    }
}
