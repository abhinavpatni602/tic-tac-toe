package org.example.entities;

import static org.example.entities.Constants.BOARD_DEFAULT_SIZE;
import static org.example.entities.Constants.ROWS;

public class Board {
  private final int size;
  private final String[][] grid;


  public Board() {
    this.size = BOARD_DEFAULT_SIZE;
    grid = new String[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        grid[i][j] = "_";
      }
    }
  }

  public Board(int size) {
    this.size = size;
    grid = new String[size][size];

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        grid[i][j] = "_";
      }
    }
  }

  public void getBoardForDisplay(){
    for (String[] strings : grid) {
      for (int j = 0; j < strings.length; j++) {
        System.out.print(strings[j] + " ");
      }
      System.out.println();
    }
  }

  public boolean markBoard(String boxId, String character) {
    if (boxId.length() != 2) {
      System.out.println("Invalid box identifier");
      return false;
    }

    int row = ROWS.indexOf(boxId.charAt(0));
    int col = Character.getNumericValue(boxId.charAt(1)) - 1;

    if (row < 0 || row >= this.size || col < 0 || col >= this.size) {
      System.out.println("Invalid box identifier");
      return false;
    }

    if (!"_".equals(this.grid[row][col])) {
      return false;
    }

    this.grid[row][col] = character;
    return true;
  }

  public int getSize() {
    return size;
  }

  public String[][] getGrid() {
    return grid;
  }

  public String getRowAsString(String rowName) {
    int row = ROWS.indexOf(rowName);
    if (row == -1 || row >= size) {
      throw new IllegalArgumentException("Row number is invalid");
    }
    return String.join("", grid[row]);
  }

  public String getColAsString(int col) {
    if (col < 0 || col >= size) {
      throw new IllegalArgumentException("col has to be between 0 and " + (size - 1));
    }
    StringBuilder colVals = new StringBuilder();
    for (int i = 0; i < size; i++) {
      colVals.append(grid[i][col]);
    }
    return colVals.toString();
  }

  public String getDiagAsString(int diagNo) {
    StringBuilder diagVals = new StringBuilder();
    if (diagNo == 0) {
      for (int i = 0; i < size; i++) {
        diagVals.append(grid[i][i]);
      }
    } else if (diagNo == 1) {
      for (int i = 0; i < size; i++) {
        diagVals.append(grid[i][size - 1 - i]);
      }
    } else {
      throw new IllegalArgumentException("Invalid diagonal");
    }
    return diagVals.toString();
  }
}
