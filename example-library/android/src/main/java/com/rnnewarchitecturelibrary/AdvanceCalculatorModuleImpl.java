package com.rnnewarchitecturelibrary;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import java.util.Map;
import java.util.HashMap;

public class AdvanceCalculatorModuleImpl {

    public static final String NAME = "AdvanceCalculator";

    public static void div(double a, double b, Promise promise) {
        promise.resolve(a / b);
    }

}