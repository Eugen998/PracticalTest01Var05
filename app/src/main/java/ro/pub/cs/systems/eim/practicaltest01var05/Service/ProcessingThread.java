package ro.pub.cs.systems.eim.practicaltest01var05.Service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;
import java.util.Random;

import ro.pub.cs.systems.eim.practicaltest01var05.General.Constants;

public class ProcessingThread extends Thread{
    private Context context = null;
    private boolean isRunning = true;

    private Random random = new Random();

    private String text;

    public ProcessingThread(Context context, String receivedText) {
        this.context = context;

        text = receivedText;
    }

    @Override
    public void run() {
//        Log.d(Constants.PROCESSING_THREAD_TAG, "Thread has started! PID: " + Process.myPid() + " TID: " + Process.myTid());
        while (isRunning) {
            sendMessage();
            sleep();
        }
        Log.d(Constants.PROCESSING_THREAD_TAG, "Thread has stopped!");
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction("ro.pub.cs.systems.eim.practicaltest01var05.action");
        intent.putExtra(Constants.BROADCAST_RECEIVER_EXTRA, text);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
