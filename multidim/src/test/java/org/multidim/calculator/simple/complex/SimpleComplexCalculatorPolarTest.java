package org.multidim.calculator.simple.complex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.multidim.complex.Complex;
import org.multidim.complex.ComplexCalculator;
import org.multidim.complex.ComplexOperation;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleComplexCalculatorPolarTest {

    private static final double PRECISION = 0.01;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateNegate() {
        ComplexOperation c = ComplexOperation.from(new Complex.Cartesian(-1, 2));
        ComplexOperation negate = c.negate();

        ComplexCalculator calculator = new SimpleComplexCalculator(SimpleComplexCalculator.Strategy.POLAR);
        ComplexCalculator.Result result = calculator.calculate(negate);

        assertEquals(result.getReal(), 1.0, PRECISION);
        assertEquals(result.getImage(), -2.0, PRECISION);
    }

    @Test
    void calculateSum() {
        ComplexOperation c1 = ComplexOperation.from(new Complex.Cartesian(1, 2));
        ComplexOperation c2 = ComplexOperation.from(new Complex.Cartesian(3, -4));
        ComplexOperation sum = c1.add(c2);

        ComplexCalculator calculator = new SimpleComplexCalculator(SimpleComplexCalculator.Strategy.POLAR);
        ComplexCalculator.Result result = calculator.calculate(sum);

        assertEquals(result.getReal(), 4.0, PRECISION);
        assertEquals(result.getImage(), -2.0, PRECISION);
    }
}