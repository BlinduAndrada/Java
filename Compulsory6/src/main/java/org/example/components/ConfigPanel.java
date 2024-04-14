package org.example.components;

import org.example.game.MainFrame;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinnerRows;
    JSpinner spinnerCols;

    JButton button;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     *set the graphical components of the game
     */
    public void init(){
        label= new JLabel("Grid size: ");
        spinnerRows=new JSpinner(new SpinnerNumberModel(10,2,100,1));
        spinnerCols=new JSpinner(new SpinnerNumberModel(10,2,100,1));
        button=new JButton("Create");

        add(label);
        add(spinnerCols);
        add(spinnerRows);
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //We overwrite the method from ActionEvent interface
                int gridRows = (int) spinnerRows.getValue();
                int gridColumns = (int) spinnerCols.getValue();
                frame.canvas.init(gridRows, gridColumns); // reconfigure the drawing panel
                frame.canvas.repaint(); // repaint the drawing panel
            }
        });
    }

    public int getRows(){
        return (Integer) spinnerRows.getValue();
    }

    public int getCols(){
        return (Integer) spinnerCols.getValue();
    }
}
