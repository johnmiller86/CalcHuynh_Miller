package com.twh5257_jdm5908_bw.ist402.calchuynh_miller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

/**
 * Class to model a calculator.
 *
 * @version 1.0.1
 * @author John D. Miller, Tisa Huynh
 * @since 02/04/2016
 */
public class CalcActivity extends AppCompatActivity {

    // Bundle variables
    static final String TEXTVIEW = "textview";
    static final String OPERATOR = "operator";
    static final String NUM_1 = "num1";
    static final String NUM_2 = "num2";
    private final String OPERATOR_CLICKED = "clicked";

    // Instance variables
    private TextView outputScreen;
    private Button button;
    private boolean operatorClicked;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        outputScreen = (TextView) findViewById(R.id.textView1);

        // Restoring savedInstanceState
        if (savedInstanceState != null) {
            outputScreen.setText(savedInstanceState.getString(TEXTVIEW));
            if (savedInstanceState.getString(NUM_1).equals("null")) {
                calculator = new Calculator();
                calculator.setNum1(null);
                calculator.setNum2(null);
                calculator.setOperator(savedInstanceState.getString(OPERATOR));
                operatorClicked = savedInstanceState.getBoolean(OPERATOR_CLICKED);
            } else if (savedInstanceState.getString(NUM_2).equals("null")) {
                calculator = new Calculator();
                calculator.setNum1(new BigDecimal(savedInstanceState.getString(NUM_1)));
                calculator.setNum2(null);
                calculator.setOperator(savedInstanceState.getString(OPERATOR));
                operatorClicked = savedInstanceState.getBoolean(OPERATOR_CLICKED);
            } else {
                calculator = new Calculator(new BigDecimal(savedInstanceState.getString(NUM_1)), new BigDecimal(savedInstanceState.getString(NUM_2)), savedInstanceState.getString(OPERATOR));
                operatorClicked = savedInstanceState.getBoolean(OPERATOR_CLICKED);
            }
        }

        // Creating new instance
        else {
            calculator = new Calculator();
            operatorClicked = false;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString(TEXTVIEW, outputScreen.getText().toString());
        if (calculator.getNum1() == null) {
            savedInstanceState.putString(NUM_1, "null");
            savedInstanceState.putString(NUM_2, "null");
        } else if (calculator.getNum2() == null) {
            savedInstanceState.putString(NUM_1, calculator.getNum1().toString());
            savedInstanceState.putString(NUM_2, "null");
        } else if (calculator.getNum1() != null && calculator.getNum2() != null) {
            savedInstanceState.putString(NUM_1, calculator.getNum1().toString());
            savedInstanceState.putString(NUM_2, calculator.getNum2().toString());
        }
        savedInstanceState.putString(OPERATOR, calculator.getOperator());
        savedInstanceState.putBoolean(OPERATOR_CLICKED, operatorClicked);
        super.onSaveInstanceState(savedInstanceState);
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
     *
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
     * @param view the view.
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
     *
     * @param view the view.
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
        hitOperator(button, view);
    }

    /**
     * Handles multiply button clicks.
     */
    public void tapMultiply(View view) {

        // Assigning button
        button = (Button) findViewById(R.id.buttonMult);

        // Performing operation
        hitOperator(button, view);
    }

    /**
     * Handles subtract button clicks.
     */
    public void tapSubtract(View view) {

        // Assigning button
        button = (Button) findViewById(R.id.buttonSub);

        // Performing operation
        hitOperator(button, view);
    }

    /**
     * Handles add button clicks.
     */
    public void tapAdd(View view) {

        // Assigning button
        button = (Button) findViewById(R.id.buttonAdd);

        // Performing operation
        hitOperator(button, view);
    }

    /**
     * Handles clear  button clicks.
     */
    public void tapClear(View view) {

        // Assigning button
        button = (Button) findViewById(R.id.buttonClear);

        if (calculator.getNum1() == null && outputScreen.getText().equals("")) {
            Toast.makeText(this, "Nothing to clear..", Toast.LENGTH_SHORT).show();
        } else {
            // Resetting
            calculator = new Calculator();
            outputScreen.setText("");
            operatorClicked = false;
        }
    }

