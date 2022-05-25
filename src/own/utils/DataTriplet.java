package utils;

public class DataTriplet {
  private double x;
  private double y;
  private double z;

  public DataTriplet(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public void setX1(double x) {
    this.x = x;
  }

  public void setX2(double y) {
    this.y = y;
  }

  public void setY(double z) {
    this.z = z;
  }

  public double getX1() {
    return this.x;
  }

  public double getX2() {
    return this.y;
  }
  
  public double getY() {
    return this.z;
  }
}
