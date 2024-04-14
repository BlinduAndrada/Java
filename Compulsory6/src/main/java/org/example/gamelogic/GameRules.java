package org.example.gamelogic;

public class GameRules {
    private int[][] matrixPoints;
    private int rows;
    private int cols;

    // Constructor
    public GameRules(int[][] matrixPoints) {
        this.matrixPoints = matrixPoints;
        this.rows = matrixPoints.length;
        this.cols = matrixPoints[0].length;
    }

    /**
     *
     * @param row of the matrix
     * @param col of the matrix
     * @return true/false
     * it validates the move
     * checks if the point is within the matrix, if it's on a stick, if its adiacent to the last move
     */
    public boolean validateMove(int row, int col) {
        if (matrixPoints[row][col] == 1) {
            if (isOnTopEdge(row) && isOnLeftEdge(col)) {
                return isAdjacentToHorizontalStick(row, col) || isAdjacentToVerticalStick(row, col);
            } else if (isOnTopEdge(row) && isOnRightEdge(col)) {
                return isAdjacentToHorizontalStick(row, col) || isAdjacentToVerticalStick(row, col);
            } else if (isOnTopEdge(row)) {
                return isAdjacentToHorizontalStick(row, col) || isAdjacentToVerticalStick(row, col) || isAdjacentToRight(col);
            } else if (isOnBottomEdge(row) && isOnLeftEdge(col)) {
                return isAdjacentToHorizontalStick(row, col) || isAdjacentToVerticalStick(row, col);
            } else if (isOnBottomEdge(row) && isOnRightEdge(col)) {
                return isAdjacentToHorizontalStick(row, col) || isAdjacentToVerticalStick(row, col);
            } else if (isOnBottomEdge(row)) {
                return isAdjacentToHorizontalStick(row, col) || isAdjacentToVerticalStick(row, col) || isAdjacentToRight(col);
            } else if (isOnLeftEdge(col)) {
                return isAdjacentToHorizontalStick(row, col) || isAdjacentToVerticalStick(row, col) || isAdjacentToBottom(row);
            } else if (isOnRightEdge(col)) {
                return isAdjacentToHorizontalStick(row, col) || isAdjacentToVerticalStick(row, col) || isAdjacentToBottom(row);
            } else {
                return isAdjacentToHorizontalStick(row, col) || isAdjacentToVerticalStick(row, col) || isAdjacentToRight(col) || isAdjacentToBottom(row);
            }
        }
        return false;
    }

    /**
     *
     * @param row of the matrix
     * @return all 4 functions check if the point is within the limits of the matrix
     */
    private boolean isOnTopEdge(int row) {
        return row == 0;
    }

    private boolean isOnBottomEdge(int row) {
        return row == rows - 1;
    }

    private boolean isOnLeftEdge(int col) {
        return col == 0;
    }

    private boolean isOnRightEdge(int col) {
        return col == cols - 1;
    }

    /**
     *
     * @param row of the Matrix
     * @param col od the Matrix
     * @return checks if the point is on a stick
     */
    private boolean isAdjacentToHorizontalStick(int row, int col) {
        return matrixPoints[row][col + 1] == 1 || matrixPoints[row][col - 1] == 1;
    }

    private boolean isAdjacentToVerticalStick(int row, int col) {
        return matrixPoints[row + 1][col] == 1 || matrixPoints[row - 1][col] == 1;
    }

    /**
     *
     * @param col of the matrix
     * @return checks if the point to be placed is adiacent to the last move
     */
    private boolean isAdjacentToRight(int col) {
        return matrixPoints[col][cols] == 1;
    }

    private boolean isAdjacentToBottom(int row) {
        return matrixPoints[rows][row] == 1;
    }
}
