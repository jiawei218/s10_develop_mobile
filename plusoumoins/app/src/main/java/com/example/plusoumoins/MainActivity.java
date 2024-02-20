package com.example.plusoumoins;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int randomNombre;
    private int userInput;
    private Button button;

    protected void check(int random, int input,EditText editText,TextView notice)
    {
        if( random < input)
        {
            notice.setText(R.string.notice_plus);
            editText.setText(null);
        }
        else if( random > input )
        {
            notice.setText(R.string.notice_moins);
            editText.setText(null);
        }
        else{
            notice.setText(R.string.notice_equal);
            editText.setText(null);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //random
        Random rand = new Random();
        randomNombre = rand.nextInt(100) + 1;

        //get button
        button = findViewById(R.id.button2);
        //click event
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get nombre input
                EditText editText = findViewById(R.id.editTextText2);
                String input=editText.getText().toString();
                System.out.println("input is "+input);
                //get textview
                TextView notice=findViewById(R.id.textView);
                if(!input.equals("")) {
                    userInput = Integer.parseInt(input);
                    check(randomNombre,userInput,editText,notice);
                }
                else
                {
                    notice.setText(R.string.exception_null_input);
                }
        }});
    }
}