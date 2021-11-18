package com.example.proyectoramoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
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
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"biofit", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();

        if (!codigo.isEmpty())
        {
            Cursor file = db.rawQuery("SELECT clase, intensidad FROM clases WHERE codigo="+codigo, null);
            if (file.moveToFirst())
            {
                clas.setText(file.getString(0));
                intensi.setText(file.getString(1));
            }
            else
            {
                Toast.makeText(getBaseContext(),"NO hay clase asociada.. ", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(getBaseContext(),"El cogido  viene vacio.. ", Toast.LENGTH_SHORT).show();
        }
    }
    public void eliminarClases(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"biofit", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();

        if (!codigo.isEmpty())
        {
            db.delete("clases", "codigo="+codigo,null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(),"Se a eleminado con exito.. "+codigo, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getBaseContext(),"El cogido no debe venir vacio.. ", Toast.LENGTH_SHORT).show();
        }

    }
    public void actualizarClases(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"biofit", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();
        String clase = clas.getText().toString();
        String intensidad = intensi.getText().toString();

        if(!codigo.isEmpty() && !clase.isEmpty() && !intensidad.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("clase", clase);
            cont.put("intensidad", intensidad);

            db.update("clases",cont,"codigo="+codigo,null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(),"Has actualizado  una clase",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Hay campos vacios.. ", Toast.LENGTH_SHORT).show();
        }


    }
    public  void Clean()
    {
        code.setText("");
        clas.setText("");
        intensi.setText("");
    }
}