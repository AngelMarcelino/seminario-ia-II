package knn;

public class DataPair {
  private int x1;
  private int x2;

  public DataPair(int x1, int x2) {
    this.setX1(x1);
    this.setX2(x2);

  }

  public int getX2() {
    return x2;
  }

  public void setX2(int x2) {
    this.x2 = x2;
  }

  public int getX1() {
    return x1;
  }

  public void setX1(int x1) {
    this.x1 = x1;
  }
}