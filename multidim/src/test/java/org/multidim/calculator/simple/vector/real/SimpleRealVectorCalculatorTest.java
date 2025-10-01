package org.multidim.calculator.simple.vector.real;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SimpleRealVectorCalculatorTest extends SimpleRealVectorCalculatorBaseTest {

    @BeforeEach
    void setUp() {
        setCalculator(new SimpleRealVectorCalculator());
    }

    @AfterEach
    void tearDown() {
    }
}
