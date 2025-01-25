package org.multidim.calculator.simple.complex;

import org.multidim.complex.Complex;
import org.multidim.complex.ComplexOperation;

class SimpleComplexPolarStrategy {

    PolarResult calculateOperation(ComplexOperation operation) {
        PolarResult result = new PolarResult();
        calculateOperation(operation, result);
        return result;
    }

    private void calculateComplex(Complex complex, PolarResult result) {
        switch (complex) {
            case Complex.Cartesian cartesian -> {
                result.radius = ComplexMath.radius(cartesian);
                result.angle = ComplexMath.angle(cartesian);
            }
            case Complex.Polar polar -> {
                result.radius = polar.radius();
                result.angle = polar.angle();
            }
        }
    }

    private void calculateOperation(ComplexOperation operation, PolarResult result) {
        switch (operation) {
            case ComplexOperation.ComplexValue value: {
                calculateComplex(value.complex(), result);
                break;
            }
            case ComplexOperation.Negate negate: {
                calculateOperation(negate.operation(), result);
                // TBD: check that the angle is less than 360 degrees
                result.angle = Math.PI + result.angle;
                break;
            }
            case ComplexOperation.Sum sum: {
                calculateOperation(sum.complex2(), result);
                double real = ComplexMath.real(result.radius, result.angle);
                double image = ComplexMath.image(result.radius, result.angle);
                calculateOperation(sum.complex1(), result);
                real += ComplexMath.real(result.radius, result.angle);
                image += ComplexMath.image(result.radius, result.angle);
                result.radius = ComplexMath.radius(real, image);
                result.angle = ComplexMath.angle(real, image);
                break;
            }
        }
    }

    static class PolarResult {
        double radius;
        double angle;
    }
}
