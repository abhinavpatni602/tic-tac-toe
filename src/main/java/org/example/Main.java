package org.example;

import java.util.Scanner;
import org.example.entities.Board;
import org.example.entities.Game;
import org.example.entities.GameState;
import org.example.entities.Player;

public class Main {
  public static void main(String[] args) {
    Game game = new org.example.entities.GameBuilder()
        .player(new Player("Abhinav", "X"))
        .player(new Player("Ankita", "O"))
        .player(new Player("Jugs","J"))
        .board(new Board(5))
        .build();

    while (game.getGameState().equals(GameState.STARTED)) {
      game.nextTurnPrompt();
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter Box: ");
      String box = scanner.nextLine();
      game.play(box);
    }
  }
}