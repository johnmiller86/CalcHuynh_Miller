package com.twh5257_jdm5908_bw.ist402.calchuynh_miller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalcActivity extends AppCompatActivity {

    // Instance variables
    private TextView outputScreen;
    private Button button;
    private Double num1, num2;
    private String operator;
    private boolean operatorClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        outputScreen = (TextView) findViewById(R.id.textView1);
        num1 = Double.NaN;
        num2 = Double.NaN;
        operator = "";
        operatorClicked = false;
    }

    //listeners to pressed numbers
    public void tapZero(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button0);

        if (operatorClicked) {
            outputScreen.setText(button.getText().toString());
            operatorClicked = false;
        } else {
            outputScreen.setText(outputScreen.getText() + button.getText().toString());
        }
    }

    public void tapOne(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button1);

        if (operatorClicked) {
            outputScreen.setText(button.getText().toString());
            operatorClicked = false;
        }
        //display on screen
        else {
            outputScreen.setText(outputScreen.getText() + button.getText().toString());
        }
    }

    public void tapTwo(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button2);

        if (operatorClicked) {
            outputScreen.setText(button.getText().toString());
            operatorClicked = false;
        }
        //display on screen
        else {
            outputScreen.setText(outputScreen.getText() + button.getText().toString());
        }
    }

    public void tapThree(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button3);

        if (operatorClicked) {
            outputScreen.setText(button.getText().toString());
            operatorClicked = false;
        }
        //display on screen
        else {
            outputScreen.setText(outputScreen.getText() + button.getText().toString());
        }
    }

    public void tapFour(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button4);

        if (operatorClicked) {
            outputScreen.setText(button.getText().toString());
            operatorClicked = false;
        }
        //display on screen
        else {
            outputScreen.setText(outputScreen.getText() + button.getText().toString());
        }
    }

    public void tapFive(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button5);

        if (operatorClicked) {
            outputScreen.setText(button.getText().toString());
            operatorClicked = false;
        }
        //display on screen
        else {
            outputScreen.setText(outputScreen.getText() + button.getText().toString());
        }
    }

    public void tapSix(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button6);

        if (operatorClicked) {
            outputScreen.setText(button.getText().toString());
            operatorClicked = false;
        }
        //display on screen
        else {
            outputScreen.setText(outputScreen.getText() + button.getText().toString());
        }
    }

    public void tapSeven(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button7);

        if (operatorClicked) {
            outputScreen.setText(button.getText().toString());
            operatorClicked = false;
        }
        //display on screen
        else {
            outputScreen.setText(outputScreen.getText() + button.getText().toString());
        }
    }

    public void tapEight(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button8);

        if (operatorClicked) {
            outputScreen.setText(button.getText().toString());
            operatorClicked = false;
        }
        //display on screen
        else {
            outputScreen.setText(outputScreen.getText() + button.getText().toString());
        }
    }

    public void tapNine(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button9);

        if (operatorClicked) {
            outputScreen.setText(button.getText().toString());
            operatorClicked = false;
        }
        //display on screen
        else {
            outputScreen.setText(outputScreen.getText() + button.getText().toString());
        }
    }

    public void tapDecimal(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.buttonDec);

        //display on screen
        String existingString = outputScreen.getText().toString();
        if (!existingString.contains(".") == true) {
            outputScreen.setText(existingString + button.getText().toString());
        } else {
            Toast.makeText(this, "Numbers may not contain more than one decimal!!", Toast.LENGTH_SHORT).show();
        }
    }


    //listener to pressed operators
    public void tapDivide(View view) {

        button = (Button) findViewById(R.id.buttonDiv);

        if (num1.isNaN()) {
            operator = button.getText().toString();
            num1 = Double.parseDouble(outputScreen.getText().toString());
            operatorClicked = true;
        } else if (operator.equals("=")) {
            operator = button.getText().toString();
            operatorClicked = true;
        } else {
            num2 = Double.parseDouble(outputScreen.getText().toString());
            num1 = performOperation(num1, num2, operator);
            outputScreen.setText(String.valueOf(num1));
            num2 = Double.NaN;
            operator = button.getText().toString();
            operatorClicked = true;
        }
    }

    public void tapMultiply(View view) {

        button = (Button) findViewById(R.id.buttonMult);

        if (num1.isNaN()) {
            operator = button.getText().toString();
            num1 = Double.parseDouble(outputScreen.getText().toString());
            operatorClicked = true;
        } else if (operator.equals("=")) {
            operator = button.getText().toString();
            operatorClicked = true;
        } else {
            num2 = Double.parseDouble(outputScreen.getText().toString());
            num1 = performOperation(num1, num2, operator);
            outputScreen.setText(String.valueOf(num1));
            num2 = Double.NaN;
            operator = button.getText().toString();
            operatorClicked = true;
        }
    }

    public void tapSubtract(View view) {

        button = (Button) findViewById(R.id.buttonSub);

        if (num1.isNaN()) {
            operator = button.getText().toString();
            num1 = Double.parseDouble(outputScreen.getText().toString());
            outputScreen.setText("");
            operatorClicked = true;
        } else if (operator.equals("=")) {
            operator = button.getText().toString();
            operatorClicked = true;
        } else {
            num2 = Double.parseDouble(outputScreen.getText().toString());
            num1 = performOperation(num1, num2, operator);
            outputScreen.setText(String.valueOf(num1));
            num2 = Double.NaN;
            operator = button.getText().toString();
            operatorClicked = true;
        }
    }

    public void tapAdd(View view) {

        button = (Button) findViewById(R.id.buttonAdd);

        if (num1.isNaN()) {
            operator = button.getText().toString();
            num1 = Double.parseDouble(outputScreen.getText().toString());
            operatorClicked = true;
        } else if (operator.equals("=")) {
            operator = button.getText().toString();
            operatorClicked = true;
        } else {
            num2 = Double.parseDouble(outputScreen.getText().toString());
            num1 = performOperation(num1, num2, operator);
            outputScreen.setText(String.valueOf(num1));
            num2 = Double.NaN;
            operator = button.getText().toString();
            operatorClicked = true;
        }
    }

    //click listeners to function buttons
    public void tapClear(View view) {

        outputScreen.setText("");
        num1 = Double.NaN;
        num2 = Double.NaN;
        operator = "";
        operatorClicked = false;
    }

    public void tapBackSpace(View view) {

        String expression = outputScreen.getText().toString();

        if (expression.length() > 0) {
            expression = expression.substring(0, expression.length() - 1);
            num1 = Double.parseDouble(expression);
            operatorClicked = false;
        }
        outputScreen.setText(expression);
    }

    public void tapEnter(View view) {

        button = (Button) findViewById(R.id.buttonEquals);

        if (operator.equals("=")) {
            Toast.makeText(this, "You must select an operator!", Toast.LENGTH_SHORT);
        }

        if (!num1.isNaN() && !operator.equals("") && !operator.equals("=")) {
            num2 = Double.parseDouble(outputScreen.getText().toString());
            num1 = performOperation(num1, num2, operator);
            outputScreen.setText(String.valueOf(num1));
            num2 = Double.NaN;
            operator = button.getText().toString();
            operatorClicked = true;
        } else {
            Toast.makeText(this, "You have not entered a valid expression", Toast.LENGTH_SHORT);
        }
    }

    /**
     * Checks if there is a pending operation.
     *
     * @param num1 the number to be evaluated.
     * @param oper the operator to be evaluated.
     * @return true or false.
     */
    private Double performOperation(Double num1, Double num2, String oper) {

        Double result = Double.NaN;

        switch (oper) {
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    Toast.makeText(this, "You cannot divide by zero!!", Toast.LENGTH_SHORT).show();
                }
                break;
            case "*":
                result = num1 * num2;
                break;
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
        }
        return result;
    }
}
