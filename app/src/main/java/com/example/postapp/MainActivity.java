package com.example.postapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastrar(View v) {
        EditText nome = findViewById(R.id.edtNome);
        JSONObject pessoa = new JSONObject();
        try {
            pessoa.put("nome", nome.getText());

            new SendService().execute("http://www.blablabla.com.br/post", pessoa.toString())
;        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}