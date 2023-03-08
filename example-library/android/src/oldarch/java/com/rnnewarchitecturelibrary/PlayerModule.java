package com.rnnewarchitecturelibrary;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.*;

public class PlayerModule extends ReactContextBaseJavaModule {

    private ReactApplicationContext reactContext;
    private int PlayerID;


    PlayerModule(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @Override
    public String getName() {
        return PlayerModuleImpl.NAME;
    }

    @ReactMethod
    public void initWithConfig(ReadableMap map, Promise promise) {
        PlayerID = PlayerModuleImpl.initWithConfig(map, reactContext, promise);
    }

    @ReactMethod
    public void getNativeID(Promise promise){
        promise.resolve(PlayerID);
    }
  
    @ReactMethod
    public void load(Promise promise){
        PlayerModuleImpl.load(PlayerID, promise);
    }
  
    @ReactMethod
    public void play(Promise promise){
        PlayerModuleImpl.play(PlayerID, promise);
    }
  
    @ReactMethod
    public void pause(Promise promise){
        PlayerModuleImpl.pause(PlayerID, promise);
    }
  
    @ReactMethod
    public void stop(Promise promise){
        PlayerModuleImpl.stop(PlayerID, promise);
    }
  
    @ReactMethod
    public void dispose(Promise promise){
        PlayerModuleImpl.dispose(PlayerID, promise);
    }
  
    @ReactMethod
    public void seek(double seekPosition, Promise promise){
        PlayerModuleImpl.seek(seekPosition, PlayerID, promise);
    }
}