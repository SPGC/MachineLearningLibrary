package LinearAlgebra;

public class Vector {
    private double[] vector;
    private int length;

    public Vector(double[] vector) {
        this.vector = vector;
        length = vector.length;
    }

    public Vector(int a) {
        vector = new double[a];
        length = a;
    }

    public double getElement(int a) {
        return vector[a];
    }

    public void setElement(int a, double element) {
        vector[a] = element;
    }

    public Vector sum(Vector summable) {
        double[] buf = new double[length];
        for (int i = 0; i < length; i++) {
            buf[i] =  vector[i] + summable.getElement(i);
        }
        return new Vector(buf);
    }

    public double scalarMultiply(Vector a) throws Exception {
        if (length != a.length) {
            throw new Exception("Vectors aren\'t same length");
        }
        double result = 0;
        for (int i = 0; i < length; i++) {
            result += vector[i] * a.vector[i];
        }
        return result;
    }
}
