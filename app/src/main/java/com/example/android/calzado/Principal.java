package com.example.android.calzado;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;;

public class Principal extends AppCompatActivity {

    private EditText cantidad;
    private TextView res;
    private Spinner sexo, tipo, marca;
    private Resources resources;
    private String opSexo[], opTipo[], opMarca[];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        res = (TextView)findViewById(R.id.txtResultado);
        cantidad = (EditText)findViewById(R.id.txtCantidad);
        sexo = (Spinner)findViewById(R.id.cmbSexo);
        tipo = (Spinner)findViewById(R.id.cmbTipo);
        marca = (Spinner)findViewById(R.id.cmbMarca);
        resources = this.getResources();
        opSexo = resources.getStringArray(R.array.Sexo);
        opTipo = resources.getStringArray(R.array.Tipo);
        opMarca = resources.getStringArray(R.array.Marca);
        ArrayAdapter<String>adapterG=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opSexo);
        ArrayAdapter<String>adapterT=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opTipo);
        ArrayAdapter<String>adapterM=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opMarca);
        sexo.setAdapter(adapterG);
        tipo.setAdapter(adapterT);
        marca.setAdapter(adapterM);

    }

    public void calcular(View v){
        int opcionS,opcionT,opcionM, resultado=0,cant;
        res.setText("");

        if(validad()){

            opcionS = sexo.getSelectedItemPosition();
            opcionT=tipo.getSelectedItemPosition();
            opcionM=marca.getSelectedItemPosition();
            cant=Integer.parseInt(cantidad.getText().toString());
            switch (opcionS){
                case 0:// hombre
                    switch (opcionT){
                        case 0:
                            switch (opcionM){
                                case 0:
                                    resultado=cant*120000;
                                    break;
                                case 1:
                                    resultado=cant*140000;
                                    break;
                                case 2:
                                    resultado=cant*130000;
                                    break;
                            }
                            break;
                        case 1:
                            switch (opcionM){
                                case 0:
                                    resultado=cant*50000;
                                    break;
                                case 1:
                                    resultado=cant*80000;
                                    break;
                                case 2:
                                    resultado=cant*100000;
                                    break;
                            }
                            break;
                    }
                    break;
                case 1://mujer
                    switch (opcionT){
                        case 0:
                            switch (opcionM){
                                case 0:
                                    resultado=cant*100000;
                                    break;
                                case 1:
                                    resultado=cant*130000;
                                    break;
                                case 2:
                                    resultado=cant*110000;
                                    break;
                            }
                            break;
                        case 1:
                            switch (opcionM){
                                case 0:
                                    resultado=cant*80000;
                                    break;
                                case 1:
                                    resultado=cant*70000;
                                    break;
                                case 2:
                                    resultado=cant*120000;
                                    break;
                            }
                            break;
                    }
                    break;
            }
            res.setText(""+resultado);
        }

    }

    public void borrar(View v){
        cantidad.setText("");
        res.setText("");
        sexo.setSelection(0);
        tipo.setSelection(0);
        marca.setSelection(0);
        cantidad.requestFocus();
    }
    private boolean validad(){
        if(cantidad.getText().toString().isEmpty()){
            cantidad.setError(resources.getString(R.string.error));
            cantidad.requestFocus();
            return false;
        }
        return true;
    }



}
