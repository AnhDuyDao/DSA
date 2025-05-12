import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int diagonalSum(int[][] mat) {
        int m = mat.length; // số hàng
        int n = mat[0].length; // số cột
        int sum = 0;
        int doubleValue = 0;
        for (int i = 0; i < n; i++) {
            if (m == n && n % 2 !=0 && m % 2 != 0) {
                if (i == n / 2) {
                    doubleValue = mat[i][i];
                }
            }
            sum += mat[i][i]; // Main Diagonal
            sum += mat[i][n - 1 - i]; // Anti-Diagonal
        }
        return sum - doubleValue;
    }

    public static int countOnesAround(int[][] matrix, int i, int j) {
        int m = matrix.length; // số hàng
        int n = matrix[0].length; // số cột

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int count = 0;

        for (int dir = 0; dir < 4; dir++) {
            int ni = i + dx[dir];
            int nj = j + dy[dir];

            if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                if (matrix[ni][nj] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;


            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }


    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int rowTransposeMatrix = n;
        int columnTransposeMatrix = m;
        int[][] transposedMatrix = new int[rowTransposeMatrix][columnTransposeMatrix];

        for (int i = 0; i < rowTransposeMatrix; i++) {
            for (int j = 0; j < columnTransposeMatrix; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }

        return transposedMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix1 = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
        };

        int[][] matrix2 = {
                {5}
        };

        int[][] matrix3 = {
                {0, 1, 0},
                {1, 1, 0},
                {0, 1, 1}
        };

        int[][] matrix4 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int m = matrix.length; // số hàng
        int n = matrix[0].length; // số cột

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};



//        // Row - Column Traversal
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }

        // Row Traversal
//        for (int i = 0; i < m; i++) {
//
//        }

        // Column Traversal
//        for (int j = 0; j < n; j++) {
//            // xử lý cột j
//        }
//        System.out.println("=========================");
//        // Main Diagonal Traversal
//        for (int i = 0; i < n; i++) {
//            System.out.print(matrix[i][i] + " ");
//        }
//        System.out.println();
//        System.out.println("=========================");
//        // Anti-Diagonal Traversal
//        for (int i = 0; i < n; i++) {
//            System.out.print(matrix[i][n - 1 - i] + " ");
//        }

//        System.out.println("Sum of the matrix: " + diagonalSum(matrix2));
//
//        System.out.println("Count of 1s around (1, 1): " + countOnesAround(matrix3, 1, 1));
//
//
//        List<Integer> result1 = spiralOrder(matrix);
//        for (int num : result1) {
//            System.out.print(num + " ");
//        }



        int[][] result2 = transpose(matrix4);
        for (int i = 0; i < result2.length; i++) {
            for (int j = 0; j < result2[i].length; j++) {
                System.out.print(result2[i][j] + " ");
            }
            System.out.println();
        }
    }
}