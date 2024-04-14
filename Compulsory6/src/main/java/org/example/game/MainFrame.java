package org.example.game;

import org.example.components.ConfigPanel;
import org.example.components.ControlPanel;
import org.example.components.DrawingPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public ConfigPanel configPanel;
    ControlPanel controlPanel;
    public DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    /**
     * we made all the components of the game
     * we add them in the right part of the interface
     */
    public void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);

        add(configPanel, BorderLayout.NORTH);
        add(canvas,BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH);

        pack();

        setVisible(true);
    }
}