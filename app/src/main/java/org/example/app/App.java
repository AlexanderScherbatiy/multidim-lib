package org.example.app;


import org.multidim.calculator.simple.complex.SimpleComplexCalculator;
import org.multidim.complex.Complex;
import org.multidim.complex.ComplexCalculator;
import org.multidim.complex.ComplexOperation;

public class App {
    public static void main(String[] args) {
        Complex.Cartesian complex1 = new Complex.Cartesian(1, 3);
        Complex.Cartesian complex2 = new Complex.Cartesian(2, -4);
        ComplexOperation op = ComplexOperation.from(complex1).add(ComplexOperation.from(complex2)).negate();
        System.out.printf("Complex operation: %s%n", op);

        ComplexCalculator calculator = new SimpleComplexCalculator();
        ComplexCalculator.Result result = calculator.calculate(op);
        System.out.printf("Complex operation result: %s%n", result);
    }
}
