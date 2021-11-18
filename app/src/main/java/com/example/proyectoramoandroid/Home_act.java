package com.example.proyectoramoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import Objetos.Insumos;

public class Home_act extends AppCompatActivity {

    private VideoView videoView;
    private Insumos in = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        videoView = findViewById(R.id.videoView);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);

        videoView.start();

        //MediaController media = new MediaController(this);
        //videoView.setMediaController(media);
    }

    public void GoInsumos(View view)
    {
        Intent i = new Intent(getBaseContext(),Insumos_act.class);

        Bundle bun = new Bundle();
        bun.putStringArray("insumos",in.getInsumos());
        i.putExtras(bun);
        startActivity(i);
    }

    public void Task(View view)
    {
        try {
            for (int i = 0; i <= 10; i++)
            {
                Thread.sleep(2200);
            }

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}