package org.multidim.complex;

import java.util.Map;

public interface ComplexCalculator {

    interface Result {

        double getReal();

        double getImage();
    }

    Result calculate(ComplexOperation operation);

    Result calculate(ComplexOperation operation, ComplexOptimizer optimizer);

    Result calculate(ComplexOperation operation, ComplexOptimizer optimizer, Map<String, ComplexOperation> variables);
}
