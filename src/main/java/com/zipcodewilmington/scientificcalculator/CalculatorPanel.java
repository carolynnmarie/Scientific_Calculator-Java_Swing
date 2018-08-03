package com.zipcodewilmington.scientificcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel {

    private JButton display;
    private JPanel panel;
    private Double result;
    private String previousCommand;
    private boolean start;

    public CalculatorPanel() {
        setSize(350,350);
        setVisible(true);
        setLayout(new BorderLayout());

        this.result = 0.0;
        this.previousCommand = "=";
        this.start = true;
        display = new JButton("0");
        display.setEnabled(false);
        add(display,BorderLayout.NORTH);
        ActionListener number = new NumberListener();
        ActionListener command = new CommandListener();

        panel = new JPanel();
        panel.setLayout(new GridLayout(5,4));
        addButton("clear", command);
        addButton("\u00B1", command); //switchSign
        addButton("%", command);
        addButton("x\u02b8", command); //powerOf

        addButton("7", number);
        addButton("8", number);
        addButton("9", number);
        addButton("\u00F7", command);

        addButton("4", number);
        addButton("5", number);
        addButton("6", number);
        addButton("\u00D7", command);

        addButton("1", number);
        addButton("2", number);
        addButton("3", number);
        addButton("-", command);

        addButton("0", number);
        addButton(".", number);
        addButton("=", command);
        addButton("+", command);


        add(panel,BorderLayout.CENTER);
    }

    private void addButton(String text, ActionListener listener){
        JButton button = new JButton(text);
        button.addActionListener(listener);
        panel.add(button);
    }


    private class NumberListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String input = e.getActionCommand();
            if(start){
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }

    private class CommandListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            Calculator calculator = new Calculator(result);
            double displayInput = Double.parseDouble(display.getText());
            if(command.equals("clear")|| command.equals("%") || command.equals("\u00B1")){
                result = calculator.calculate(command,displayInput);
            }
            else {
                result = calculator.calculate(previousCommand, displayInput);
                previousCommand = command;
            }
            display.setText("" + result);
            start = true;
            }
        }

    public void calculate(double x){
        if(previousCommand.equals("+")){ result += x;}
        else if(previousCommand.equals("-")){ result -= x;}
        else if(previousCommand.equals("*")) {result *= x;}
        else if(previousCommand.equals("/")) {
            double temp = result;
            result = temp / x;
        }
        else if(previousCommand.equals("=")) result = x;
        display.setText("" + result);
    }

}
