package org.example.gameparts;

import java.awt.*;

public class Point {
    private int row;
    private int col;
    private Color colorPoint;

    public Point(int row, int col, Color colorPoint) {
        this.row = row;
        this.col = col;
        this.colorPoint = colorPoint;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    public Color getColorPoint(){
        return colorPoint;
    }


}
