package com.example.setiapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    MediaPlayer miCancion;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miCancion = MediaPlayer.create(MainActivity.this, R.raw.lovelikeyou);
        miCancion.start();
    }
    public void pulsarBoton1(View view)
    {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    protected void onPause()
    {
        super.onPause();
        miCancion.release();
        finish();
    }
}
