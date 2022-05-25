package slr;

import java.util.ArrayList;
import utils.*;

public class SLR {
  private double beta0;
  private double beta1;
  public void setCollection(ArrayList<DataPair> dataSet) {
    this.calculateEquation(dataSet);
  }

  public double getPrediction(double x) {
    return this.beta0 + this.beta1 * x;
  }

  private void calculateEquation(ArrayList<DataPair> dataSet) {
    double xSummation = 0;
    double ySummation = 0;
    double xSquareSummation = 0;
    double xTimesYSummation = 0;
    for (int i = 0; i < dataSet.size(); i++) {
      double x = dataSet.get(i).getX();
      double y = dataSet.get(i).getY();
      xSummation += x;
      ySummation += y;
      xSquareSummation += x * x;
      xTimesYSummation += x * y;
    }
    this.beta0 = this.calculateBeta0(dataSet.size(), xSummation, ySummation, xSquareSummation, xTimesYSummation);
    this.beta1 = this.calculateBeta1(dataSet.size(), xSummation, ySummation, xSquareSummation, xTimesYSummation);
  }

  private double calculateBeta0(double n, double xSummation, double ySummation, double xSquareSummation,
      double xTimesYSummation) {
    return (ySummation * xSquareSummation - xSummation * xTimesYSummation)
        / (n * xSquareSummation - xSummation * xSummation);
  }

  private double calculateBeta1(double n, double xSummation, double ySummation, double xSquareSummation,
      double xTimesYSummation) {
    return (n * xTimesYSummation - xSummation * ySummation) / (n * xSquareSummation - xSummation * xSummation);
  }

  public double getAlpha() {
    return this.beta0;
  }

  public double getBeta() {
    return this.beta1;
  }
}
