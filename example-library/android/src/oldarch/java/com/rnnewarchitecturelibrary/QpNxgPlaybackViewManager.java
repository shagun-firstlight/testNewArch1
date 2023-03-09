package com.rnnewarchitecturelibrary;

import android.util.Log;
import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.rnnewarchitecturelibrary.PlaybackView;
import com.rnnewarchitecturelibrary.QPNxgPlaybackViewManagerImpl;
import javax.annotation.Nullable;


public class QpNxgPlaybackViewManager extends SimpleViewManager<PlaybackView> {

    private static final String COMPONENT_NAME = "QpNxgPlaybackView";
    ReactApplicationContext mCallerContext;

    public QpNxgPlaybackViewManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    @NonNull
    @Override
    public String getName() {
        return COMPONENT_NAME;
    }

    @NonNull
    @Override
    public PlaybackView createViewInstance(ThemedReactContext reactContext) {
        Log.i(COMPONENT_NAME, "created view");
        return QPNxgPlaybackViewManagerImpl.createViewInstance(reactContext);
    }

    @ReactProp(name = "backgroundColour")
    public void setBackgroundColour(PlaybackView playbackView, @Nullable String colorString) {
        Log.i(COMPONENT_NAME, "setBackgroundColor: " + colorString);
        QPNxgPlaybackViewManagerImpl.setBackgroundColour(playbackView, colorString);
    }

    // @ReactProp(name = "zoomed")
    // public void setZoomed(PlaybackView playbackView, boolean zoomed) {
    //     Log.i(COMPONENT_NAME, "setIsZoomed: " + zoomed);
    //     QPNxgPlaybackViewManagerImpl.setZoomed(playbackView, zoomed);
    // }

    @ReactProp(name = "playerID")
    public void setPlayerID(PlaybackView playbackView, int playerID) {
        Log.i(COMPONENT_NAME, "setPlayerID: " + playerID);
        QPNxgPlaybackViewManagerImpl.setPlayerID(playbackView,playerID);
    }

    public static boolean getIsZoomed() {
        return QPNxgPlaybackViewManagerImpl.getIsZoomed();
    }

    public static void setIsZoomed(boolean zoomed) {
        QPNxgPlaybackViewManagerImpl.setIsZoomed(zoomed);
    }
}
