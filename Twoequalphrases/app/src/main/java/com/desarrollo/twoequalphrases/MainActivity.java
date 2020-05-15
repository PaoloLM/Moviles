package com.desarrollo.twoequalphrases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button comparar = (Button)findViewById(R.id.buttoncomparar);

        comparar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),CompararFrases.class);
                EditText editText1 = (EditText)findViewById(R.id.editText1);
                EditText editText2 = (EditText)findViewById(R.id.editText2);

                String Frase1 = editText1.getText().toString();
                String Frase2 = editText2.getText().toString();

                if(Frase1.length() == 0 || Frase2.length() == 0 ) {
                    Toast.makeText(getBaseContext(),getString(R.string.errortamaño),Toast.LENGTH_SHORT).show();
                }

                else{
                    intent.putExtra("Frase1logica", Frase1);
                    intent.putExtra("Frase2logica", Frase2);
                    startActivity(intent);
                }
            }
        });

    }
}
