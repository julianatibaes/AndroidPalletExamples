package com.tibaes.androidpaletteexample;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class ImagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        // ------- Begin Image Button ---------------

        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ImagesActivity.this, "Be our guest", Toast.LENGTH_LONG).show();
            }
        });

        // ------- End Image Button---------------

        // ------- Begin Video View ---------------
        final VideoView videoView = (VideoView) findViewById(R.id.videoView);

        //videoView.setVideoPath("http://www.ebookfrenzy.com/android_book/movie.mp4");
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.beauty_and_the_beast_teaser_trailer));

        // create an object of media controller
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);

        videoView.start();

        // ------- End Video View ---------------
    }
}
