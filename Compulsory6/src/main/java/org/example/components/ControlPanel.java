package org.example.components;

import org.example.game.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import org.example.game.Game;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    private SaveGame savedGame;
    private Game game;
    JButton loadButton = new JButton("Load");
    JButton exitButton = new JButton("Exit");
    JButton saveButton = new JButton("Save");
    JButton exportBtn = new JButton("Export");


    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * we create the buttons and we add them
     */
    private void init() {
        setLayout(new GridLayout(1, 4));

        add(exitButton);
        add(loadButton);
        add(saveButton);
        add(exportBtn);

        exitButton.addActionListener(this::exitGame);
        saveButton.addActionListener(this::saveGame);
        loadButton.addActionListener(this::loadGame);
        exportBtn.addActionListener(this::exportToPNG);

    }

    /**
     *
     * @param e the action for closing the game
     */
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    /**
     * @param e the action for saving the game
     */
    private void saveGame(ActionEvent e) {
        System.out.println("Game saved");

    }

    /**
     * @param e the action for loading the game
     */
    private void loadGame(ActionEvent e) {
        System.out.println("Loading Game");
        this.savedGame = new SaveGame(this.frame.canvas.getMatrixPoints(), this.frame.canvas.getCols(), this.frame.canvas.getRows());
        this.savedGame.serialize("gameSavedData.txt");
    }

    private void exportToPNG(ActionEvent e) {
        try {
            BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();
            frame.paint(g2d);
            File outputFile = new File("gameBoard.png");
            ImageIO.write(image, "png", outputFile);
            System.out.println("Colectez");
            JOptionPane.showMessageDialog(null, "Image exported successfully to gameBoard.png", "Export Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error exporting image", "Export Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}