package com.skylinelin.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author skylinelin
 * @date 2018/2/5
 *
 * */
public class MainActivity extends AppCompatActivity {


    private static final String TAG ="MainActivity" ;
    private ProgressBar mProgressBar;
    private SeekBar mSeekBar;
    private TextView mTextView,mTextView2;
    private RatingBar mRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pro();
    }

    private void Pro(){
        mProgressBar = findViewById(R.id.progress_bar);
        mSeekBar = findViewById(R.id.seek_bar);
        mTextView = findViewById(R.id.text_view);
        mRatingBar = findViewById(R.id.rating_bar);
        mTextView2 = findViewById(R.id.text_view2);
        //mProgressBar事件
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    mProgressBar.post(new Runnable() {
                        @Override
                        public void run() {
                            int newProgressBar = mProgressBar.getProgress()+5;
                            mProgressBar.setProgress(newProgressBar);
                        }
                    });

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (mProgressBar.getProgress() == 100){
                        mProgressBar.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this,"下载完成:"+mProgressBar.getProgress()+"%",Toast.LENGTH_SHORT).show();
                            }
                        });

                        break;
                    }
                }



            }
        }).start();

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(TAG,"进度"+progress+"内容"+fromUser);
                mTextView.setText(progress+" ");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mTextView2.setText(rating+" ");
            }
        });
    }
}
