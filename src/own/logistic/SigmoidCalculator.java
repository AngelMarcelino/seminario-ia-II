package logistic;

import java.util.ArrayList;

public class SigmoidCalculator {
  public double calculate(DataObservation observation, double[] weights) {
    ArrayList<Double> xCollection = observation.getXForSigmoid();
    double eulerExponent = this.calculateEulerExponent(xCollection, weights);
    double eulerElevation = Math.exp(eulerExponent);
    return 1d / (1d + eulerElevation);
  }

  public double calculate(DataObservation observation, double[] weights, boolean log) {
    ArrayList<Double> xCollection = observation.getXForSigmoid();
    double eulerExponent = this.calculateEulerExponent(xCollection, weights);
    double eulerElevation = Math.exp(eulerExponent);
    
    return 1d / (1d + eulerElevation);
  }

  public boolean veredict(double probability) {
    if (probability > 0.5d) {
      return true;
    }
    return false;
  }

  private double calculateEulerExponent(ArrayList<Double> x, double[] weights) {
    double eulerExponent = 0;
    // System.out.println("Measurements: " + x.size());
    // System.out.println("Weights: " + weights.length);
    for (int i = 0; i < weights.length; i++) {
      double currentX = x.get(i);
      double currentW = weights[i];
      eulerExponent += currentW * currentX;
    }
    return eulerExponent * -1;
  }
}
