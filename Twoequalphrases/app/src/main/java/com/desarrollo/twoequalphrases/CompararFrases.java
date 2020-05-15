package com.desarrollo.twoequalphrases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class CompararFrases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparar_frases);

        //MENSAJE

        Toast.makeText(getBaseContext(),getString(R.string.ToaskError),Toast.LENGTH_SHORT).show();

        //ENCAPSULAR LOS DATOS
        String Frase1 = getIntent().getStringExtra("Frase1logica");
        String Frase2 = getIntent().getStringExtra("Frase2logica");


        //CONTANDO VOCALES

        int conf1 = 0;
        int conf2 = 0;
        String Verificador = "";

        for(int x = 0 ; x < Frase1.length() ; x++) {
            if ((Frase1.charAt(x)=='a') || (Frase1.charAt(x)=='e') || (Frase1.charAt(x)=='o')){
                conf1++;
            }
        }

        for(int x = 0 ; x < Frase2.length() ; x++) {
            if ((Frase2.charAt(x)=='a') || (Frase2.charAt(x)=='e') || (Frase2.charAt(x)=='o')){
                conf2++;
            }
        }

        //IGUALDAD DE ORACIONES

        if (Objects.equals(Frase1, Frase2)) {
            Verificador = getString(R.string.Verificador1);
        } else {
            Verificador = getString(R.string.Verificador2);
        }

        //ASIGNAR DATOS 1

        TextView Salida = new TextView(this);

        Salida.setText("\n\t" + getString(R.string.primera) + "\n" + "\t" + Frase1 +
                "\n\n\t" + getString(R.string.segunda) + "\n" + "\t" + Frase2 +
                "\n\n\n\t" + getString(R.string.titulovocales) +
                "\n\n\t" + getString(R.string.vocalabierta1)  + conf1 +
                "\n\t" + getString(R.string.vocalabierta2) + conf2 +
                "\n\n\r\t" + Verificador);
        Salida.setTextSize(20);

        //MOSTRAR DATOS

        ScrollView delizar = new ScrollView(this);
        delizar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        delizar.setVerticalScrollBarEnabled(true);
        delizar.addView(Salida);
        setContentView(delizar);
    }
}


        /*Salida.setText("\n\tFirst Sentence: \n" + "\t" + Frase1 +
                "\n\n\tSecond Sentence: \n" + "\t" + Frase2 +
                "\n\n\n\tCLOSED VOWELS" +
                "\n\n\tVowels of the first sentence: " + conf1 +
                "\n\tVowels of the second sentence: " + conf2 +
                "\n\n\r\t" + Verificador);*/

        //String prueba = getString(R.string.primera);

        /*ViewGroup viewGroup = (ViewGroup)findViewById(R.id.compararfrase);
        viewGroup.addView(Salida);*/