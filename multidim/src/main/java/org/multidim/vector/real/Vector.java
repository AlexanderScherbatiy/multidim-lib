package org.multidim.vector.real;

public sealed interface Vector {

    record Array(double values) {
    }

    record Unit(int index, double value, int dimension) implements Vector {
    }
}
