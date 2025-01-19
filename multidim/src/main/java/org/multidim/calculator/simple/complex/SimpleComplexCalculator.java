package org.multidim.calculator.simple.complex;

import org.multidim.complex.Complex;
import org.multidim.complex.ComplexCalculator;
import org.multidim.complex.ComplexOperation;
import org.multidim.complex.ComplexOptimizer;

import java.util.Map;

public class SimpleComplexCalculator implements ComplexCalculator {

    @Override
    public Result calculate(ComplexOperation operation) {
        return calculate(operation, null, null);
    }

    @Override
    public Result calculate(ComplexOperation operation, ComplexOptimizer optimizer) {
        return calculate(operation, optimizer, null);
    }

    @Override
    public Result calculate(ComplexOperation operation, ComplexOptimizer optimizer, Map<String, ComplexOperation> variables) {
        CartesianResult result = new CartesianResult();
        calculateCartesianOperation(operation, result);
        return new SimpleResult(result.real, result.image);
    }

    private void calculateCartesianComplex(Complex complex, CartesianResult result) {
        switch (complex) {
            case Complex.Cartesian cartesian -> {
                result.real = cartesian.real();
                result.image = cartesian.imaginary();
            }
            case Complex.Polar polar -> {
                result.real = polar.radius() * Math.cos(polar.angle());
                result.image = polar.radius() * Math.cos(polar.angle());
            }
        }
    }

    private void calculateCartesianOperation(ComplexOperation operation, CartesianResult result) {
        switch (operation) {
            case ComplexOperation.ComplexValue value: {
                calculateCartesianComplex(value.complex(), result);
                break;
            }
            case ComplexOperation.Negate negate: {
                calculateCartesianOperation(negate.operation(), result);
                result.real = -result.real;
                result.image = -result.image;
                break;
            }
            case ComplexOperation.Sum sum: {
                calculateCartesianOperation(sum.complex2(), result);
                double real = result.real;
                double image = result.image;
                calculateCartesianOperation(sum.complex1(), result);
                result.real += real;
                result.image += image;
                break;
            }
        }
    }

    private static class CartesianResult {
        double real;
        double image;
    }

    private record SimpleResult(double real, double image) implements Result {

        @Override
        public double getReal() {
            return real;
        }

        @Override
        public double getImage() {
            return image;
        }
    }
}
