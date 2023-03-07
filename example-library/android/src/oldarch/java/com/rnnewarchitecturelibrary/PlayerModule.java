package com.rnnewarchitecturelibrary;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.*;

public class PlayerModule extends ReactContextBaseJavaModule {

    private ReactApplicationContext reactContext;
    PlayerModule(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @Override
    public String getName() {
        return PlayerModuleImpl.NAME;
    }

    @ReactMethod
    public void createPlayer(ReadableMap map, Promise promise) {
        PlayerModuleImpl.createPlayer(map, reactContext, promise);
    }
}