package com.jeremiah.higherorlower;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;

    public void makeToast(String string){

        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    public void generateNewNumber(){
        final Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
        String randNumberString = String.valueOf(randomNumber);
        Log.i("Random number", randNumberString);

    }

    public void submitGuess(View view){
        EditText guessField = (EditText) findViewById(R.id.guessField);
        String enteredGuess = guessField.getText().toString();
        int guessValue = Integer.parseInt(enteredGuess);
        if(guessValue == randomNumber){
            makeToast("Congratulations that is correct! Let's Play again!");
            generateNewNumber();
        } else if ( guessValue < randomNumber){
            makeToast("Higher!");
        } else{
            makeToast("Lower!");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateNewNumber();
    }
}
