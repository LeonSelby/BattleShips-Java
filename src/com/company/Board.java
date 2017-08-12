package com.company;

public class Board {

    private int boardRows, boardColumns;
    public int[][] boardArray;

    public Board(int size) {
        this.boardRows = size;
        this.boardColumns = size;
        this.boardArray = new int[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                boardArray[r][c] = -1;
            } //Sets two arrays to -1, size determined by BOARD_SIZE
        }
    }

    public String appendHeadings(Board board) {
        int[] numberOfColumns = new int[board.boardColumns];
        StringBuilder sb = new StringBuilder(board.boardColumns + 50);
        for (int i = 0; i < numberOfColumns.length; i++) {
            sb.append("\t");
            int tmp = i + 1;
            sb.append(tmp);
        }
        return sb.toString();
    }

    public String appendHeadings2(Board board) {
        int[] numberOfColumns = new int[board.boardColumns];
        StringBuilder sb = new StringBuilder(board.boardColumns + 50);
        for (int i = 0; i < numberOfColumns.length; i++) {
            sb.append("\t");
            int tmp = i;
            sb.append(tmp);
        }
        return sb.toString();
    }//PRINTS REAL COORDINATES



    //Getters and Setters
    public int getBoardRows() {
        return boardRows;
    }

    public int getBoardColumns() {
        return boardColumns;
    }

    public int[][] getBoardArray() {
        return boardArray;
    }

    public void setBoardArray(int[][] boardArray) {
        this.boardArray = boardArray;
    }
}
