package com.example.pracroomdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class AgregarAnimal extends AppCompatActivity {

    public static final String RPT_EXTRA1 = "com.example.android.roomdata.RPT";
    public static final String RPT_EXTRA2 = "com.example.android.roomdata.RPT";
    public static final String RPT_EXTRA3 = "com.example.android.roomdata.RPT";
    public static final String RPT_EXTRA4 = "com.example.android.roomdata.RPT";
    private EditText edt_nombre;
    private Spinner cmb_alimentacion;
    private Spinner cmb_estructura;
    private Spinner cmb_continente;
    private Button btn_agregar_animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_animal);

        edt_nombre = findViewById(R.id.edt_nombre);
        cmb_alimentacion = findViewById(R.id.cmb_alimentacion);
        cmb_estructura = findViewById(R.id.cmb_estructura);
        cmb_continente = findViewById(R.id.cmb_continente);
        btn_agregar_animal = findViewById(R.id.btn_agregar_animal);

        ArrayAdapter<CharSequence> adapterAlimentacion = ArrayAdapter.createFromResource(this, R.array.spinner_alimentacion, R.layout.support_simple_spinner_dropdown_item);
        adapterAlimentacion.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cmb_alimentacion.setAdapter(adapterAlimentacion);

        ArrayAdapter<CharSequence> adapterEstructura = ArrayAdapter.createFromResource(this, R.array.spinner_estructura, R.layout.support_simple_spinner_dropdown_item);
        adapterEstructura.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cmb_estructura.setAdapter(adapterEstructura);

        ArrayAdapter<CharSequence> adapterContinente = ArrayAdapter.createFromResource(this, R.array.spinner_continentes, R.layout.support_simple_spinner_dropdown_item);
        adapterContinente.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        cmb_continente.setAdapter(adapterContinente);

        btn_agregar_animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if (TextUtils.isEmpty(edt_nombre.getText())){
                    setResult(RESULT_CANCELED,intent);
                } else {
                    String nombre = edt_nombre.getText().toString();
                    String alimentacion = cmb_alimentacion.getSelectedItem().toString();
                    String estructura = cmb_estructura.getSelectedItem().toString();
                    String continente = cmb_continente.getSelectedItem().toString();
                    intent.putExtra("nombre", nombre);
                    intent.putExtra("estructura", estructura);
                    intent.putExtra("alimentacion", alimentacion);
                    intent.putExtra("continente", continente);
                    setResult(RESULT_OK,intent);
                }
                finish();
            }
        });

    }
}
