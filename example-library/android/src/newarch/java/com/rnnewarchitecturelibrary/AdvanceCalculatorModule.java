package com.rnnewarchitecturelibrary;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;
import com.facebook.react.bridge.*;
import android.util.Log;

public class AdvanceCalculatorModule extends NativeAdvanceCalculatorSpec {

    AdvanceCalculatorModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    @NonNull
    public String getName() {
        return AdvanceCalculatorModuleImpl.NAME;
    }

    @Override
    public void div(double a, double b, Promise promise) {
        AdvanceCalculatorModuleImpl.div(a, b, promise);
    }
}