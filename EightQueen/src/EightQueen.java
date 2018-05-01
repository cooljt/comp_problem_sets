/**
 * An Eight Queen Problem Solution.
 */
public class EightQueen {
  private int[] queens;

  /**
   * Construct an eight queen object.
   */
  public EightQueen() {
    queens = new int[8];
    for (int i = 0; i < queens.length; i++) {
      queens[i] = -1;
    }
  }

  public void solve() {
    int current_row = 0;
    int col;
    while (current_row >= 0 && current_row < queens.length) {
      col = queens[current_row] + 1;
      while (col < queens.length && !safe(queens, current_row, col)) {
        col = col + 1;
      }

      if (col < queens.length) {
        queens[current_row] = col;
        current_row = current_row + 1;
      }else {
        queens[current_row] = -1;
        current_row = current_row - 1;
      }
    }
  }

  public boolean safe(int[] queens, int row, int col) {
    if (col < 0) {
      return false;
    }

    for (int i = 0; i < row; i++) {
      if (queens[i] == col) {
        return false;
      }
    }

    for (int i = 0; i < row; i++) {
      if (Math.abs(i - row) == Math.abs(queens[i] - col)) {
        return false;
      }
    }
    return true;
  }

  public String toString() {
    StringBuilder board = new StringBuilder();
    for (int i = 0; i < queens.length; i++) {
      for (int j = 0; j < queens.length; j++) {
        if (queens[i] == j) {
          board.append("Q");
        }
        else {
          board.append("*");
        }
      }
      board.append("\n");
    }
    return board.toString();
  }
}

