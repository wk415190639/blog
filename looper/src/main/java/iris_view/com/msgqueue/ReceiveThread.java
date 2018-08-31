package iris_view.com.msgqueue;

public class ReceiveThread extends Thread {

    public ReceiveThread() {
        setName("ReceiveThread");
    }

    @Override
    public void run() {

        LooperTest.prepareMainLooper();
        LooperTest looperTest = LooperTest.myLooper();
        looperTest.loop();
    }


}
