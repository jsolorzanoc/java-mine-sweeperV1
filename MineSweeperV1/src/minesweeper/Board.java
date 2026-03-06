package minesweeper;

import java.util.Random;

public class Board {
    private Cell[][] grid; // 2d array that holds a cell object.
    private int rows;
    private int cols;
    private int mines;


    public Board(){  //Constructor overload
        this (9,9,8);
    }

    public Board(int rows, int  cols, int mines){
        this.cols = cols;
        this.rows = rows;
        this.mines = mines;
        this.grid = new Cell[cols][rows];
        this.initCells();
        this.placeMines();
        this.calculateAdjacentMines();
    }

    public void initCells(){ // Poblates cells with a new cell obj
        for (var i = 0; i < rows; i++){
            for (var j = 0; j < cols; j++){
                grid[i][j] = new Cell();
            }
        }
    }

    public void placeMines(){
        Random rand = new Random();
        int minesPlaced = 0;
        while (minesPlaced < mines){
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
            if (!grid[r][c].isMine()){
                grid[r][c].setMine(true);
                minesPlaced++;
            }
        }

    }

    public void printGrid(){
        for (var i = 0; i < rows; i++){
            for (var j = 0; j < cols; j++){
                String value =
                        !grid[i][j].isRevealed() && grid[i][j].isFlagged() ? "🚩":
                        !grid[i][j].isRevealed() ? "■ ":
                        grid[i][j].isMine() ?  "M " :
                        grid[i][j].getAdjacentMines() > 0 ?  grid[i][j].getAdjacentMines() + " " :
                                " ";

                System.out.print(value);
            }
            System.out.println();
        }
    }

    public void calculateAdjacentMines(){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){

                if (grid[i][j].isMine()) continue;

            int count = 0;

            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++){

                    if (dr == 0 && dc == 0) continue;

                    int nr = i + dr; //Vecino xy
                    int nc = j + dc; //Vecino xy

                    if (nr >= 0 && nr < rows && nc >= 0 && nc< cols){
                        if (grid[nr][nc].isMine()) count++;
                    }
                }
            }
                grid[i][j].setAdjacentMines(count);
        }

    }
    }

    public boolean reveal(int row, int col){

        if (row < 0 || row >= rows || col < 0 || col >= cols){
            return false;
        } else if (grid[row][col].isRevealed()) {
            return false;
        } else if (grid[row][col].isFlagged()) {
            return false;
        } else if (grid[row][col].isMine()) {
            return true;
        } else{
            grid[row][col].reveal();

            if (grid[row][col].getAdjacentMines() == 0){
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    reveal(row + dr, col +dc);
                }
                }
            }
        }
        return false;
    }

    public void toggleFlag(int row, int col){
        //Check bounds
        if (row < 0 || row >= rows || col < 0 || col >= cols){
            return;
        } else if (grid[row][col].isRevealed()) {
            return;
        }else {
            grid[row][col].toggleFlag();
        }
    }

    public boolean isWon(){
        for (var i = 0; i < rows; i++ ){
            for (var j = 0; j < cols; j++){
                if (!grid[i][j].isRevealed() && !grid[i][j].isMine()){
                    return false;
                }
            }
        }
        return true;
    }


}
