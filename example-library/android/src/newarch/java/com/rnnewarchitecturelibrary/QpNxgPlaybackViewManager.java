package com.rnnewarchitecturelibrary;

import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.QpNxgPlaybackViewManagerInterface;
import com.facebook.react.viewmanagers.QpNxgPlaybackViewManagerDelegate;

    
@ReactModule(name = QPNxgPlaybackViewManagerImpl.NAME)
public class QpNxgPlaybackViewManager extends SimpleViewManager<PlaybackView>
        implements QpNxgPlaybackViewManagerInterface<PlaybackView> {

    private final ViewManagerDelegate<PlaybackView> mDelegate;

    public QpNxgPlaybackViewManager(ReactApplicationContext context) {
        mDelegate = new QpNxgPlaybackViewManagerDelegate<>(this);
    }

    @Nullable
    @Override
    protected ViewManagerDelegate<PlaybackView> getDelegate() {
        return mDelegate;
    }

    @NonNull
    @Override
    public String getName() {
        return QPNxgPlaybackViewManagerImpl.NAME;
    }

    @NonNull
    @Override
    protected PlaybackView createViewInstance(@NonNull ThemedReactContext context) {
        return QPNxgPlaybackViewManagerImpl.createViewInstance(context);
    }

    @Override
    @ReactProp(name = "backgroundColour")
    public void setBackgroundColour(PlaybackView view, @Nullable String color) {
        QPNxgPlaybackViewManagerImpl.setBackgroundColour(view, color);
    }

    // @Override
    // @ReactProp(name = "zoomed")
    // public void setZoomed(PlaybackView view, boolean zoomed) {
    //     QPNxgPlaybackViewManagerImpl.setZoomed(view, zoomed);
    // }

    @Override
    @ReactProp(name = "playerID")
    public void setPlayerID(PlaybackView view, int playerID) {
        QPNxgPlaybackViewManagerImpl.setPlayerID(view, playerID);
    }

    public static boolean getIsZoomed() {
        return QPNxgPlaybackViewManagerImpl.getIsZoomed();
    }

    public static void setIsZoomed(boolean zoomed) {
        QPNxgPlaybackViewManagerImpl.setIsZoomed(zoomed);
    }

}