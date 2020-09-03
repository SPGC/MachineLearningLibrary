import LinearAlgebra.Matrix;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        double[][] delta = new double[6][6];
        double[][] deltaA = new double[6][6];
        double[][] deltaB = new double[6][6];
        double[][] deltaC = new double[6][6];
        double[][] deltaD = new double[6][6];
        double[][] deltaE = new double[6][6];
        double[][] deltaF = new double[6][6];
        int x;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                x = in.nextInt();
                if (j != 6) {
                    delta[i][j] = x;
                    deltaA[i][j] = x;
                    deltaB[i][j] = x;
                    deltaC[i][j] = x;
                    deltaD[i][j] = x;
                    deltaE[i][j] = x;
                    deltaF[i][j] = x;

                }
                if (j == 6) {
                    deltaA[i][0] = x;
                    deltaB[i][1] = x;
                    deltaC[i][2] = x;
                    deltaD[i][3] = x;
                    deltaE[i][4] = x;
                    deltaF[i][5] = x;
                }
            }
        }
        Matrix deltaM = new Matrix(delta);
        Matrix deltaMA = new Matrix(deltaA);
        Matrix deltaMB = new Matrix(deltaB);
        Matrix deltaMC = new Matrix(deltaC);
        Matrix deltaMD = new Matrix(deltaD);
        Matrix deltaME = new Matrix(deltaE);
        Matrix deltaMF = new Matrix(deltaF);
        double a = deltaMA.determinant() / deltaM.determinant();
        double b = deltaMB.determinant() / deltaM.determinant();
        double c = deltaMC.determinant() / deltaM.determinant();
        double d = deltaMD.determinant() / deltaM.determinant();
        double e = deltaME.determinant() / deltaM.determinant();
        double f = deltaMF.determinant() / deltaM.determinant();
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f);
    }
}
