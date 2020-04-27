package com.candymanage.operation.impl;

import com.candymanage.operation.Operation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OperationFactory {

    static Map<String, Operation> operationMap = new HashMap<>();

    static {
        operationMap.put("add", new AddOperation());
        operationMap.put("divide", new Division());
        operationMap.put("multiply", new Multiplication());
        operationMap.put("subtract", new Subtraction());
        operationMap.put("modulo", new Modulo());

    }

    public static Optional<Operation> getOperation(String operation) {

        return Optional.ofNullable(operationMap.get(operation));
    }

}
