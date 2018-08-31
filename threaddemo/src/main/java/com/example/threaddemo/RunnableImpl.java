package com.example.threaddemo;

import android.util.Log;

public class RunnableImpl implements Runnable,TAG {

    String text ="";

    private RunnableImpl() {
    }

    public RunnableImpl(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        Log.e(TAG, "run: RunableImpl "+text );
        try {
            Thread.sleep(5000);

        }catch (Exception e){

        }

    }
}
