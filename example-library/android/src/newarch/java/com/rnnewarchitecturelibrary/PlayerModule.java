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

public class PlayerModule extends NativePlayerSpec {
    private ReactApplicationContext reactContext;
    PlayerModule(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @Override
    @NonNull
    public String getName() {
        return PlayerModuleImpl.NAME;
    }

    @Override
    public void createPlayer(ReadableMap map, Promise promise) {
        PlayerModuleImpl.createPlayer(map, reactContext, promise);
    }
}