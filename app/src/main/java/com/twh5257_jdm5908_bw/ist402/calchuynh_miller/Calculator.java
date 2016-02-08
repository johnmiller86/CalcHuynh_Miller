package com.twh5257_jdm5908_bw.ist402.calchuynh_miller;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Class to model a calculator.
 *
 * @author John D. Miller
 * @version 1.0.1
 * @since 02/04/2016
 */
class Calculator {

    // Instance variables
    private BigDecimal num1, num2;
    private String operator;

    // Constructor
    public Calculator() {
        num1 = null;
        num2 = null;
        operator = "";
    }

    // Arguments Constructor
    public Calculator(BigDecimal num1, BigDecimal num2, String operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    /**
     * Gets the first number to be evaluated.
     *
     * @return the first number.
     */
    public BigDecimal getNum1() {
        return num1;
    }

    /**
     * Sets the first number to be evaluated.
     *
     * @param num1 the first number.
     */
    public void setNum1(BigDecimal num1) {
        this.num1 = num1;
    }

    /**
     * Gets the second number to be evaluated.
     *
     * @return the second number.
     */
    public BigDecimal getNum2() {
        return num2;
    }

    /**
     * Sets the second number to be evaluated.
     *
     * @param num2 the second number.
     */
    public void setNum2(BigDecimal num2) {
        this.num2 = num2;
    }

    /**
     * Gets the current operator.
     *
     * @return the operator.
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets the current operator.
     *
     * @param operator the operator.
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * Performs all calculations.
     */
    public void performOperation() {

        BigDecimal result = null;

        switch (operator) {
            case "/":
                result = num1.divide(num2, RoundingMode.HALF_UP);
                break;
            case "*":
                result = num1.multiply(num2);
                break;
            case "+":
                result = num1.add(num2);
                break;
            case "-":
                result = num1.subtract(num2);
                break;
        }
        num1 = result;
    }
}
