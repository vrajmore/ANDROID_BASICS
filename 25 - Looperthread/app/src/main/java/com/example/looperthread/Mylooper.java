package com.example.looperthread;


import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

public class Mylooper extends Thread{
    private static final String TAG = "Mylooper";

    Handler handler;

    @Override
    public void run() {
        super.run();

        Looper.prepare();
        handler = new Handler();
        Looper.loop();
        Log.d(TAG, "Thread looper runnning "+Thread.currentThread());
    }





    /* used for runing code on thread once the thread is terminated thread can not be started again without creating a new object of thread */
//    @Override
//    public void run() {
//        super.run();
//        Log.d(TAG, "run---> " + Thread.currentThread());
//        for (int i = 1; i < 11; i++) {
//            Log.d(TAG, "run: time in seconds" + i);
//            SystemClock.sleep(1000);
//        }
//    }
}
