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

  /**
   * Solve the eight queen problem using backtracking algorithm.
   */
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

  /**
   * Check if the (row, col) is a valid place in the chessboard.
   * @param queens the chessboard of the existing queens.
   * @param row the row of the new placement.
   * @param col the col of the new placement.
   * @return true if the placement if valid otherwise false.s
   */
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

  /**
   * Return the string representation of the solution of the problem.
   * @return the string representation.
   */
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

