package org.multidim.calculator.simple.complex;

import org.multidim.complex.Complex;

public class ComplexMath {

    static double radius(double real, double image) {
        return Math.sqrt(real * real + image * image);
    }

    static double angle(double real, double image) {
        return Math.atan2(image, real);
    }

    static double real(double radius, double angle) {
        return radius * Math.cos(angle);
    }

    static double image(double radius, double angle) {
        return radius * Math.sin(angle);
    }

    static double real(Complex.Polar polar) {
        return polar.radius() * Math.cos(polar.angle());
    }

    static double image(Complex.Polar polar) {
        return polar.radius() * Math.sin(polar.angle());
    }

    static double radius(Complex.Cartesian c) {
        return radius(c.real(), c.imaginary());
    }

    static double angle(Complex.Cartesian c) {
        return angle(c.real(), c.imaginary());
    }
}
