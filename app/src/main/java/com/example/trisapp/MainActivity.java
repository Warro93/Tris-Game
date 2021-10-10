package com.example.trisapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button button1,button2,button3,button4,
            button5,button6,button7,button8,button9;
    private int count;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);

        intent = new Intent(this,FinishGameActivity.class);

    }

    @SuppressLint("NonConstantResourceId")
    public void onClickButton(View view){
        Button button = (Button) view;
        int id = button.getId();
        int cell = 0;
        count++;

        switch (id){
            case R.id.button1:
                cell = 1;
                break;

            case R.id.button2:
                cell = 2;
                break;

            case R.id.button3:
                cell = 3;
                break;

            case R.id.button4:
                cell = 4;
                break;

            case R.id.button5:
                cell = 5;
                break;

            case R.id.button6:
                cell = 6;
                break;

            case R.id.button7:
                cell = 7;
                break;

            case R.id.button8:
                cell = 8;
                break;

            case R.id.button9:
                cell = 9;
                break;
        }
        startGame(cell,button);
    }

    List<Integer> player1 = new ArrayList<>();
    List<Integer> player2 = new ArrayList<>();
    int onlinePlayer = 1;

    private void startGame(int cell, Button button) {
        if(checkWinner() == 0 && count <= 5) {
            if (onlinePlayer == 1) {
                button.setText("X");
                button.setBackgroundColor(Color.RED);
                player1.add(cell);
                onlinePlayer = 2;
                if(count<5)
                    multiplayer();
            } else {
                button.setText("O");
                button.setBackgroundColor(Color.BLUE);
                player2.add(cell);
                onlinePlayer = 1;
            }
            button.setEnabled(false);
        }
        if(checkWinner() == 1) {
            Toast.makeText(getApplicationContext(), "HAI VINTO!", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        if(checkWinner() == 2) {
            Toast.makeText(getApplicationContext(), "HAI PERSO!", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        if (checkWinner() == 0 && count >= 5){
            Toast.makeText(getApplicationContext(), "PAREGGIO!", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
    }

    private void multiplayer() {
        List<Integer> emptyCell = new ArrayList<>();

        for(int i=1; i<10; i++){
            if(!(player1.contains(i) || player2.contains(i)))
                emptyCell.add(i);
        }
        Random random = new Random();
        int randomCell = random.nextInt(emptyCell.size());
        int cellID = emptyCell.get(randomCell);

        Button b = null;
        switch (cellID){
            case 1: b = button1;
                break;

            case 2: b = button2;
                break;

            case 3: b = button3;
                break;

            case 4: b = button4;
                break;

            case 5: b = button5;
                break;

            case 6: b = button6;
                break;

            case 7: b = button7;
                break;

            case 8: b = button8;
                break;

            case 9: b = button9;
                break;
        }
        startGame(cellID, b);
    }

    private int checkWinner(){
        int winner = 0;

        //Riga 1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
            winner = 1;
        else if(player2.contains(1) && player2.contains(2) && player2.contains(3))
            winner = 2;

        //Riga 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6))
            winner = 1;
        else if(player2.contains(4) && player2.contains(5) && player2.contains(6))
            winner = 2;

        //Riga 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9))
            winner = 1;
        else if(player2.contains(7) && player2.contains(8) && player2.contains(9))
            winner = 2;

        //Colonna 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
            winner = 1;
        else if(player2.contains(1) && player2.contains(4) && player2.contains(7))
            winner = 2;

        //Colonna 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8))
            winner = 1;
        else if(player2.contains(2) && player2.contains(5) && player2.contains(8))
            winner = 2;

        //Colonna 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9))
            winner = 1;
        else if(player2.contains(3) && player2.contains(6) && player2.contains(9))
            winner = 2;

        //Diagonale 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9))
            winner = 1;
        else if(player2.contains(1) && player2.contains(5) && player2.contains(9))
            winner = 2;

        //Diagonale 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7))
            winner = 1;
        else if(player2.contains(3) && player2.contains(5) && player2.contains(7))
            winner = 2;

        return winner;
    }

}