package iris_view.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import iris_view.com.msgqueue.HandlerTest;
import iris_view.com.msgqueue.MessageTest;
import iris_view.com.msgqueue.R;
import iris_view.com.msgqueue.ReceiveThread;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ReceiveThread().start();
        startActivity(new Intent(this,WorkActivity.class));

    }
}
