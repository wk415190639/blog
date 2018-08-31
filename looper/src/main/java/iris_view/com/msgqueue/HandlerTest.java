package iris_view.com.msgqueue;

import java.util.concurrent.LinkedBlockingDeque;

public class HandlerTest {
    public LinkedBlockingDeque linkedBlockingDeque;

    public HandlerTest() {

        linkedBlockingDeque = LooperTest.myLooper().queue;
    }

    public void handleMessage(MessageTest msg) {

    }

    public void dispatchMessage(MessageTest msg) {
        handleMessage(msg);

    }

    public final boolean sendMessage(MessageTest msg) {

        msg.target = this;
        linkedBlockingDeque.offer(msg);
        return true;
    }

}
