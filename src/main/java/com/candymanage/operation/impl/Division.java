package com.candymanage.operation.impl;

import com.candymanage.operation.Operation;

public class Division implements Operation {
    @Override
    public int apply(int a, int b) {
        return a / b;
    }
}
