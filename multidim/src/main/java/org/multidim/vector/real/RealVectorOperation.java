package org.multidim.vector.real;

public sealed interface RealVectorOperation {

    record VectorValue(RealVector v) implements RealVectorOperation {
    }

    record Sum(RealVectorOperation vector1, RealVectorOperation vector2) implements RealVectorOperation {
    }

    static RealVectorOperation from(RealVector vector) {
        return new VectorValue(vector);
    }

    static RealVectorOperation add(RealVectorOperation vector1, RealVectorOperation vector2) {
        return new Sum(vector1, vector2);
    }
}
