package com.rnnewarchitecturelibrary;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.*;

public class CalculatorModule extends ReactContextBaseJavaModule {

    CalculatorModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return CalculatorModuleImpl.NAME;
    }

    @ReactMethod
    public void add(int a, int b, Promise promise) {
        CalculatorModuleImpl.add(a, b, promise);
    }

    @ReactMethod
    public void sub(int a, int b, Promise promise) {
        CalculatorModuleImpl.sub(a, b, promise);
    }

    @ReactMethod
    public void mul(ReadableMap map, Promise promise) {
        int a = map.getInt("a");
        int b = map.getInt("b");
        CalculatorModuleImpl.mul(a, b, promise);
    }
}