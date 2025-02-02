package org.multidim.calculator.simple.complex;

import org.junit.jupiter.api.Test;
import org.multidim.complex.Complex;
import org.multidim.complex.ComplexCalculator;
import org.multidim.complex.ComplexOperation;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class SimpleComplexCalculatorBaseTest {

    private static final double PRECISION = 0.01;

    private static final double MIN = -1000.0;
    private static final double MAX = 1000;

    private final Random random = new Random();

    private ComplexCalculator calculator;

    public ComplexCalculator getCalculator() {
        return calculator;
    }

    void setCalculator(ComplexCalculator calculator) {
        this.calculator = calculator;
    }

    @Test
    void calculateCartesianNegate() {
        ComplexOperation c = ComplexOperation.from(new Complex.Cartesian(-1, 2));
        ComplexOperation negate = c.negate();

        ComplexCalculator calculator = getCalculator();
        ComplexCalculator.Result result = calculator.calculate(negate);

        assertEquals(result.getReal(), 1.0, PRECISION);
        assertEquals(result.getImage(), -2.0, PRECISION);
    }

    @Test
    void calculatePolarNegate() {
        ComplexOperation c = ComplexOperation.from(new Complex.Polar(10.0, Math.PI / 2));
        ComplexOperation negate = c.negate();

        ComplexCalculator calculator = getCalculator();
        ComplexCalculator.Result result = calculator.calculate(negate);

        assertEquals(result.getReal(), 0.0, PRECISION);
        assertEquals(result.getImage(), -10.0, PRECISION);
    }

    @Test
    void calculateCartesianSum() {
        ComplexOperation c1 = ComplexOperation.from(new Complex.Cartesian(1, 2));
        ComplexOperation c2 = ComplexOperation.from(new Complex.Cartesian(3, -4));
        ComplexOperation sum = c1.add(c2);

        ComplexCalculator calculator = getCalculator();
        ComplexCalculator.Result result = calculator.calculate(sum);

        assertEquals(result.getReal(), 4.0, PRECISION);
        assertEquals(result.getImage(), -2.0, PRECISION);
    }

    @Test
    void calculatePolarSum() {
        ComplexOperation c1 = ComplexOperation.from(new Complex.Polar(5, Math.PI / 4));
        ComplexOperation c2 = ComplexOperation.from(new Complex.Polar(5, 3 * Math.PI / 4));
        ComplexOperation sum = c1.add(c2);

        ComplexCalculator calculator = getCalculator();
        ComplexCalculator.Result result = calculator.calculate(sum);

        assertEquals(result.getReal(), 0.0, PRECISION);
        assertEquals(result.getImage(), Math.sqrt(2) * 5, PRECISION);
    }


    @Test
    void calculateRandomCartesianSum() {
        final int N = 8;
        for (int i = 0; i < N; i++) {
            double x1 = random.nextDouble(MIN, MAX);
            double y1 = random.nextDouble(MIN, MAX);
            double x2 = random.nextDouble(MIN, MAX);
            double y2 = random.nextDouble(MIN, MAX);

            Complex c1 = new Complex.Cartesian(x1, y1);
            Complex c2 = new Complex.Cartesian(x2, y2);
            ComplexOperation op = ComplexOperation.from(c1).add(ComplexOperation.from(c2));
            checkOperation(op, new TestResult(x1 + x2, y1 + y2));
        }
    }

    private void checkOperation(ComplexOperation op, TestResult golden) {
        ComplexCalculator.Result result = getCalculator().calculate(op);
        String msg = String.format("Operation: %s, golden: %s", op, golden);
        assertEquals(result.getReal(), golden.real, PRECISION, msg);
        assertEquals(result.getImage(), golden.image, PRECISION, msg);
    }

    private record TestResult(double real, double image) {
    }
}
