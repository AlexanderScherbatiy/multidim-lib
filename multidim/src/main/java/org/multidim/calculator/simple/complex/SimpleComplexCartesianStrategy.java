package org.multidim.calculator.simple.complex;

import org.multidim.complex.Complex;
import org.multidim.complex.ComplexOperation;

class SimpleComplexCartesianStrategy {

    CartesianResult calculateOperation(ComplexOperation operation) {
        CartesianResult result = new CartesianResult();
        calculateOperation(operation, result);
        return result;
    }

    private void calculateComplex(Complex complex, CartesianResult result) {
        switch (complex) {
            case Complex.Cartesian cartesian -> {
                result.real = cartesian.real();
                result.image = cartesian.imaginary();
            }
            case Complex.Polar polar -> {
                result.real = polar.radius() * Math.cos(polar.angle());
                result.image = polar.radius() * Math.sin(polar.angle());
            }
        }
    }

    private void calculateOperation(ComplexOperation operation, CartesianResult result) {
        switch (operation) {
            case ComplexOperation.ComplexValue value: {
                calculateComplex(value.complex(), result);
                break;
            }
            case ComplexOperation.Negate negate: {
                calculateOperation(negate.operation(), result);
                result.real = -result.real;
                result.image = -result.image;
                break;
            }
            case ComplexOperation.Sum sum: {
                calculateOperation(sum.complex2(), result);
                double real = result.real;
                double image = result.image;
                calculateOperation(sum.complex1(), result);
                result.real += real;
                result.image += image;
                break;
            }
        }
    }

    static class CartesianResult {
        double real;
        double image;
    }
}
