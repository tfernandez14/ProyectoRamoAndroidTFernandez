package com.example.proyectoramoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;
import Objetos.Insumos;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private ProgressBar barra;
    private Button btn;
    private Administrador adm = new Administrador();
    private Insumos in = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.etUser);
        pass = findViewById(R.id.etPass);
        msj = findViewById(R.id.msj);
        barra = findViewById(R.id.pb);
        btn = findViewById(R.id.btnIniciar);

        barra.setVisibility(View.INVISIBLE);


        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new Task().execute();

            }
        });

    }

    class Task extends AsyncTask<String, Void, String>
    {
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings)
        {
            try
            {
                for (int i = 0; i <= 10; i++)
                {
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            barra.setVisibility(View.INVISIBLE);
            String usuario = user.getText().toString().trim();
            String contrasena = pass.getText().toString().trim();

            String userObj = adm.getUser().trim();
            String userPass = adm.getPass().trim();

            switch (usuario)
            {
                case "Tomas":
                    if(usuario.equals(userObj) && contrasena.equals(userPass))
                    {
                        Intent i = new Intent(getBaseContext(),Home_act.class);

                        Bundle bun = new Bundle();
                        bun.putStringArray("insumos",in.getInsumos());
                        i.putExtras(bun);
                        startActivity(i);
                    }
                    break;
                case"":
                    if (usuario.equals("") || contrasena.equals(""))
                    {
                        msj.setText("Los campos estan vacios favor de ingresar correctamente");
                    }
                    break;
                default:
                    if (!usuario.equals(userObj) || !contrasena.equals(userPass))
                    {
                        msj.setText("Los campos estan incorrectos favor de ingresar correctamente");
                    }
                    break;
            }

        }
    }










    public  void Facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(i);
    }

    public  void Youtube(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);
    }

    public  void Twitter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.twitter.com/"));
        startActivity(i);
    }

    public void Info(View view)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }
}