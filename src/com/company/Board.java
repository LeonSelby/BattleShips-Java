package com.company;

public class Board {

    int m_rows, m_columns;
    public int m_tiles = m_rows*m_columns;
    public int[][] m_board;

    public Board(int size) {
        this.m_rows = size;
        this.m_columns = size;
        this.m_board = new int[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                m_board[r][c] = -1;
            } //Sets two arrays to -1, size determined by BOARD_SIZE
        }
    }



    public String appendHeadings(Board board) {
        int[] numberOfColumns = new int[board.m_columns];
        StringBuilder sb = new StringBuilder(board.m_columns + 50);
        for (int i = 0; i < numberOfColumns.length; i++) {
            sb.append("\t");
            int tmp = i + 1;
            sb.append(tmp);
        }
        return sb.toString();
    }

    public String appendHeadings2(Board board) {
        int[] numberOfColumns = new int[board.m_columns];
        StringBuilder sb = new StringBuilder(board.m_columns + 50);
        for (int i = 0; i < numberOfColumns.length; i++) {
            sb.append("\t");
            int tmp = i;
            sb.append(tmp);
        }
        return sb.toString();
    }//PRINTS REAL COORDINATES




    //Getters and Setters
    public int getM_rows() {
        return m_rows;
    }

    public int getM_columns() {
        return m_columns;
    }

    public int getM_tiles() {
        return m_tiles;
    }

    public int[][] getM_board() {
        return m_board;
    }

    public void setM_board(int[][] m_board) {
        this.m_board = m_board;
    }
}
