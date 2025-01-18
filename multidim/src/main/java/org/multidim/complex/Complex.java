package org.multidim.complex;

public sealed interface Complex {

    record Cartesian(double real, double imaginary) implements Complex {
    }

    record Polar(double radius, double angle) implements Complex {
    }
}
