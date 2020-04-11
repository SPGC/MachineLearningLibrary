import LinearAlgebra.Matrix;

public class Test {
    public static void main(String[] args) {
        double[][] a = {{1,-1,2},{4,2,0},{-5,6,1}};
        double[][] b = {{1, -2, 4},{3,0,-5}};
        try{
            Matrix m1 = new Matrix(a);
            System.out.println(m1.determinant());
            Matrix m2 = new Matrix(b).transposition();
            System.out.println(m1.multiplyOnMatrix(m2).toString());
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
