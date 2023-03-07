package com.rnnewarchitecturelibrary;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import java.util.Map;
import java.util.HashMap;

public class CalculatorModuleImpl {

    public static final String NAME = "Calculator";

    public static void add(double a, double b, Promise promise) {
        promise.resolve(a + b);
    }
    public static void sub(double a, double b, Promise promise) {
        promise.resolve(a - b);
    }
    public static void mul(double a, double b, Promise promise) {
        promise.resolve(a * b);
    }

}