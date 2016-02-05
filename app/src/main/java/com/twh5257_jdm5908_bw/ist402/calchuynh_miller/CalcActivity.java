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
    private boolean operatorClicked, numberClicked;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        outputScreen = (TextView) findViewById(R.id.textView1);
        calculator = new Calculator();
        operatorClicked = false;
        numberClicked = false;
    }

    /**
     * Handlew button zero clicks.
     */
    public void tapZero(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button0);

        // Only one leading zero allowed
        if (!outputScreen.getText().equals("0")) {

            // Handling click
            hitNumber(button);
        } else outputScreen.setText("0");
    }

    /**
     * Handles button one clicks.
     * \
     */
    public void tapOne(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button1);

        // Handling click
        hitNumber(button);
    }

    /**
     * Handles button two clicks.
     *
     * @param view
     */
    public void tapTwo(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button2);

        // Handling Click
        hitNumber(button);
    }

    /**
     * Handles button three clicks.
     \     */
    public void tapThree(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button3);

        // Handling click
        hitNumber(button);
    }

    /**
     * Handles button four clicks.
     * @param view
     */
    public void tapFour(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button4);

        // Handling click
        hitNumber(button);
    }

    /**
     * Handles button five clicks.
     */
    public void tapFive(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button5);

        // Handling click
        hitNumber(button);
    }

    /**
     * Handles button six clicks.
     */
    public void tapSix(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button6);

        // Handling click
        hitNumber(button);
    }

    /**
     * Handles button seven clicks.
     */
    public void tapSeven(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button7);

        // Handling click
        hitNumber(button);
    }

    /**
     * Handles button eight clicks.
     */
    public void tapEight(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button8);

        // Handling click
        hitNumber(button);
    }

    /**
     * Handles button nine clicks.
     */
    public void tapNine(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button9);

        // Handling click
        hitNumber(button);
    }

    /**
     * Handles divide button clicks.
     */
    public void tapDivide(View view) {

        // Assigning button
        button = (Button) findViewById(R.id.buttonDiv);

        // Performing operation
        hitOperator(button);
    }

    /**
     * Handles multiply button clicks.
     */
    public void tapMultiply(View view) {

        // Assigning button
        button = (Button) findViewById(R.id.buttonMult);

        // Performing operation
        hitOperator(button);
    }

    /**
     * Handles subtract button clicks.
     */
    public void tapSubtract(View view) {

        // Assigning button
        button = (Button) findViewById(R.id.buttonSub);

        // Performing operation
        hitOperator(button);
    }

    /**
     * Handles add button clicks.
     */
    public void tapAdd(View view) {

        // Assigning button
        button = (Button) findViewById(R.id.buttonAdd);

        // Performing operation
        hitOperator(button);
    }

    /**
     * Handles clear  button clicks.
     */
    public void tapClear(View view) {

        calculator = new Calculator();
        outputScreen.setText("");
        operatorClicked = false;
    }

    /**
     * Handles backspace button clicks.
     */
    public void tapBackSpace(View view) {

        String expression = outputScreen.getText().toString();
        if (expression.length() > 0) {
            expression = expression.substring(0, expression.length() - 1);

            if (expression.length() != 0) {
                calculator.setNum1(Double.parseDouble(expression));
            }
            operatorClicked = false;
        }
        outputScreen.setText(expression);
    }

    /**
     * Handles enter button clicks.
     * @param view
     */
    public void tapEnter(View view) {

        button = (Button) findViewById(R.id.buttonEquals);

        if (calculator.getOperator().equals("=")) {
            Toast.makeText(this, "You must select an operator!", Toast.LENGTH_SHORT);
        }

        if (!calculator.getNum1().isNaN() && !calculator.getOperator().equals("") && !calculator.getOperator().equals("=")) {
            calculator.setNum2(Double.parseDouble(outputScreen.getText().toString()));
            calculator.setNum1(calculator.performOperation());
            outputScreen.setText(String.valueOf(calculator.getNum1()));
            calculator.setNum2(Double.NaN);
            calculator.setOperator(button.getText().toString());
        } else {
            Toast.makeText(this, "You have not entered a valid expression", Toast.LENGTH_SHORT);
        }
    }

    public void tapDecimal(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.buttonDec);
        String existingString = outputScreen.getText().toString();

        if (operatorClicked && !existingString.contains(".")) {
            outputScreen.setText(".");
        } else if (!operatorClicked && !existingString.contains(".")) {
            outputScreen.setText(existingString + button.getText().toString());
        } else {
            Toast.makeText(this, "Numbers may not contain more than one decimal!!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Handles number buttons.
     * @param b the number button.
     */
    private void hitNumber(Button b) {

        // Build new number
        if (operatorClicked) {
            outputScreen.setText(b.getText().toString());
        }

        // Add digit
        else {
            outputScreen.setText(outputScreen.getText() + b.getText().toString());
        }
        operatorClicked = false;
    }

    /**
     * Handles operator buttons.
     * @param b the operator button.
     */
    private void hitOperator(Button b) {

        if (!operatorClicked) {
            // If first number set number and operator
            if (calculator.getNum1().isNaN()) {

                try {
                    calculator.setOperator(b.getText().toString());
                    calculator.setNum1(Double.parseDouble(outputScreen.getText().toString()));
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "You must enter a number before choosing an operator!", Toast.LENGTH_SHORT);
                }
            }

            // If last operator was equals change operator, wait for second number
            else if (calculator.getOperator().equals("=")) {
                calculator.setOperator(b.getText().toString());
            }

            // Calculate and store as num1 for further operations
            else {
                calculator.setNum2(Double.parseDouble(outputScreen.getText().toString()));
                calculator.setNum1(calculator.performOperation());
                outputScreen.setText(String.valueOf(calculator.getNum1()));
                calculator.setNum2(Double.NaN);
                calculator.setOperator(b.getText().toString());
            }
            operatorClicked = true;
        } else {
            Toast.makeText(this, "Number expected...", Toast.LENGTH_SHORT).show();
        }
    }
}
