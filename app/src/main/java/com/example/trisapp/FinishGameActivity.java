package com.example.trisapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FinishGameActivity extends AppCompatActivity {

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_game);

        i = new Intent(this, MainActivity.class);
    }

    public void onClickRestart(View v){
        startActivity(i);
    }

    public void onClickQuit(View v){
        finish();
    }
}