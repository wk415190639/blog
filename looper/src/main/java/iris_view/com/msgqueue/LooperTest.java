package iris_view.com.msgqueue;

import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.LinkedBlockingDeque;

public class LooperTest {


    public LinkedBlockingDeque<MessageTest> queue;
    public Thread thread;
    private static LooperTest looperTest;

    public LooperTest() {
        queue = new LinkedBlockingDeque<MessageTest>();
        thread = Thread.currentThread();
    }

    public static void prepareMainLooper() {

        if (looperTest == null)
            looperTest = new LooperTest();
    }

    public static
    @Nullable
    LooperTest myLooper() {
        return looperTest;
    }

    public void loop() {

        for (; ; ) {
            try {
                Log.i("QueueTest", Thread.currentThread().getName() + " : start blocking....................");
                MessageTest msg = (MessageTest) queue.take();
                msg.target.handleMessage(msg);
                Log.i("QueueTest", Thread.currentThread().getName() + " : read msg : " + msg.msg + "\n\n ");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
