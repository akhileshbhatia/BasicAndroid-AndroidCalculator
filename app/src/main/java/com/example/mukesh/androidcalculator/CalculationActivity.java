package com.example.mukesh.androidcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculationActivity extends AppCompatActivity {

    private EditText screen = null;
    private String operation = "";
    private double firstNum = 0;
    private double secondNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        screen = findViewById(R.id.screen);

    }

    public void onClickDigit(View v){

        //concatenate the label of v to the screen text
        String label = ((Button)v).getText().toString();
        String screenStr = screen.getText().toString();
        if(label == "." && !screenStr.contains(".")){
            screen.setText(screenStr + label);
        }
        else{
            screen.setText(screenStr + label);
        }
    }

    public void onClickOperation(View v){
        String screenText = screen.getText().toString();
        if(!screenText.isEmpty()){
            //get the operation
            operation = ((Button)v).getText().toString();
            //get the first number
            firstNum = Double.parseDouble(screen.getText().toString());
            //clear screen
            screen.setText("");
        }
    }

    public void  onClickClear(View v){

        //reinitialize all variables
        screen.setText("");
        firstNum=secondNum=0;
        operation="";

    }

    public void onClickEqual(View v){
        if(operation != ""){
           secondNum = Double.parseDouble(screen.getText().toString());

           switch (operation){
               case "+":
                   screen.setText(String.valueOf(firstNum + secondNum));
                   break;

               case "-":
                   screen.setText(String.valueOf(firstNum - secondNum));
                   break;

               case "*":
                   screen.setText(String.valueOf(firstNum * secondNum));
                   break;

               case "/":
                   if(secondNum == 0){
                       screen.setText("Cannot divide by zero");
                   }
                   else{
                       screen.setText(String.valueOf(firstNum / secondNum));
                   }
                   break;

               default:
                   break;
           }
        }
    }
}
