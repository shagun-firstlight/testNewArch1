package com.rnnewarchitecturelibrary;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;
import com.facebook.react.bridge.*;

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