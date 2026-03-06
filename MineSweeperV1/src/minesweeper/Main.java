package minesweeper;

public class Main {
    public static void main(String[] args) {
        var cell1 = new Cell();
        var board1 = new Board();
        var game1 = new Game(board1);
        game1.run();



    }
}
