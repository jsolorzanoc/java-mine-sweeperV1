package minesweeper;

public class Cell {

    private boolean isMine;
    private boolean isFlagged;
    private boolean isRevealed;
    private int adjacentMines; //Nearby mines

    public Cell(){ //Game start defaults no paramethers
        this.adjacentMines = 0;
        this.isFlagged = false;
        this.isMine = false;
         this.isRevealed = false;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isFlagged() {
        return isFlagged;
    }


    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void reveal(){
        this.isRevealed = true;
    }

    public void toggleFlag(){
        this.isFlagged = !this.isFlagged;
    }





}
