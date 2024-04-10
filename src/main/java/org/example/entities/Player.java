package org.example.entities;

public class Player {
  private final String name;
  private final String character;

  public Player(String name, String character) {
    this.name = name;
    if ("_".equals(character)) {
      throw new Error("Underscore '_' is not a valid player character");
    }
    this.character = character;
  }

  public String getName() {
    return name;
  }

  public String getCharacter() {
    return character;
  }
}
