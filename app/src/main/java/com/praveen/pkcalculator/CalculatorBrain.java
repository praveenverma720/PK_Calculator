package com.praveen.pkcalculator;

/**
 * Created by PRAVEEN on 22/07/2017.
 */

class CalculatorBrain {
    // 3 + 6 = 9
    // 3 & 6 are called the operand.
    // The + is called the operator.
    // 9 is the result of the operation.
    private double mOperand;
    private double mWaitingOperand;
    private String mWaitingOperator;
    private double mCalculatorMemory;

    // operator types
    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    private static final String CLEAR = "C" ;
    private static final String CLEARMEMORY = "MC";
    private static final String ADDTOMEMORY = "M+";
    private static final String SUBTRACTFROMMEMORY = "M-";
    private static final String RECALLMEMORY = "MR";
    private static final String SQUAREROOT = "√";
    private static final String SQUARED = "x²";
    private static final String INVERT = "1/x";
    private static final String TOGGLESIGN = "+/-";
    private static final String SINE = "sin";
    private static final String COSINE = "cos";
    private static final String TANGENT = "tan";

    // public static final String EQUALS = "=";

    // constructor
    public CalculatorBrain() {
        // initialize variables upon start
        mOperand = 0;
        mWaitingOperand = 0;
        mWaitingOperator = "";
        mCalculatorMemory = 0;
    }

    public void setOperand(double operand) {
        mOperand = operand;
    }

    public double getResult() {
        return mOperand;
    }

    // used on screen orientation change
    public void setMemory(double calculatorMemory) {
        mCalculatorMemory = calculatorMemory;
    }

    // used on screen orientation change
    public double getMemory() {
        return mCalculatorMemory;
    }

    public String toString() {
        return Double.toString(mOperand);
    }

    protected double performOperation(String operator) {

        /*
        * If you are using Java 7, then you can use switch in place of if statements
        *
        *     switch (operator) {
        *     case CLEARMEMORY:
        *         calculatorMemory = 0;
        *         break;
        *     case ADDTOMEMORY:
        *         calculatorMemory = calculatorMemory + operand;
        *         break;
        *     etc...
        *     }
        */

        if (operator.equals(CLEAR)) {
            mOperand = 0;
            mWaitingOperator = "";
            mWaitingOperand = 0;
            // mCalculatorMemory = 0;
        } else if (operator.equals(CLEARMEMORY)) {
            mCalculatorMemory = 0;
        } else if (operator.equals(ADDTOMEMORY)) {
            mCalculatorMemory = mCalculatorMemory + mOperand;
        } else if (operator.equals(SUBTRACTFROMMEMORY)) {
            mCalculatorMemory = mCalculatorMemory - mOperand;
        } else if (operator.equals(RECALLMEMORY)) {
            mOperand = mCalculatorMemory;
        } else if (operator.equals(SQUAREROOT)) {
            mOperand = Math.sqrt(mOperand);

        } else if (operator.equals(SQUARED)) {
            mOperand = mOperand * mOperand;

        } else if (operator.equals(INVERT)) {
            if (mOperand != 0) {
                mOperand = 1 / mOperand;
            }
        } else if (operator.equals(TOGGLESIGN)) {
            mOperand = -mOperand;
        } else if (operator.equals(SINE)) {
            mOperand = Math.sin(Math.toRadians(mOperand)); // Math.toRadians(mOperand) converts result to degrees
        } else if (operator.equals(COSINE)) {
            mOperand = Math.cos(Math.toRadians(mOperand)); // Math.toRadians(mOperand) converts result to degrees
        } else if (operator.equals(TANGENT)) {
            mOperand = Math.tan(Math.toRadians(mOperand)); // Math.toRadians(mOperand) converts result to degrees
        } else {
            performWaitingOperation();
            mWaitingOperator = operator;
            mWaitingOperand = mOperand;
        }

        return mOperand;
    }

    protected void performWaitingOperation() {

        if (mWaitingOperator.equals(ADD)) {
            mOperand = mWaitingOperand + mOperand;
        } else if (mWaitingOperator.equals(SUBTRACT)) {
            mOperand = mWaitingOperand - mOperand;
        } else if (mWaitingOperator.equals(MULTIPLY)) {
            mOperand = mWaitingOperand * mOperand;
        } else if (mWaitingOperator.equals(DIVIDE)) {
            if (mOperand != 0) {
                mOperand = mWaitingOperand / mOperand;
            }
        }

    }
}