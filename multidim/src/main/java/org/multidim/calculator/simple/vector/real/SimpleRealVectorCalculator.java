package org.multidim.calculator.simple.vector.real;

import org.multidim.vector.real.RealVector;
import org.multidim.vector.real.RealVectorCalculator;
import org.multidim.vector.real.RealVectorOperation;

public class SimpleRealVectorCalculator implements RealVectorCalculator {

    public Result calculate(RealVectorOperation operation) {
        double[] res = calc(operation);
        return new SimpleResult(res);
    }

    double[] calc(RealVectorOperation operation) {
        switch (operation) {
            case RealVectorOperation.VectorValue value -> {
                switch (value.v()) {
                    case RealVector.Array array -> {
                        return array.values();
                    }
                    case RealVector.Unit unit -> {
                        return ArrayOperations.unit(unit.index(), unit.value(), unit.dimension());
                    }
                }
            }
            case RealVectorOperation.Sum s -> {
                double[] s1 = calc(s.vector1());
                double[] s2 = calc(s.vector2());
                return ArrayOperations.sum(s1, s2);
            }
        }

    }
}

class SimpleResult implements RealVectorCalculator.Result {

    private final double elements[];

    SimpleResult(int dimension) {
        this(new double[dimension]);
    }

    SimpleResult(double[] elements) {
        this.elements = elements;
    }

    @Override
    public int getDimension() {
        return this.elements.length;
    }

    @Override
    public double getElem(int index) {
        return this.elements[index];
    }
}

class ArrayOperations {

    static double[] unit(int index, double value, int dimension) {
        double[] res = new double[dimension];
        res[index] = value;
        return res;
    }

    static double[] sum(double[] v1, double[] v2) {
        int len = v1.length;
        double[] res = new double[len];
        for (int i = 0; i < len; i++) {
            res[i] = v1[i] + v2[i];
        }
        return res;
    }
}
