package com.rnnewarchitecturelibrary;

import com.facebook.react.bridge.Promise;
import java.util.Objects;

import com.facebook.react.bridge.*;
import com.quickplay.vstb7.player.Player;
import com.quickplay.vstb7.player.PlayerBuilder;
import com.quickplay.vstb7.player.model.DRMScheme;
import com.quickplay.vstb7.player.model.MediaType;
import androidx.collection.ArrayMap;


public class PlayerModuleImpl {
    public static final String NAME = "Player";
    private static ArrayMap<Integer, Player> playerList = new ArrayMap();

    public static int initWithConfig(ReadableMap readableMap, ReactApplicationContext context ,Promise promise){
        PlayerBuilder playerBuilder = new PlayerBuilder();
        playerBuilder.mediaURL(Objects.requireNonNull(readableMap.getString("mediaURL")));
        playerBuilder.mediaType(MediaType.valueOf(readableMap.getString("mediaType")));
        playerBuilder.drmLicenseURL(readableMap.getString("drmLicenseURL"));
        playerBuilder.drmScheme(DRMScheme.valueOf(readableMap.getString("drmType")));
        Player player = playerBuilder.build(context.getApplicationContext());
        int nextAvailableKey = -1 ;
        if (playerList.size() == 0){
            nextAvailableKey = 0;
        }else{
            nextAvailableKey = playerList.keyAt(playerList.size() - 1) + 1 ;
        }
        playerList.put(nextAvailableKey, player);
        promise.resolve(nextAvailableKey);
        return nextAvailableKey;
    }

    public static void load(int PlayerID, Promise promise){
        Player player = getPlayerByID(PlayerID);
        if(player!=null){
            player.load();
        }
    }

    public static void play(int PlayerID, Promise promise){
        Player player = getPlayerByID(PlayerID);
        if(player!=null){
            player.play();
        }
    }

    public static void pause(int PlayerID, Promise promise){
        Player player = getPlayerByID(PlayerID);
        if(player!=null){
            player.pause();
        }
    }

    public static void stop(int PlayerID, Promise promise){
        Player player = getPlayerByID(PlayerID);
        if(player!=null){
            player.stop();
        }
    }

    public static void dispose(int PlayerID, Promise promise){
        Player player = getPlayerByID(PlayerID);
        if(player!=null){
            playerList.remove(PlayerID);
        }
    }

    public static void seek(double seekPosition, int PlayerID, Promise promise){
        Player player = getPlayerByID(PlayerID);
        if(player!=null){
            player.seek((long)seekPosition);
        }
    }


    public static Player getPlayerByID(int PlayerID){
        if (playerList.size() > 0){
            return playerList.get(PlayerID);
        }
        return null;
    }
}