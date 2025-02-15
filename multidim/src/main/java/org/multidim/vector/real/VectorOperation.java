package org.multidim.vector.real;

public sealed interface VectorOperation {

    record VectorValue(Vector v) implements VectorOperation {
    }

    record Sum(VectorOperation vector1, VectorOperation vector2) implements VectorOperation {
    }

    static VectorOperation from(Vector vector) {
        return new VectorValue(vector);
    }

    static VectorOperation add(VectorOperation vector1, VectorOperation vector2) {
        return new Sum(vector1, vector2);
    }
}
