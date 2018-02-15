package com.example.setiapp;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Isaac on 15/02/2018.
 */

public class TareaAsincrona extends AsyncTask<Void, Integer, Boolean>
{
    @Override
    protected Boolean doInBackground(Void... params)
    {
        String genero="", nombreTit="", nombre="", apellido="", calle, ciudad, estado, cp, email, user, pass, salt, md5, sha1, sha256, dob, registered,
                phone, cell, idName, idValue, imagenGrande, imagenMediana, imagenPequena, nat;



        Log.d("test","1");
        try
        {
            URL direccion = new URL("https://randomuser.me/api/");
            Log.d("test","2");
            HttpsURLConnection myConnection = (HttpsURLConnection) direccion.openConnection();
            Log.d("test","3");
            if(myConnection.getResponseCode()==200)
            {
                //Conexi'on exitosa
                InputStream responseBody = myConnection.getInputStream();
                Log.d("test","4");
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                JsonReader json = new JsonReader(responseBodyReader);
                Log.i("json","mi json:" + json);
                Log.i("json",json.toString());
                json.beginObject();

                String name = json.nextName();
                if(name.equals("results"))
                {
                    json.beginArray();
                    Log.d("test","5");
                    json.beginObject();
                    Log.d("test","6");
                    while(json.hasNext())
                    {
                        name = json.nextName();
                        Log.d("test","7");
                        switch (name)
                        {
                            case "gender":
                                genero = json.nextString();
                                Log.d("test","8");
                                break;
                            case "name":
                                json.beginObject();
                                Log.d("test","9");
                                json.nextName();
                                nombreTit = json.nextString();
                                json.nextName();
                                nombre = json.nextString();
                                json.nextName();
                                apellido = json.nextString();
                                json.endObject();
                                break;

                            default:
                        }
                    }
                    Log.i("Prueba","9"+ genero + nombreTit + nombre + apellido);


                }

                /*
                //List<Object> lista = json.
                Log.i("json",json.toString());
                Log.i("json",json.nextName()); // results
                Log.i("json",json.toString());
                json.beginArray();
                Log.i("json",json.toString());
                json.beginObject();
                Log.i("json",json.toString());
                json.nextName();
                Log.i("json",json.toString());
                //json.ne
                */
            }
            else
            {
                Log.d("Error","Codigo de vuelta no 200");
            }
        }
        catch(MalformedURLException e)
        {
            Log.d("Error","Malformed URL");
        }
        catch(IOException e)
        {
            Log.d("Error","IOException");
        }
        return true;
    }
}
