package com.zipcodewilmington.scientificcalculator;

import java.awt.*;

/**
 * Created by leon on 2/9/18.
 */
public class MainApplication {
    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            Window window = new Window();
            window.setTitle("Calculator");
            window.setBackground(Color.WHITE);
        });
    }
}
