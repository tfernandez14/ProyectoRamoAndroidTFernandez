package com.example.proyectoramoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectoramoandroid.Database.AdminSQLiteOpenHelper;

public class Clases_act extends AppCompatActivity
{
    private EditText code, clas, intensi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clases);

        code = findViewById(R.id.editTextCodigo);
        clas = findViewById(R.id.editTextClase);
        intensi = findViewById(R.id.editTextIntensidad);
    }

    public  void guardarClases(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"biofit", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();
        String clase = clas.getText().toString();
        String intensidad = intensi.getText().toString();

        if(!codigo.isEmpty() && !clase.isEmpty() && !intensidad.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("codigo", codigo);
            cont.put("clase", clase);
            cont.put("intensidad", intensidad);

            db.insert("clases", null, cont);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(),"Has guardado una clase",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Hay campos vacios.. ", Toast.LENGTH_SHORT).show();
        }
    }

    public void mostrarClases(View view)
    {

    }
    public void eliminarClases(View view)
    {

    }
    public void actualizarClases(View view)
    {

    }
    public  void Clean()
    {
        code.setText("");
        clas.setText("");
        intensi.setText("");
    }
}