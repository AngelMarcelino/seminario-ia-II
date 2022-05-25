package knn;

public class DistanceCalculator {
  public double euclideanDistance(DataWithLabel from, DataWithLabel to) {
    double squareX = Math.pow(from.getX() - to.getX(), 2);
    double squareY = Math.pow(from.getY() - to.getY(), 2);
    double result = Math.sqrt(squareX + squareY);
    return result;
  }
}
