package org.example.gameparts;

import java.awt.*;

public class Player {
    private Color color;
    private String name;

    public Player(Color color, String name) {
        this.color = color;
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }
}
