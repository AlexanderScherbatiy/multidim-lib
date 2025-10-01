package org.multidim.calculator.simple.vector.real;

import org.junit.jupiter.api.Test;
import org.multidim.vector.real.RealVector;
import org.multidim.vector.real.RealVectorCalculator;
import org.multidim.vector.real.RealVectorOperation;

import static org.multidim.calculator.simple.TestUtils.PRECISION;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class SimpleRealVectorCalculatorBaseTest {

    private RealVectorCalculator calculator;

    public RealVectorCalculator getCalculator() {
        return calculator;
    }

    void setCalculator(RealVectorCalculator calculator) {
        this.calculator = calculator;
    }

    @Test
    void calculateArraySum() {

        RealVector v1 = new RealVector.Array(new double[] {1.1, 2.2});
        RealVector v2 = new RealVector.Array(new double[] {3.3, 4.4});

        RealVectorOperation op1 = RealVectorOperation.from(v1);
        RealVectorOperation op2 = RealVectorOperation.from(v2);
        RealVectorOperation sum = RealVectorOperation.add(op1, op2);

        RealVectorCalculator calculator = getCalculator();

        RealVectorCalculator.Result result = calculator.calculate(sum);

        assertEquals(result.getDimension(), 2);
        assertEquals(result.getElem(0), 4.4, PRECISION);
        assertEquals(result.getElem(1), 6.6, PRECISION);
    }
}
