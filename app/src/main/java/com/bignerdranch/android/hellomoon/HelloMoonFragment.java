package com.bignerdranch.android.hellomoon;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

/**
 * Created by treetender on 1/19/15.
 */
public class HelloMoonFragment extends Fragment {

    private VideoView mVideoView;
    private Button mPlayButton;
    private Button mStopButton;
    private Button mPauseButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);

        mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
        mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
        mPauseButton = (Button)v.findViewById(R.id.hellomoon_pauseButton);
        mVideoView = (VideoView)v.findViewById(R.id.hellomoon_videoView);

        Uri videoUri = Uri.parse("android.resource://"
                     + "com.bignerdranch.android.hellomoon/raw/apollo_17_stroll");

        mVideoView.setVideoURI(videoUri);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoView.start();
            }
        });

        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoView.stopPlayback();
            }
        });

        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mVideoView.isPlaying())
                    mVideoView.pause();
                else
                    mVideoView.resume();
            }
        });

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mVideoView.stopPlayback();
    }
}
