package org.example.app;


import org.multidim.complex.Complex;
import org.multidim.complex.ComplexOperation;

public class App {
    public static void main(String[] args) {
        Complex.Cartesian complex1 = new Complex.Cartesian(1, 0);
        Complex.Cartesian complex2 = new Complex.Cartesian(0, 1);
        ComplexOperation op = ComplexOperation.from(complex1).add(ComplexOperation.from(complex2)).negate();
        System.out.printf("Complex operation: %s%n", op);
    }
}
