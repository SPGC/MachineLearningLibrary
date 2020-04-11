package LinearAlgebra;

import java.util.Arrays;

public class Matrix {
    private double[][] matrix;
    private int lines, columns;

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Matrix(double[][] matrix) {
        lines = matrix.length;
        columns = matrix[0].length;
        this.matrix = new double[lines][columns];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, matrix[0].length);
        }
    }

    public Matrix(int a, int b) {
        matrix = new double[a][b];
        lines = a;
        columns = b;
    }

    public Matrix transposition() {
        double[][] buf = new double[columns][lines];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                buf[j][i] = matrix[i][j];
            }
        }
        return new Matrix(buf);
    }

    public Matrix multiplyOnNumber(Double a) {
        Matrix result = new Matrix(lines, columns);
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                result.setElement(i, j, (matrix[i][j] * a));//Recheck
            }
        }
        return result;
    }

    public double getElement(int i, int j) {
        return matrix[i][j];
    }

    public void setElement(int i, int j, double element) {
        matrix[i][j] = element;
    }

    public Matrix sum(Matrix summable) throws Exception {
        double[][] buf = new double[lines][columns];
        if (getColumns() != summable.getColumns() || getLines() != summable.getLines()) {
            throw new Exception("Trying to sum matrixes of different shape");
        }
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                buf[i][j] = matrix[i][j] + summable.getElement(i, j);
            }
        }
        return new Matrix(buf);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                s.append(matrix[i][j]).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public Matrix multiplyOnMatrix(Matrix a) throws Exception {
        if (columns != a.lines) {
            throw new Exception("Matrixes aren't correct shape");
        }
        Matrix bufMatrix = a.transposition();
        double[][] result = new double[lines][a.columns];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < a.columns; j++) {
                result[i][j] = new Vector(matrix[i]).scalarMultiply(new Vector(bufMatrix.matrix[j]));
            }
        }
        return new Matrix(result);
    }

    public double determinant() throws Exception {
        if (columns != lines) {
            throw new Exception("Matrix isn't square");
        }
        if (columns == 1) {
            return matrix[0][0];
        } else if (columns == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        } else {
            double result = 0;
            for (int i = 0; i < columns; i++) {
                result += dop(this, 0, i);
            }
            return result;
        }
    }

    private static double dop(Matrix m, int i, int j) throws Exception {
        return Math.pow(-1, i + j) * m.getElement(i, j) * minor(m, i, j);
    }

    private static double minor(Matrix m, int i, int j) throws Exception {
        Matrix buf = new Matrix(m.lines - 1, m.columns - 1);
        int bufk = 0, bufl = 0;
        for (int k = 0; k < m.lines; k++) {
            if (k == i) {
                bufk = 1;
                continue;
            }
            for (int l = 0; l < m.columns; l++) {
                if (l == j) {
                    bufl = 1;
                    continue;
                }
                buf.setElement(k - bufk, l - bufl, m.getElement(k, l));
            }
            bufl = 0;
        }
        return buf.determinant();
    }
}
