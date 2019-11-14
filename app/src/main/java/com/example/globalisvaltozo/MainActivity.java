package com.example.globalisvaltozo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonKuldes;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        buttonKuldes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("Adatok", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nev", editText.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                editor.apply();
            }
        });
    }


    private void init(){
        buttonKuldes = findViewById(R.id.buttonKuldes);
        editText = findViewById(R.id.editText);
    }
}
