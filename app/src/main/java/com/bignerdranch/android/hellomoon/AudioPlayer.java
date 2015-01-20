package com.bignerdranch.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;

/**
 * Created by treetender on 1/19/15.
 */
public class AudioPlayer {

    private MediaPlayer mPlayer;

    public void stop() {
        if(mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c, SurfaceHolder s) {
        stop();

        mPlayer = MediaPlayer.create(c, R.raw.apollo_17_stroll);
        mPlayer.setDisplay(s);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        mPlayer.start();
    }

    public void pause() {
        if(mPlayer != null) {
            if(mPlayer.isPlaying())
                mPlayer.pause();
            else
                mPlayer.start();
        }
    }
}
