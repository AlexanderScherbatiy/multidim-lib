package org.multidim.complex;

public sealed interface ComplexOperation {

    record ComplexValue(Complex complex) implements ComplexOperation {
    }

    record Sum(ComplexOperation complex1, ComplexOperation complex2) implements ComplexOperation {
    }

    record Negate(ComplexOperation operation) implements ComplexOperation {
    }

    static ComplexOperation from(Complex complex) {
        return new ComplexValue(complex);
    }

    static ComplexOperation add(ComplexOperation complex1, ComplexOperation complex2) {
        return new Sum(complex1, complex2);
    }

    default ComplexOperation add(ComplexOperation operation) {
        return new Sum(this, operation);
    }

    default ComplexOperation negate() {
        return new Negate(this);
    }

}
