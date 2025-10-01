package org.multidim.vector.real;

public interface RealVectorCalculator {

    interface Result {

        int getDimension();

        double getElem(int index);
    }

    Result calculate(RealVectorOperation operation);
}
