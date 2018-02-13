package com.example.setiapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ServicioIsaac extends Service {
    public ServicioIsaac() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
