package org.multidim.complex;

import java.util.Map;

public interface ComplexOptimizer {
    ComplexOperation optimize(ComplexOperation operation, Map<String, ComplexOperation> variables);
}
