package com.rnnewarchitecturelibrary;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class AdvanceCalculatorModule extends ReactContextBaseJavaModule {

    AdvanceCalculatorModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return AdvanceCalculatorModuleImpl.NAME;
    }

    @ReactMethod
    public void div(int a, int b, Promise promise) {
        AdvanceCalculatorModuleImpl.div(a, b, promise);
    }
}