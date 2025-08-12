package com.bridgelabz.javaoperators;

class ArithmeticOperators {
    public static int addition(int a, int b) {
        return a + b;
    }
    public int subtraction(int a, int b) {
        return a - b;
    }
    protected static int multiplication(int a, int b) {
        return a * b;
    }
    private static int division(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        int a = 15;
        int b = 4;
        System.out.print("Addition :");
        System.out.println(addition(a, b)); //static method
        //or
        // System.out.println(ArithmeticOperators.addition(a, b));

        ArithmeticOperators ops = new ArithmeticOperators(); // for accessing subtraction method
        System.out.print("Subtraction :");
        System.out.println(ops.subtraction(a, b));  // instance method

        System.out.print("Multiplication :");
        System.out.println(multiplication(a, b));

        System.out.print("Division :");
        System.out.println(division(a, b));

    }
}

