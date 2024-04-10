package org.example.entities;

import static org.example.entities.Constants.ROWS;
import static org.example.entities.GameState.END_DRAW;
import static org.example.entities.GameState.END_WIN;
import static org.example.entities.GameState.STARTED;

import java.util.List;

public class Game {
  private final List<Player> players;
  private final Board board;
  private int turn;
  private GameState gameState;

  public Game(GameBuilder gameBuilder) {
    this.players = gameBuilder.getPlayers();
    this.board = gameBuilder.getBoard();
    this.turn = 0;
    this.gameState = STARTED;
  }

  public void nextTurnPrompt(){
    int playerIndex = turn % players.size();
    Player player = players.get(playerIndex);

    this.board.getBoardForDisplay();
    System.out.printf("Turn : %d | Player : %s, Character : %s%n",
        turn+1, player.getName(), player.getCharacter());
  }

  public void play(String boxID){
    int playerIndex = turn % players.size();
    Player player = players.get(playerIndex);
    boolean success = this.board.markBoard(boxID, player.getCharacter());

    if (success) {
      if (this.checkWinner(player)) {
        this.gameState = END_WIN;
        System.out.printf("Game Over! %s has won!", player.getName());
        return;
      }
      this.turn++;
    }

    if (this.turn == this.board.getSize() * this.board.getSize()) {
      this.gameState = END_DRAW;
      System.out.println("Game ended in DRAW");
    }
  }

  private boolean checkWinner(Player player) {
    String c = player.getCharacter();
    StringBuilder winningLineBuilder = new StringBuilder();
    for (int i = 0; i < this.board.getSize(); i++) {
      winningLineBuilder.append(c);
    }
    String winningLine = winningLineBuilder.toString();

    for (int i = 0; i < this.board.getSize(); i++) {
      if (board.getRowAsString(String.valueOf(ROWS.charAt(i))).equals(winningLine)) {
        return true;
      }
    }

    for (int i = 0; i < this.board.getSize(); i++) {
      if (board.getColAsString(i).equals(winningLine)) {
        return true;
      }
    }

    if (board.getDiagAsString(0).equals(winningLine)) {
      return true;
    }

    if (board.getDiagAsString(1).equals(winningLine)) {
      return true;
    }

    return false;
  }

  public GameState getGameState() {
    return gameState;
  }
}
