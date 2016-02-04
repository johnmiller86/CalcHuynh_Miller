package com.twh5257_jdm5908_bw.ist402.calchuynh_miller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalcActivity extends AppCompatActivity {

    private CalculationService cs;
    private TextView outputScreen;
    private Button button;

    private Double num1 = Double.NaN, num2 = Double.NaN;
    private String oper = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        cs = new CalculationService();
        outputScreen = (TextView) findViewById(R.id.textView1);

    }

    //listeners to pressed numbers
    public void tapZero(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button0);

        //display on screen
        outputScreen.setText(outputScreen.getText() + button.getText().toString());
    }

    public void tapOne(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button1);

        //display on screen
        outputScreen.setText(outputScreen.getText() + button.getText().toString());
    }

    public void tapTwo(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button2);

        //display on screen
        outputScreen.setText(outputScreen.getText() + button.getText().toString());
    }

    public void tapThree(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button3);

        //display on screen
        outputScreen.setText(outputScreen.getText() + button.getText().toString());
    }

    public void tapFour(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button4);

        //display on screen
        outputScreen.setText(outputScreen.getText() + button.getText().toString());
    }

    public void tapFive(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button5);

        //display on screen
        outputScreen.setText(outputScreen.getText() + button.getText().toString());
    }

    public void tapSix(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button6);

        //display on screen
        outputScreen.setText(outputScreen.getText() + button.getText().toString());
    }

    public void tapSeven(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button7);

        //display on screen
        outputScreen.setText(outputScreen.getText() + button.getText().toString());
    }

    public void tapEight(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button8);

        //display on screen
        outputScreen.setText(outputScreen.getText() + button.getText().toString());
    }

    public void tapNine(View view) {

        //declare button variable
        button = (Button) findViewById(R.id.button9);

        //display on screen
        outputScreen.setText(outputScreen.getText() + button.getText().toString());
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
        double number = Double.parseDouble(outputScreen.getText().toString());

        if (num1.isNaN()) {
            oper = button.getText().toString();
            num1 = number;
            outputScreen.setText("");
        } else {
            num2 = Double.parseDouble(outputScreen.getText().toString());
            num1 = performOperation(num1, num2, oper);
            outputScreen.setText(String.valueOf(num1));
            num2 = Double.NaN;
            oper = button.getText().toString();
        }
    }

    public void tapMultiply(View view) {

        button = (Button) findViewById(R.id.buttonDiv);
        double number = Double.parseDouble(outputScreen.getText().toString());

        if (num1.isNaN()) {
            oper = button.getText().toString();
            num1 = number;
            outputScreen.setText("");
        } else {
            num2 = Double.parseDouble(outputScreen.getText().toString());
            num1 = performOperation(num1, num2, oper);
            outputScreen.setText(String.valueOf(num1));
            num2 = Double.NaN;
            oper = button.getText().toString();
        }
    }

    public void tapSubtract(View view) {

        button = (Button) findViewById(R.id.buttonDiv);
        double number = Double.parseDouble(outputScreen.getText().toString());

        if (num1.isNaN()) {
            oper = button.getText().toString();
            num1 = number;
            outputScreen.setText("");
        } else {
            num2 = Double.parseDouble(outputScreen.getText().toString());
            num1 = performOperation(num1, num2, oper);
            outputScreen.setText(String.valueOf(num1));
            num2 = Double.NaN;
            oper = button.getText().toString();
        }
    }

    public void tapAdd(View view) {

        button = (Button) findViewById(R.id.buttonDiv);
        double number = Double.parseDouble(outputScreen.getText().toString());

        if (num1.isNaN()) {
            oper = button.getText().toString();
            num1 = number;
            outputScreen.setText("");
        } else {
            num2 = Double.parseDouble(outputScreen.getText().toString());
            num1 = performOperation(num1, num2, oper);
            outputScreen.setText(String.valueOf(num1));
            num2 = Double.NaN;
            oper = button.getText().toString();
        }
    }

    //click listeners to function buttons
    public void tapClear(View view) {
        outputScreen.setText("");
        cs = new CalculationService();
        num1 = Double.NaN;
        num2 = Double.NaN;
        oper = "";
    }

    public void tapBackSpace(View view) {
        String expression = outputScreen.getText().toString();
        if (!cs.isNullOrBlank(expression)) {
            expression = expression.substring(0, expression.length() - 1);
        }
        outputScreen.setText(expression);
    }

    public void tapEnter(View view) {

        if (!num1.isNaN() && !oper.equals("")) {
            num2 = Double.parseDouble(outputScreen.getText().toString());
            num1 = performOperation(num1, num2, oper);
            outputScreen.setText(String.valueOf(num1));
            num1 = Double.NaN;
            num2 = Double.NaN;
            oper = "";
        } else {
            Toast.makeText(this, "You have not entered a valid expression", Toast.LENGTH_SHORT);
        }
    }

    //method to display syntax error message to users
    private void ErrorSyntaxMessage() {
        AlertDialog alertDialog = new AlertDialog.Builder(CalcActivity.this).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage("Operator Syntax Error.  Please try check your input.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
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
            default:
                return 0.0;
        }
        return result;
    }
}
