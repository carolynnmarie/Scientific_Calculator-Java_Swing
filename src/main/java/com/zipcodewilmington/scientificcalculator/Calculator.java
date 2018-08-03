package com.zipcodewilmington.scientificcalculator;

public class Calculator {

    double previousResult;

    public Calculator(double previousResult){
        this.previousResult = previousResult;
    }

    public double calculate(String command, double displayInput){
        return (command.equals("+"))? add(displayInput): (command.equals("-"))?subtract(displayInput): (command.equals("\u00D7"))?multiply(displayInput):
                (command.equals("\u00F7"))? divide(displayInput):(command.equals("clear"))?0.0: displayInput;
    }

    public double add(double displayInput){
        return previousResult + displayInput;
    }

    public double subtract(double displayInput){
        return previousResult - displayInput;
    }

    public double multiply(double displayInput){
        return previousResult * displayInput;
    }

    public double divide(double displayInput){
        return previousResult / displayInput;
    }

//    public double switchSign(){
//
//    }
//
//    public double percent(){
//
//    }
//
//    public double squared(){
//
//    }

}
//    public void calculate(double x){
//        if(previousCommand.equals("+")){ result += x;}
//        else if(previousCommand.equals("-")){ result -= x;}
//        else if(previousCommand.equals("*")) {result *= x;}
//        else if(previousCommand.equals("/")) {
//            double temp = result;
//            result = temp / x;
//        }
//        else if(previousCommand.equals("=")) result = x;
//        display.setText("" + result);