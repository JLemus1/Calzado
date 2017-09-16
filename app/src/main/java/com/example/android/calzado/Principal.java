package com.example.android.calzado;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Principal extends AppCompatActivity {

    private Spinner sexo, tipo, marca;
        private Resources resources;
    private String opSexo[], opTipo[], opMarca[];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        sexo = (Spinner)findViewById(R.id.cmbSexo);
        tipo = (Spinner)findViewById(R.id.cmbTipo);
        marca = (Spinner)findViewById(R.id.cmbMarca);
        resources = this.getResources();
        opSexo = resources.getStringArray(R.array.Sexo);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opSexo);
        sexo.setAdapter(adapter);

        opTipo = resources.getStringArray(R.array.Tipo);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opTipo);
        tipo.setAdapter(adapter);

        opMarca = resources.getStringArray(R.array.Marca);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opMarca);
        marca.setAdapter(adapter);

    }



}
