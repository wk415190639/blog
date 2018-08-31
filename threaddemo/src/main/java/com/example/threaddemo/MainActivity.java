package com.example.threaddemo;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements TAG {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, "run: MainActivity");

        createThreadWay1();
        createThreadWay2();
        createThreadWay3();
        createThreadWay4();


    }


    void createThreadWay1() {
        new ThreadSub().start();
    }

    void createThreadWay2() {

        new Thread(new RunnableImpl("createThreadWay2")).start();
    }


    void createThreadWay3() {

        new AsyncTask<Integer, String, Integer>() {

            @Override
            protected Integer doInBackground(Integer... integers) {
                Log.e(TAG, "run: AsyncTask ");

                return 100;
            }
        }.execute(100);
    }

    void createThreadWay4() {

        BlockingDeque<Runnable> blockingQueue = new LinkedBlockingDeque<>(10);


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(13, 15, 1, TimeUnit.DAYS, blockingQueue);

        for (int i = 0; i < 1; i++) {

            try {
                Thread.sleep(1);
            } catch (Exception e) {

            }
            threadPoolExecutor.execute(new RunnableImpl("ThreadPoolExecutor_" + i));
        }


    }


}