package com.rnnewarchitecturelibrary;

import com.facebook.react.bridge.Promise;


public class AdvanceCalculatorModuleImpl {

    public static final String NAME = "AdvanceCalculator";

    public static void div(double a, double b, Promise promise) {
        promise.resolve(a / b);
    }

}