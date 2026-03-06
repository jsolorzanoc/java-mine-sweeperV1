package minesweeper;

public class Main {
    public static void main(String[] args) {
        var cell1 = new Cell();
        var board1 = new Board();
        board1.initCells();
        board1.placeMines();
        board1.calculateAdjacentMines();
        board1.toggleFlag(4, 8);
        board1.reveal(4,4);
        board1.printGrid();

    }
}
