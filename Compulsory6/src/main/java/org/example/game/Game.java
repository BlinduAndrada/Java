package org.example.game;

import org.example.gameparts.Player;
import org.example.gameparts.Point;
import org.example.gameparts.RandomSticks;

import java.awt.*;

public class Game {
    private RandomSticks randomGenerator;
    private Point[][] matrixPoints;
    private int rows;
    private int cols;
    private int[][] matrixLevel;
    private Player player1;
    private Player player2;
    private boolean turn;

    public Game(int rows, int cols){
        this.cols=cols;
        this.rows=rows;
        matrixPoints=new Point[rows][cols];

        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                matrixPoints[i][j] = new Point(i,j, Color.BLACK);
            }
        }
        randomGenerator=new RandomSticks(rows,cols);
        matrixLevel=randomGenerator.getMatrixPoints();

        player1=new Player(Color.BLUE,"player1");
        player2=new Player(Color.RED,"player2");

        this.turn=false;

    }
    public int[][] getMatrixLevel() {
        return matrixLevel;
    }

    public Point[][] getMatrixPoints(){
        return matrixPoints;
    }
    public Player getPlayer1(){
        return player1;
    }
    public Player getPlayer2(){
        return player2;
    }




}
