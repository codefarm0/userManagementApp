package com.gl.userManagementApp;

public class SimpleCalculator {

    //add two numbers
    public int add(int first, int second) {
        return first + second;
    }
    //multiply two numbers
    public int multiply(int first, int second) {
        return first * second;
    }
    //subtract two numbers
    public int subtract(int first, int second) {
        return first - second;
    }
    //divide two numbers
    public int divide(int first, int second) {
       
        //only positive numbers are allowed, if not throw exception
        if(first < 0 || second < 0) {
            throw new IllegalArgumentException("Only positive numbers are allowed");
        }
        return first / second;
    }

    //log of given number
    public double log(double number) {
        //only positive numbers are allowed, if not throw exception
        if(number < 0) {
            throw new IllegalArgumentException("Only positive numbers are allowed");
        }
        return Math.log(number);
    }


}
