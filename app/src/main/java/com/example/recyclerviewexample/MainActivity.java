package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void exampleSimples(View view){
        startActivity(new Intent(this , Simples.class));
    }

    public void exampleClick(View view){
        startActivity(new Intent(this , MultiClick.class));
    }

    /*
    TODO / ATENÇÃO - LEIA ISSO

    todo / Ver "build.gradle (Module: app)" , dependencies.
    todo / Ver AndroidManifest , a permissão de Acessar internet é necessária para carregar as img da web
     */
}