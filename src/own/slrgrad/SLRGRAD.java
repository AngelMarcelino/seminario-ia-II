package slrgrad;

import java.util.ArrayList;

import utils.*;

public class SLRGRAD {
  private double beta0;
  private double beta1;
  private double threshold = 1;
  private double learningRate = 0.0005;

  public void setCollection(ArrayList<DataPair> dataSet) {
    this.calculateEquation(dataSet);
  }

  public double getPrediction(double x) {
    return this.beta0 + this.beta1 * x;
  }

  private void calculateEquation(ArrayList<DataPair> dataSet) {
    double b0 = 0;
    double b1 = 0;
    int limit = 500000;
    int count = 0;
    while (true) {
      // ArrayList<DataPair> simpleErrors = calculateSimpelErrors(b0, b1, dataSet);
      double error = calculateError(b0, b1, dataSet);
      System.out.println(error);
      if (error < threshold) {
        this.beta0 = b0;
        this.beta1 = b1;
        return;
      } else {
        b0 = b0 - learningRate * derivativeB0(b0, b1, dataSet);
        b1 = b1 - learningRate * derivativeB1(b0, b1, dataSet);
      }
      if (count > limit) {
        this.beta0 = b0;
        this.beta1 = b1;
        return;
      }
      count++;
    }
  }

  private ArrayList<DataPair> calculateSimpelErrors(double b0, double b1, ArrayList<DataPair> dataSet) {
    ArrayList<DataPair> errors = new ArrayList<DataPair>();
    int n = dataSet.size();
    double sum = 0;
    for (int i = 0; i < n; i++) {
      double yi = dataSet.get(i).getY();
      double xi = dataSet.get(i).getX();
      double betaCalculation = b0 + b1 * xi;
      double error = yi - betaCalculation;
      errors.add(new DataPair(error, 0));
    }
    return errors;
  }

  private double derivativeB0(double b0, double b1, ArrayList<DataPair> dataSet) {
    int n = dataSet.size();
    double sum = 0;
    for (int i = 0; i < n; i++) {
      double yi = dataSet.get(i).getY();
      double xi = dataSet.get(i).getX();
      double betaCalculation = b0 + b1 * xi;
      double error = yi - betaCalculation;
      sum += error;
    }
    return (-2.0 / n) * sum;
  }

  private double derivativeB1(double b0, double b1, ArrayList<DataPair> dataSet) {
    int n = dataSet.size();
    double sum = 0;
    for (int i = 0; i < n; i++) {
      double yi = dataSet.get(i).getY();
      double xi = dataSet.get(i).getX();
      double betaCalculation = b0 + b1 * xi;
      double error = (yi - betaCalculation) * xi;
      sum += error;
    }
    return (-2.0 / n) * sum;
  }

  private double calculateError(double b0, double b1, ArrayList<DataPair> dataSet) {
    int n = dataSet.size();
    double sum = 0;
    for (int i = 0; i < n; i++) {
      double yi = dataSet.get(i).getY();
      double xi = dataSet.get(i).getX();
      double betaCalculation = b0 + b1 * xi;
      double error = yi - betaCalculation;
      sum += error * error;
    }
    return sum / n;
  }

  // private void calculateEquation(ArrayList<DataPair> dataSet) {
  // double xSummation = 0;
  // double ySummation = 0;
  // double xSquareSummation = 0;
  // double xTimesYSummation = 0;
  // for (int i = 0; i < dataSet.size(); i++) {
  // double x = dataSet.get(i).getX();
  // double y = dataSet.get(i).getY();
  // xSummation += x;
  // ySummation += y;
  // xSquareSummation += x * x;
  // xTimesYSummation += x * y;
  // }
  // this.beta0 = this.calculateBeta0(dataSet.size(), xSummation, ySummation,
  // xSquareSummation, xTimesYSummation);
  // this.beta1 = this.calculateBeta1(dataSet.size(), xSummation, ySummation,
  // xSquareSummation, xTimesYSummation);
  // }

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
