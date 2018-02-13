package com.example.setiapp;

import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
    }

    public void botonRestar(View view)
    {
        contador--;
        contadorText.setText("" + contador);
    }

    public void botonVibrar(View view)
    {
        //((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(150,10));

        ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(Integer.parseInt(txtMili.getText().toString()));
    }
}
