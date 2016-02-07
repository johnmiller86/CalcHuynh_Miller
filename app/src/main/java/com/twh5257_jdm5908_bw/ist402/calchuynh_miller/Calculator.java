package com.twh5257_jdm5908_bw.ist402.calchuynh_miller;

/**
 * Class to model a calculator.
 *
 * @author John D. Miller
 * @version 1.0.1
 * @since 02/04/2016
 */
class Calculator {

    // Instance variables
    private Double num1, num2;
    private String operator;

    // Constructor
    public Calculator() {
        num1 = Double.NaN;
        num2 = Double.NaN;
        operator = "";
    }

    // Arguments Constructor
    public Calculator(Double num1, Double num2, String operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    /**
     * Gets the first number to be evaluated.
     *
     * @return the first number.
     */
    public Double getNum1() {
        return num1;
    }

    /**
     * Sets the first number to be evaluated.
     *
     * @param num1 the first number.
     */
    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    /**
     * Gets the second number to be evaluated.
     *
     * @return the second number.
     */
    public Double getNum2() {
        return num2;
    }

    /**
     * Sets the second number to be evaluated.
     *
     * @param num2 the second number.
     */
    public void setNum2(Double num2) {
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
     * Checks if there is a pending operation.
     *
     * @return the result.
     */
    public Double performOperation() {

        Double result = Double.NaN;

        switch (operator) {
            case "/":
                result = num1 / num2;
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
