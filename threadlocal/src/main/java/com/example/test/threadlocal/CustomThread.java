package com.example.test.threadlocal;

import android.util.Log;

public class CustomThread extends Thread {

    private ThreadLocal<RefObj> threadLocal;
    private RefObj refObj;
    private boolean useTl;
    String TAG = "CustomThread";
    public  CustomThread(RefObj obj, boolean useTl){

        this.useTl = useTl;
        if(useTl) {
            threadLocal = new ThreadLocal();
            threadLocal.set(obj);
        }else{
            this.refObj =obj;
        }

    }
    @Override
    public void run() {
        super.run();
        if(this.useTl){

            threadLocal.get().flag ++;
            Log.i(TAG, "run: threadLocal.get().flag:"+threadLocal.get().flag);

        }else{
            Log.i(TAG, "run: refObj.flag:"+refObj.flag);

        }

    }
}
