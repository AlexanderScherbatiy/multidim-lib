package org.multidim.vector.real;

public sealed interface RealVector {

    record Array(double[] values) implements RealVector {
    }

    record Unit(int index, double value, int dimension) implements RealVector {
    }
}
