package test.bwie.com.a7niuvideo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.pili.pldroid.player.PLMediaPlayer;
import com.pili.pldroid.player.widget.PLVideoView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.PLVideoView)
    PLVideoView mVideoView;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    @Bind(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv.setVisibility(v.GONE);
                initdata();
                Toast.makeText(MainActivity.this, "播放啦。。。。", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initdata() {
        mVideoView.setVisibility(View.VISIBLE);
        MediaController mediaController = new MediaController(this);
        mVideoView.setMediaController(mediaController);
        mVideoView.setVideoPath("http://flv3.quanmin.tv/live/3766_1980174.flv");
//        ImageView imageView = new ImageView(this);
//        mVideoView.setCoverView(iv);
//        mVideoView.setBufferingIndicator(imageView);
        mVideoView.setDisplayAspectRatio(PLVideoView.ASPECT_RATIO_PAVED_PARENT);
        mVideoView.setOnPreparedListener(new PLMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(PLMediaPlayer plMediaPlayer) {
                Toast.makeText(MainActivity.this, "准备。。。。", Toast.LENGTH_SHORT).show();
                mVideoView.start();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        mVideoView.stopPlayback();
        return super.onKeyDown(keyCode, event);
    }
}
