package org.example.entities;

import java.util.ArrayList;
import java.util.List;

public class GameBuilder implements IGameBuilder{

  private List<Player> players = new ArrayList<>();
  private Board board;

  public Game build(){
    return new Game(this);
  }

  @Override
  public GameBuilder player(Player player) {
    players.add(player);
    return this;
  }

  @Override
  public GameBuilder board(Board board) {
    this.board = board;
    return this;
  }

  public Game builder(){
    return new Game(this);
  }

  public List<Player> getPlayers() {
    return players;
  }

  public Board getBoard() {
    return board;
  }
}
