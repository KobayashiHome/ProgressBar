package com.skylinelin.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

/**
 * @author skylinelin
 * @date 2018/2/5
 *
 * */
public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Pro();
    }

    private void Pro(){
        mProgressBar = findViewById(R.id.progress_bar);

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

                    if (mProgressBar.getProgress() == 80){

                        break;
                    }
                }



            }
        }).start();
    }
}