    /**
     * Handles backspace button clicks.
     */
    public void tapBackSpace(View view) {

        // Assigning button
        button = (Button) findViewById(R.id.buttonBack);

        // Getting text
        String expression = outputScreen.getText().toString();

        // Remove a character
        if (expression.length() > 0) {
            expression = expression.substring(0, expression.length() - 1);

            //operatorClicked = false;
            outputScreen.setText(expression);
        }

        // No text to backspace
        else {
            Toast.makeText(this, "Nothing to backspace..", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Handles enter button clicks.
     */
    public void tapEnter(View view) {

        // Assigning button
        button = (Button) findViewById(R.id.buttonEquals);
        button.playSoundEffect(SoundEffectConstants.CLICK);

        // Awaiting operator for result
        if (calculator.getOperator().equals("=")) {
            Toast.makeText(this, "You must enter an operator!!", Toast.LENGTH_SHORT).show();
        }

        // Catching divide by zero
        else if (Double.parseDouble(outputScreen.getText().toString()) == 0 && calculator.getOperator().equals("/")) {
            Toast.makeText(this, "You cannot divide by zero!! Please try again..", Toast.LENGTH_SHORT).show();
            tapClear(view);
        }

        // Calculating
        else if (calculator.getNum1() != null && !calculator.getOperator().equals("")) {
            calculator.setNum2(new BigDecimal(outputScreen.getText().toString()));
            calculator.performOperation();
            outputScreen.setText(String.valueOf(calculator.getNum1().stripTrailingZeros().toPlainString()));
            calculator.setNum2(null);
            calculator.setOperator(button.getText().toString());
        }

        // Awaiting number and operator
        else {
            Toast.makeText(this, "You must enter a number and an operator!!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Handles decimal button clicks
     *
     * @param view the view.
     */
    public void tapDecimal(View view) {

        //Assigning button and getting text
        button = (Button) findViewById(R.id.buttonDec);
        String existingString = outputScreen.getText().toString();

        // Adding decimal
        if (!existingString.contains(".")) {
            outputScreen.setText(existingString + button.getText().toString());
        }

        // Allowing decimal first computations
        if (operatorClicked) {
            outputScreen.setText(0 + button.getText().toString());
        }

        // One decimal per number
        if (existingString.contains(".") && !operatorClicked) {
            Toast.makeText(this, "Numbers may not contain more than one decimal!!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Handles number buttons.
     * @param b the number button.
     */
    private void hitNumber(Button b) {

        // Preventing number first continuing with result
        if (calculator.getOperator().equals("=")) {
            Toast.makeText(this, "Enter an operator or Clear to start over..", Toast.LENGTH_SHORT).show();
        }

        // Adding to decimal first numbers
        else if (outputScreen.getText().toString().equals("0.")) {
            outputScreen.setText(outputScreen.getText().toString() + b.getText().toString());
        }

        // Build new number
        else if (operatorClicked) {
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
    private void hitOperator(Button b, View view) {

        // Prevent multiple operator clicks sequentially.
        if (!operatorClicked) {

            // If first number set number and operator
            if (calculator.getNum1() == null) {

                try {
                    calculator.setOperator(b.getText().toString());
                    calculator.setNum1(new BigDecimal((outputScreen.getText().toString())));
                }

                // Number backspaced, enter a number
                catch (NumberFormatException e) {
                    Toast.makeText(this, "Enter a number!!", Toast.LENGTH_SHORT).show();
                }
            }

            // If last operator was equals change operator, wait for second number
            else if (calculator.getOperator().equals("=")) {
                calculator.setOperator(b.getText().toString());
            }

            // Catching divide by zero
            else {
                if (outputScreen.getText().toString().equals("0") && calculator.getOperator().equals("/")) {
                    Toast.makeText(this, "You cannot divide by zero!!", Toast.LENGTH_SHORT).show();
                    tapClear(view);
                }

                // Calculating
                else {
                    calculator.setNum2(new BigDecimal((outputScreen.getText().toString())));
                    calculator.performOperation();
                    outputScreen.setText(String.valueOf(calculator.getNum1().stripTrailingZeros().toPlainString()));
                    calculator.setNum2(null);
                    calculator.setOperator(b.getText().toString());
                }
            }
        }

        // Sequential operators
        else {
            Toast.makeText(this, "Enter a number!!", Toast.LENGTH_SHORT).show();
        }
        operatorClicked = true;
    }
}