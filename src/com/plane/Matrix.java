package com.plane;

public class Matrix {
    private int rows, cols;
    private double[][] matrix;

    Matrix(int r, int c, double[][] m) {
        rows = r;
        cols = c;
        matrix = m.clone();
    }

    Matrix(int r, int c) {
        rows = r;
        cols = c;
        matrix = new double[r][c];
    }

    public double at(int row, int col) { return matrix[row-1][col-1]; }

    public void populateWithPoints(Point[] arr) {
        if(arr.length != rows || cols < 3) {
            System.out.println("Array size does not match matrix size.");
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            matrix[i][0] = arr[i].getX();
            matrix[i][1] = arr[i].getY();
            matrix[i][2] = 1.0;
        }
    }

    /** matrix determinant using gaussian elimination **/
    public double determinant() {
        if(rows != cols) {
            System.out.println("Misuse of determinant method. Matrix is not square.");
            return 0;
        }
        double det = 1.0;
        for(int i = 0; i < rows; i++) {
            if(matrix[i][i] == 0) { /** search for a row to exchange with the current one if the pivot is 0 **/
                boolean found = false;
                for(int j = i+1; j < rows; j++)
                    if(matrix[j][i] != 0) {
                        found = true;
                        for(int k = i+1; k < cols; k++)
                            matrix[i][k] += (matrix[j][k] - (matrix[j][k] = matrix[i][k])); /** exchange each element (i, k) with (j, k) **/
                        det *= -1;
                        break;
                    }
                if(found == false) return 0.0;
            }
            det *= matrix[i][i];
            for(int j = i+1; j < rows; j++) {
                double coef = matrix[j][i]/matrix[i][i];
                for (int k = i + 1; k < cols; k++)
                    matrix[j][k] -= matrix[i][k] * coef;
                matrix[j][i] = 0;
            }
        }
        return det;
    }
}
