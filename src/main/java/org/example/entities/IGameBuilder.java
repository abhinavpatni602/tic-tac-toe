package org.example.entities;

public interface IGameBuilder {
  IGameBuilder player(Player player);
  IGameBuilder board(Board board);
}
