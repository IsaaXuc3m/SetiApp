package com.example.setiapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        Toast toast = Toast.makeText(context, "Hemos llegado a 10, Viva la bida y biba el hamor", Toast.LENGTH_SHORT);
        toast.show();
        Log.i("Receiver","Receiver funcionando");
    }
}
