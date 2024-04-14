package org.example.gameparts;

import java.util.Random;

public class RandomSticks {
    private int rows;
    private int cols;
    private int sticks;
    private int [][] matrixPoints;
    private int numberSticks;

    public RandomSticks(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.matrixPoints = new int[rows][cols]; //initialize matrix
        Random randomizer = new Random();
        this.sticks = countSticks();

        double percentage;

        percentage = randomizer.nextDouble(0.2,0.8);

        System.out.println(percentage);

        this.numberSticks = (int) (sticks * percentage);

        System.out.println(numberSticks);

        generateMatrix();
    }

    private int countSticks(){ //Numara bete
        int sticksNumber = 0;


        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols - 1; col++) {
                if ((matrixPoints[row][col] == 0) && (matrixPoints[row][col + 1] == 0)) {
                    sticksNumber++;
                }
            }
        }
        int horizontalSticksNumber = sticksNumber;
        System.out.println("Number of horizontal sticks: " + horizontalSticksNumber);

        sticksNumber = 0;

        for (int col = 0; col < this.cols; col++) {
            for (int row = 0; row < this.rows - 1; row++) {
                if (matrixPoints[row][col] == 0 && matrixPoints[row + 1][col] == 0) {
                    sticksNumber++;
                }
            }
        }
        int verticalSticksNumber = sticksNumber;

        System.out.println("Number of vertical sticks: " + verticalSticksNumber);

        sticksNumber = horizontalSticksNumber + verticalSticksNumber;
        System.out.println("Total sticks number: " + sticksNumber);
        return sticksNumber;
    }

    private void generateMatrix(){ //Se genereaza
        Random generator = new Random();
        for(int i = 0; i < numberSticks; i++){
            int x1,x2,y1,y2;
            x1 = generator.nextInt(0,rows);
            x2 = generator.nextInt(0,rows);
            y1 = generator.nextInt(0,cols);
            y2 = generator.nextInt(0,cols);

            while(x1 == x2 && y1 == y2){
                x1 = generator.nextInt(0,rows);
                x2 = generator.nextInt(0,rows);
                y1 = generator.nextInt(0,cols);
                y2 = generator.nextInt(0,cols);
            }

            matrixPoints[x1][y1] = 1;
            matrixPoints[x2][y2] = 1;

        }
    }

    public int[][] getMatrixPoints() {
        return matrixPoints;
    }
}
