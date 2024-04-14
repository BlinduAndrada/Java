package org.example.components;

import org.example.game.Game;
import org.example.game.MainFrame;
import org.example.gameparts.Player;
import org.example.gameparts.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;
    private int[][] matrixPoints;
    private Game game;
    private Point[][] tableMatrix;
    private Player currentPlayer;
    private boolean valid;
    private int currentPlayerTest = 1;
    private Color[] playerColors = {Color.RED, Color.BLUE};


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // Retrieve coordinates
                int x = e.getX();
                int y = e.getY();
                System.out.println("Mouse pressed on : " + x + "," + y);

                // Draw circle at clicked point
                Graphics2D g2d = (Graphics2D) getGraphics();
                g2d.setColor(playerColors[currentPlayerTest - 1]);
                g2d.fillOval(x - 10, y - 10, 20, 20);

                // Switch to the next player
                currentPlayerTest = (currentPlayerTest % 2) + 1;
            }
        });

    }

    private void drawPlayer(Point clickedPoint, Player player, Graphics2D g){
        int coordX = padX + clickedPoint.getCol() * cellWidth;
        int coordY = padY + clickedPoint.getRow() * cellHeight;
        g.setColor(player.getColor());
        g.drawOval(coordX - stoneSize / 2, coordY - stoneSize / 2, stoneSize, stoneSize);
        g.fillOval(coordX - stoneSize / 2, coordY - stoneSize / 2, stoneSize, stoneSize);
    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        this.game = new Game(rows, cols);
        this.matrixPoints = game.getMatrixLevel();
        displayMatrix();
        this.tableMatrix=game.getMatrixPoints();
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));

    }


    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g); //paintSticks(g); //paintStones(g);
        drawLevel(g);
        Graphics2D g2d = (Graphics2D) graphics;
        takePlacedCircles(g);
    }
    private void takePlacedCircles(Graphics2D g) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrixPoints[i][j] == 2 || matrixPoints[i][j] == 3) {
                    Point temp = tableMatrix[i][j];
                    int coordX = padX + temp.getCol() * cellWidth;
                    int coordY = padY + temp.getRow() * cellHeight;
                    if (matrixPoints[i][j] == 2) {
                        g.setColor(Color.RED);
                    } else {
                        g.setColor(Color.BLUE);
                    }
                    g.drawOval(coordX - stoneSize / 2, coordY - stoneSize / 2, stoneSize, stoneSize);
                    g.fillOval(coordX - stoneSize / 2, coordY - stoneSize / 2, stoneSize, stoneSize);
                }
            }
        }
    }

    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        //vertical lines
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    public void drawLevel(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(5));
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrixPoints[i][j] == 1 && matrixPoints[i + 1][j] == 1) {
                    int x1 = padX + j * cellWidth;
                    int y1 = padY + i * cellHeight;

                    int x2 = padX + j * cellWidth;
                    int y2 = padY + (i + 1) * cellHeight;

                    g.drawLine(x1, y1, x2, y2);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {

                if (matrixPoints[i][j] == 1 && matrixPoints[i][j + 1] == 1) {
                    int x1 = padX + j * cellWidth;
                    int y1 = padY + i * cellHeight;

                    int x2 = padX + (j + 1) * cellWidth;
                    int y2 = padY + i * cellHeight;

                    g.drawLine(x1, y1, x2, y2);
                }
            }
        }

    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int[][] getMatrixPoints() {
        return matrixPoints;
    }

    public void setMatrixPoints(int[][] matrixPoints) {
        this.matrixPoints = matrixPoints;
    }

    private void displayMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrixPoints[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
