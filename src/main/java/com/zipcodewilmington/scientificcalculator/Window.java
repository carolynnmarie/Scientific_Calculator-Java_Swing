package com.zipcodewilmington.scientificcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Window extends JFrame {


    private JButton display;
    private JPanel calculatorPanel;
    private JLabel jLabel;


    public Window(){
        setSize(425, 425);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(null);

        this.jLabel = new JLabel();
        jLabel.setVisible(true);
        jLabel.setBackground(Color.WHITE);


        this.calculatorPanel = new CalculatorPanel();
        calculatorPanel.setBounds(25,25, 350, 350);

        Container container = getContentPane();
        container.add(jLabel);
        container.add(calculatorPanel);
        container.setVisible(true);
        jLabel.setVisible(true);
        calculatorPanel.setVisible(true);

    }

}







