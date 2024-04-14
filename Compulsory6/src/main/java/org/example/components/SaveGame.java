package org.example.components;

import javax.swing.*;
import java.io.*;

public class SaveGame implements Serializable {
    private int[][] saveMatrix;

    private int lastX;

    private int lastY;

    public SaveGame(int[][] saveMatrix, int lastX, int lastY){
        this.saveMatrix = saveMatrix;
        this.lastX = lastX;
        this.lastY = lastY;
    }

    public int[][] getSaveMatrix() {
        return saveMatrix;
    }

    public int getLastX() {
        return lastX;
    }

    public int getLastY() {
        return lastY;
    }

    // Serialize method
    public void serialize(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this); //Scrie obiectul
            System.out.println("Game saved successfully");
            JOptionPane.showMessageDialog(null, "The Game was saved with success!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "There was an error in saving the game!");
            e.printStackTrace();
        }
    }

    public SaveGame deserialize(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            SaveGame gameData = (SaveGame) ois.readObject();
            System.out.println("Game Loaded successfully");
            JOptionPane.showMessageDialog(null, "The Game was loaded with success!");
            return gameData;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "There was an error in loading the game!");
            e.printStackTrace();
            return null;
        }
    }
}