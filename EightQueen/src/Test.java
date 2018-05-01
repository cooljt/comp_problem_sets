public class Test {
  public static void main(String[] args) {
    EightQueen solver = new EightQueen();
    solver.solve();
    System.out.println(solver.toString());
  }
}
