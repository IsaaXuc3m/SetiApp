package com.example.setiapp;

import android.content.Context;
import android.content.Intent;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity
{
    int contador = 0;
    TextView contadorText;
    EditText txtMili;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        contadorText = (TextView)findViewById(R.id.txtContador2);
        txtMili = (EditText)findViewById(R.id.txtMiliSegundosVibrar);
    }

    public void botonSumar(View view)
    {
        contador++;
        contadorText.setText("" + contador);
        if(contador == 10)
        {
            activarReceiver();
        }
    }

    public void botonRestar(View view)
    {
        contador--;
        contadorText.setText("" + contador);
        if(contador == 10)
        {
            activarReceiver();
        }
    }

    public void botonVibrar(View view)
    {
        //((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(150,10));

        ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(Integer.parseInt(txtMili.getText().toString()));
    }

    public void botonToast(View view)
    {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Toma tostada", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void activarReceiver()
    {
        Intent intent = new Intent(this,MyReceiver.class);
        sendBroadcast(intent);
        Log.i("Receiver","Intent Enviado");
    }

    public void botonPrintV(View view)
    {
        Log.v("tag","Mensaje");
    }

    public void botonPrintD(View view)
    {
        Log.d("tag","Mensaje");
    }

    public void botonPrintI(View view)
    {
        Log.i("tag","Mensaje");
    }

    public void botonIniciarServicio(View view)
    {
        Intent intent = new Intent(this, ServicioIsaac.class);
        startService(intent);
    }

    public void botonPararServicio(View view)
    {
        Intent intent = new Intent(this, ServicioIsaac.class);
        stopService(intent);
    }

    public void botonAsincrono(View view)
    {
        TareaAsincrona tarea = new TareaAsincrona();
        tarea.execute();
    }
}
