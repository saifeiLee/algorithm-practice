package chapter1.section4;

import util.StdOut;

public class Practice_1_4_19 {
    public static void main(String[] args) {
        int matrix1[][] = { { 1 } };
        int matrix2[][] = { { 4, 1 },
                { 3, -2 } };
        int matrix3[][] = { { 5, 2, 3 },
                { 4, 6, 1 },
                { 7, 8, 9 } };
        int matrix4[][] = { { 5, 90, 3, 10 },
                { 4, -9, 1, 15 },
                { 7, -1, 9, 19 },
                { 12, 8, 13, 99 } };
        int matrix5[][] = { { 5, 90, 3, 10 },
                { 4, 1, -7, 15 },
                { 7, -1, -8, 19 },
                { 12, 8, 13, 99 } };

        int localMinimum1 = localMinimumMatrix(matrix1);
        int localMinimum2 = localMinimumMatrix(matrix2);
        int localMinimum3 = localMinimumMatrix(matrix3);
        int localMinimum4 = localMinimumMatrix(matrix4);
        int localMinimum5 = localMinimumMatrix(matrix5);

        StdOut.println("Local Minimum Matrix: " + localMinimum1 + " Expected: 1");
        StdOut.println("Local Minimum Matrix: " + localMinimum2 + " Expected: -2");
        StdOut.println("Local Minimum Matrix: " + localMinimum3 + " Expected: 1"); // 2 and 4 would also be valid
        StdOut.println("Local Minimum Matrix: " + localMinimum4 + " Expected: -9");
        StdOut.println("Local Minimum Matrix: " + localMinimum5 + " Expected: -8");
    }

    private static int localMinimumMatrix(int[][] matrix) {
        if (matrix == null) {
            throw new RuntimeException("Matrix cannot be null");
        }
        if (matrix.length != matrix[0].length) {
            throw new RuntimeException("Matrix must be NxN");
        }
        // N = 1
        if (matrix.length == 1) {
            return matrix[0][0];
        }

        if (matrix.length == 2) {
            if (matrix[0][0] < matrix[0][1] && matrix[0][0] < matrix[1][0]) {
                return matrix[0][0];
            } else if (matrix[0][1] < matrix[0][0] && matrix[0][1] < matrix[1][1]) {
                return matrix[0][1];
            } else if (matrix[1][0] < matrix[0][0] && matrix[1][0] < matrix[1][1]) {
                return matrix[1][0];
            } else {
                return matrix[1][1];
            }
        }

        return localMinimumMatrix(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private static int localMinimumMatrix(int[][] matrix, int firstRow, int endRow, int firstColumn, int endColumn) {
        if (firstRow == endRow && firstColumn == endColumn) {
            return matrix[firstRow][firstColumn];
        }

        int currentMiniumElement = matrix[firstRow][firstColumn];
        int currentMiniumElementRow = firstRow;
        int currentMiniumElementColumn = firstColumn;

        int centerRow = firstRow + (endRow - firstRow) / 2;
        int centerColumn = firstColumn + (endColumn - firstColumn) / 2;

        for (int i = firstColumn; i <= endColumn; i++) {
            if (matrix[firstRow][i] < currentMiniumElement) {
                currentMiniumElement = matrix[firstRow][i];
                currentMiniumElementRow = firstRow;
                currentMiniumElementColumn = i;
            }

            if (matrix[endRow][i] < currentMiniumElement) {
                currentMiniumElement = matrix[endRow][i];
                currentMiniumElementRow = endRow;
                currentMiniumElementColumn = i;
            }
        }

        for (int i = firstRow; i <= endRow; i++) {
            if (matrix[i][firstColumn] < currentMiniumElement) {
                currentMiniumElement = matrix[i][firstColumn];
                currentMiniumElementRow = i;
                currentMiniumElementColumn = firstColumn;
            }

            if (matrix[i][endColumn] < currentMiniumElement) {
                currentMiniumElement = matrix[i][endColumn];
                currentMiniumElementRow = i;
                currentMiniumElementColumn = endColumn;
            }
        }

        // check center row
        for (int i = firstColumn; i <= endColumn; i++) {
            if (matrix[centerRow][i] < currentMiniumElement) {
                currentMiniumElement = matrix[centerRow][i];
                currentMiniumElementRow = centerRow;
                currentMiniumElementColumn = i;
            }
        }

        for (int i = firstRow; i <= endRow; i++) {
            if (matrix[i][centerColumn] < currentMiniumElement) {
                currentMiniumElement = matrix[i][centerColumn];
                currentMiniumElementRow = i;
                currentMiniumElementColumn = centerColumn;
            }
        }
        // 上面的元素更小
        if (currentMiniumElementRow - 1 >= 0
                && matrix[currentMiniumElementRow][currentMiniumElementColumn] > matrix[currentMiniumElementRow
                        - 1][currentMiniumElementColumn]) {
            if (currentMiniumElementRow - 1 <= centerRow) {
                endRow = centerRow;
            } else {
                firstRow = centerRow;
            }
            if (currentMiniumElementColumn < centerColumn) {
                endColumn = centerColumn;
            } else {
                firstColumn = centerColumn;
            }
            return localMinimumMatrix(matrix, firstRow, endRow, firstColumn, endColumn);
        } else if (currentMiniumElementRow + 1 < matrix.length
                && matrix[currentMiniumElementRow][currentMiniumElementColumn] > matrix[currentMiniumElementRow
                        + 1][currentMiniumElementColumn]) {
            // 下面的元素更小
            if (currentMiniumElementRow + 1 <= centerRow) {
                endRow = centerRow;
            } else {
                firstRow = centerRow;
            }

            if (currentMiniumElementColumn <= centerColumn) {
                endColumn = centerColumn;
            } else {
                firstColumn = centerColumn;
            }
            return localMinimumMatrix(matrix, firstRow, endRow, firstColumn, endColumn);
        } else if (currentMiniumElementColumn - 1 >= 0
                && currentMiniumElement > matrix[currentMiniumElementRow][currentMiniumElementColumn - 1]) {
            if (currentMiniumElementColumn - 1 < centerColumn) {
                // 左边的元素更小
                endColumn = centerColumn;
            } else {
                firstColumn = centerColumn;
            }

            if (currentMiniumElementRow < centerRow) {
                endRow = centerRow;
            } else {
                firstRow = centerRow;
            }
            return localMinimumMatrix(matrix, firstRow, endRow, firstColumn, endColumn);
        } else if (currentMiniumElementColumn + 1 < matrix[0].length
                && currentMiniumElement > matrix[currentMiniumElementRow][currentMiniumElementColumn + 1]) {
            // 右边的元素更小
            if (currentMiniumElementColumn + 1 < centerColumn) {
                endColumn = centerColumn;
            } else {
                firstColumn = centerColumn;
            }
            return localMinimumMatrix(matrix, firstRow, endRow, firstColumn, endColumn);
        } else {
            return currentMiniumElement;
        }
    }
}
