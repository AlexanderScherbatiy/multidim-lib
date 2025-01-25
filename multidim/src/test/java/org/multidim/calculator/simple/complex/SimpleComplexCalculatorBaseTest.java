package org.multidim.calculator.simple.complex;

import org.junit.jupiter.api.Test;
import org.multidim.complex.Complex;
import org.multidim.complex.ComplexCalculator;
import org.multidim.complex.ComplexOperation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class SimpleComplexCalculatorBaseTest {

    private static final double PRECISION = 0.01;

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
}
