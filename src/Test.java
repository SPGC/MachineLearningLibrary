import LinearAlgebra.Matrix;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        double[][] delta = new double[5][5];
        double[][] deltaA = new double[5][5];
        double[][] deltaB = new double[5][5];
        double[][] deltaC = new double[5][5];
        double[][] deltaD = new double[5][5];
        double[][] deltaE = new double[5][5];
        int x, answer;
        for (int i = 0; i < 5; i++) {
            x = in.nextInt();
            answer = in.nextInt();
            for (int j = 0; j < 5; j++) {
                delta[i][j] = (int) Math.pow(x, j);
                deltaA[i][j] = (int) Math.pow(x, j);
                deltaB[i][j] = (int) Math.pow(x, j);
                deltaC[i][j] = (int) Math.pow(x, j);
                deltaD[i][j] = (int) Math.pow(x, j);
                deltaE[i][j] = (int) Math.pow(x, j);
            }
            deltaA[i][0] = answer;
            deltaB[i][1] = answer;
            deltaC[i][2] = answer;
            deltaD[i][3] = answer;
            deltaE[i][4] = answer;
        }
        Matrix deltaM = new Matrix(delta);
        Matrix deltaMA = new Matrix(deltaA);
        Matrix deltaMB = new Matrix(deltaB);
        Matrix deltaMC = new Matrix(deltaC);
        Matrix deltaMD = new Matrix(deltaD);
        Matrix deltaME = new Matrix(deltaE);
        double a = deltaMA.determinant() / deltaM.determinant();
        double b = deltaMB.determinant() / deltaM.determinant();
        double c = deltaMC.determinant() / deltaM.determinant();
        double d = deltaMD.determinant() / deltaM.determinant();
        double e = deltaME.determinant() / deltaM.determinant();
        double result = Math.pow(9, 0) * a + Math.pow(9, 1) * b + Math.pow(9, 2) * c + Math.pow(9, 3) * d + Math.pow(9, 4) * e;
        System.out.println(result);
        System.out.println(a + " " + b + " " + c + " " + d + " " + e);
    }
}
