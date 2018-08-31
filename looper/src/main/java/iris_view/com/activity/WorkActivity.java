package iris_view.com.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import iris_view.com.msgqueue.HandlerTest;
import iris_view.com.msgqueue.MessageTest;
import iris_view.com.msgqueue.R;
public class WorkActivity extends Activity  implements View.OnClickListener {

    HandlerTest handlerTest = new HandlerTest() {
        @Override
        public void handleMessage(MessageTest msg) {
            super.handleMessage(msg);
            Log.i("QueueTest", Thread.currentThread().getName() + " : handleMessage : " + msg.msg);
        }
    };
    int i = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.currentThread().setName("workThread");
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        MessageTest msg = new MessageTest();
        msg.msg = i++;
        Log.i("QueueTest", Thread.currentThread().getName() + " : sendMessage : " + msg.msg);
        handlerTest.sendMessage(msg);
    }
}
