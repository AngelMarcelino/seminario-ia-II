package knn;
public class DataWithLabel {
  private double x;
  private double y;
  private String label;

  public DataWithLabel(double x, double y, String label) {
    this.setX(x);
    this.setY(y);
    this.setLabel(label);
  }

  public DataWithLabel(double x, double y) {
    this.setX(x);
    this.setY(y);
  }

  public DataWithLabel clone() {
    return new DataWithLabel(x, y, label);
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }
}
