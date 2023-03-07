package com.rnnewarchitecturelibrary;

import com.facebook.react.bridge.Promise;
import java.util.Objects;

import com.facebook.react.bridge.*;
import com.quickplay.vstb7.player.Player;
import com.quickplay.vstb7.player.PlayerBuilder;
import com.quickplay.vstb7.player.model.DRMScheme;
import com.quickplay.vstb7.player.model.MediaType;

import android.util.Log;


public class PlayerModuleImpl {

    public static final String NAME = "Player";

    public static void createPlayer(ReadableMap readableMap, ReactApplicationContext context ,Promise promise) {
        Log.i("shagun", ""+readableMap);

        PlayerBuilder playerBuilder = new PlayerBuilder();
        playerBuilder.mediaURL(Objects.requireNonNull(readableMap.getString("mediaURL")));
        playerBuilder.mediaType(MediaType.valueOf(readableMap.getString("mediaType")));
        playerBuilder.drmLicenseURL(readableMap.getString("drmLicenseURL"));
        playerBuilder.drmScheme(DRMScheme.valueOf(readableMap.getString("drmType")));
        Player player = playerBuilder.build(context.getApplicationContext());
        player.play();
        promise.resolve(1);
    }
}