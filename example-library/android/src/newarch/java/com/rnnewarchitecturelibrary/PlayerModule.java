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
    private int PlayerID;

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
    public void initWithConfig(ReadableMap map, Promise promise) {
        PlayerID = PlayerModuleImpl.initWithConfig(map, reactContext, promise);
    }
    @Override
    public void getNativeID(Promise promise){
        promise.resolve(PlayerID);
    }
    @Override
    public void load(Promise promise){
        PlayerModuleImpl.load(PlayerID, promise);
    }
    @Override
    public void play(Promise promise){
        PlayerModuleImpl.play(PlayerID, promise);
    }
    @Override
    public void pause(Promise promise){
        PlayerModuleImpl.pause(PlayerID, promise);
    }
    @Override
    public void stop(Promise promise){
        PlayerModuleImpl.stop(PlayerID, promise);
    }
    @Override
    public void dispose(Promise promise){
        PlayerModuleImpl.dispose(PlayerID, promise);
    }
    @Override
    public void seek(double seekPosition, Promise promise){
        PlayerModuleImpl.seek(seekPosition, PlayerID, promise);
    }
}