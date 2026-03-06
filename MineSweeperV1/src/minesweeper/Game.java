package minesweeper;

import java.util.Scanner;

public class Game {
    private enum Gamestate{
        PLAYING,
        WON,
        LOST
    }

    private Board board;
    private Gamestate state;
    private Scanner scanner;

    public Game(Board board){
        this.board = board;
        this.state = Gamestate.PLAYING;
        this.scanner = new Scanner(System.in);
    }


    public void run(){
        while (state == Gamestate.PLAYING){
            board.printGrid();
            System.out.println("Player input (r-f col row): ");
            String[] input = scanner.nextLine().split(" ");
            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);
            switch (input[0]){
                case "r":
                    var winCondition = board.reveal(row, col);
                    if (winCondition){
                        state = Gamestate.LOST;
                    }
                    break;

                case "f":
                    board.toggleFlag(row,col);
                    break;
            }
            if (board.isWon()){
                state = Gamestate.WON;
            }
        }
        if (state.equals(Gamestate.WON)){
            System.out.println("YOU WON!");
        } else {
            System.out.println("YOU LOST");
        }

    }

}
