package org.multidim.calculator.simple.complex;

import org.multidim.complex.ComplexCalculator;
import org.multidim.complex.ComplexOperation;
import org.multidim.complex.ComplexOptimizer;

import java.util.Map;

public class SimpleComplexCalculator implements ComplexCalculator {

    private final Strategy strategy;

    public enum Strategy {
        CARTESIAN,
        POLAR,
    }

    public SimpleComplexCalculator() {
        this(Strategy.CARTESIAN);
    }

    public SimpleComplexCalculator(Strategy strategy) {
        this.strategy = strategy;
    }

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
        switch (strategy) {
            case CARTESIAN -> {
                SimpleComplexCartesianStrategy s = new SimpleComplexCartesianStrategy();
                SimpleComplexCartesianStrategy.CartesianResult result = s.calculateOperation(operation);
                return new SimpleResult(result.real, result.image);
            }
            case POLAR -> {
                SimpleComplexPolarStrategy s = new SimpleComplexPolarStrategy();
                SimpleComplexPolarStrategy.PolarResult result = s.calculateOperation(operation);
                double real = ComplexMath.real(result.radius, result.angle);
                double image = ComplexMath.image(result.radius, result.angle);
                return new SimpleResult(real, image);
            }
            default -> throw new RuntimeException(String.format("Unknown strategy: %", strategy));
        }
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
