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
        setSize(400, 400);
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
        addButton("7", number);
        addButton("8", number);
        addButton("9", number);
        addButton("/", command);
        addButton("4", number);
        addButton("5", number);
        addButton("6", number);
        addButton("*", command);
        addButton("1", number);
        addButton("2", number);
        addButton("3", number);
        addButton("-", command);
        addButton("0", number);
        addButton(".", number);
        addButton("=", command);
        addButton("+", command);
        addButton("clear", number);

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
            if(input.equals("clear")){
                display.setText("0");
                start = false;
            } else {
                display.setText(display.getText() + input);
            }
        }
    }

    private class CommandListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            calculate(Double.parseDouble(display.getText()));
            previousCommand = command;
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
