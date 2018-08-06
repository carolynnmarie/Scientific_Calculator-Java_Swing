package com.zipcodewilmington.scientificcalculator;

public class Calculator {

    double previousResult;

    public Calculator(double previousResult){
        this.previousResult = previousResult;
    }

    public double calculate(String command, double displayInput){
        return (command.equals("+"))? add(displayInput):
                (command.equals("-"))? subtract(displayInput):
                (command.equals("\u00D7"))? multiply(displayInput):
                (command.equals("\u00F7"))? divide(displayInput):
                (command.equals("x\u02b8"))? powerOf(displayInput):
                (command.equals("\u00B1"))? switchSign():
                (command.equals("%"))? percent():
                (command.equals("clear"))?0.0:
                (command.equals("sin"))? sin(displayInput):
                (command.equals("cos"))? cos(displayInput):
                (command.equals("x\u00B2"))? squared(displayInput):
                (command.equals("\u221A"))? sqrt(displayInput):
                (command.equals("log"))? log(displayInput):
                displayInput;
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

    public double switchSign(){
        if(previousResult<0){
            previousResult = Math.abs(previousResult);
        } else {
            previousResult = 0 - previousResult;
        }
        return previousResult;
    }

    public double percent(){
        return previousResult/100;
    }

    public double powerOf(double displayInput){
        return Math.pow(previousResult,displayInput);
    }

    public double sin(double displayInput){
        return Math.sin(displayInput);
    }

    public double cos(double displayInput){
        return Math.cos(displayInput);
    }

    public double sqrt(double displayInput){
        return Math.sqrt(displayInput);
    }

    public double squared(double displayInput){
        return displayInput * displayInput;
    }

    public double log(double displayInput){
        return Math.log10(displayInput);}
}
