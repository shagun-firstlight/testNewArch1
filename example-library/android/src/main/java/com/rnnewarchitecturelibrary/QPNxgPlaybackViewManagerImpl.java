package com.rnnewarchitecturelibrary;


import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.ThemedReactContext;
import com.quickplay.vstb7.error.Error;
import com.quickplay.vstb7.player.Player;
import com.quickplay.vstb7.player.PlayerExtensionsKt;
import com.quickplay.vstb7.player.event.Action;
import com.quickplay.vstb7.player.event.StreamTimelineEvent;
import com.quickplay.vstb7.player.event.StreamTimelineMetadata;
import com.quickplay.vstb7.player.model.BufferingState;
import com.quickplay.vstb7.player.model.PlaybackState;
import com.quickplay.vstb7.player.model.ResizeMode;
import com.quickplay.vstb7.player.model.SeekingState;
import com.quickplay.vstb7.player.model.TrackVariantInfo;
import com.quickplay.vstb7.player.model.VideoSize;

import org.jetbrains.annotations.NotNull;

public class QPNxgPlaybackViewManagerImpl {

    public static final String NAME = "QpNxgPlaybackView";

    private static final String COMPONENT_NAME = "QpNxgPlaybackView";
    private static Player mPlayer = null;
    private static PlaybackView mPlaybackView = null;
    private static int mPlayerID = -1;
    private static boolean isZoomed = true;

    public static PlaybackView createViewInstance(ThemedReactContext context) {
        return new PlaybackView(context);
    }

    public static void setBackgroundColour(PlaybackView view, String color) {
        view.setBackgroundColor(Color.parseColor(color));
    }

    public static void setZoomed(PlaybackView view, boolean zoomed) {
        setIsZoomed(zoomed);
    }

    public static void setIsZoomed(boolean zoomed) {
                isZoomed = zoomed;
    }

    public static void setPlayerID(PlaybackView playbackView, int playerID) {
        Log.i(COMPONENT_NAME, "setPlayerID: " + playerID);
        mPlayerID = playerID;
        mPlaybackView = playbackView;
        if (playerID < 0) {

            return;
        }
        mPlayer = PlayerModuleImpl.getPlayerByID(mPlayerID);
        if (mPlayer == null) {
            Log.i(COMPONENT_NAME, "no player for id $playerID");
            return;
        } else {
            if (mPlayer.getPlayerView() != null) {
                Log.i(COMPONENT_NAME, "attaching to player " + mPlayerID);
                attachToPlayer(mPlayer, mPlaybackView);
            } else {
                mPlayer.addListener(mPlayerListener);
            }
        }
    }

    private static final Player.Listener mPlayerListener = new Player.Listener() {

        @Override
        public void onRateChanged(float v, float v1) {

        }

        @Override
        public void onPlaybackRecoveryFlowStarted(@NonNull Error error) {

        }

        @Override
        public void onPlaybackRecoveryFlowEnded() {

        }

        @Override
        public void onAudioVolumeChanged(float v) {

        }

        @Override
        public void onEventReceived(@NotNull StreamTimelineEvent streamTimelineEvent, @NotNull Action action, @org.jetbrains.annotations.Nullable StreamTimelineMetadata streamTimelineMetadata) {
        }
        @Override
        public void onStreamEnded() {

        }

        @Override
        public void onPlayerViewAvailable(@NotNull FrameLayout frameLayout) {
            if(null == mPlayer || null == mPlaybackView) {
                return;
            }
            Log.i(COMPONENT_NAME, "attaching to player onViewAvailable " + mPlayerID);
            attachToPlayer(mPlayer, mPlaybackView);
            mPlayer.removeListener(mPlayerListener);
        }

        @Override
        public void onVideoSizeChanged(@NotNull VideoSize videoSize) {
        }

        @Override
        public void onTrackAvailabilityChanged() {
        }

        @Override
        public void onStateChange(@NotNull PlaybackState playbackState,
                                  @NotNull BufferingState bufferingState, @NotNull SeekingState seekingState) {
        }

        @Override
        public void onProgressUpdate(long l, long l1) {
        }

        @Override
        public void onError(@NotNull Error error) {
        }

        @Override
        public void onActiveTrackVariantChanged(
                @NotNull TrackVariantInfo trackVariantInfo) {
        }
    };

    static void attachToPlayer(Player player, PlaybackView playbackView) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                Gravity.CENTER
        );
        layoutParams.gravity = Gravity.CENTER;
        if (getIsZoomed()) {
            player.setResizeMode(ResizeMode.ZOOM);
        } else {
            player.setResizeMode(ResizeMode.FIT);
        }

        PlayerExtensionsKt.attachRendererView(player, playbackView, layoutParams);
    }

    public static boolean getIsZoomed() {
        return isZoomed;
    }

}