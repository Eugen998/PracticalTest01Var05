package ro.pub.cs.systems.eim.practicaltest01var05.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Var05Service extends Service {

    ProcessingThread processingThread = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String intentText = intent.getStringExtra("ARRAY");
        processingThread = new ProcessingThread(this, intentText);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }


    public PracticalTest01Var05Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        processingThread.stopThread();
    }
}