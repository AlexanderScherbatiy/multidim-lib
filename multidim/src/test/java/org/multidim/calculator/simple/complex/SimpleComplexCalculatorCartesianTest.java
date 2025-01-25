package org.multidim.calculator.simple.complex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class SimpleComplexCalculatorCartesianTest extends SimpleComplexCalculatorBaseTest {

    @BeforeEach
    void setUp() {
        setCalculator(new SimpleComplexCalculator(SimpleComplexCalculator.Strategy.CARTESIAN));
    }

    @AfterEach
    void tearDown() {
    }
}