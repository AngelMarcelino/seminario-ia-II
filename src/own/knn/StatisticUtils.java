package knn;

import java.util.stream.Stream;

public class StatisticUtils {
  public StatisticUtils() {

  }

  public double mean(Double[] input) {
    double[] unboxed = Stream.of(input).mapToDouble(Double::doubleValue).toArray();
    return mean(unboxed);
  }

  public double standardDeviation(Double[] input) {
    double[] unboxed = Stream.of(input).mapToDouble(Double::doubleValue).toArray();
    return standardDeviation(unboxed);
  }

  public double mean(double[] input) {
    double summation = 0;
    for (double d : input) {
      summation += d;
    }
    return summation / input.length;
  }

  public double variance(double[] input) {
    double mean = mean(input);
    double differencesOfMean = 0;
    for (double d : input) {
      differencesOfMean += Math.pow((d - mean), 2);
    }
    return differencesOfMean / input.length;
  }

  public double standardDeviation(double[] input) {
    double var = variance(input);
    double result = Math.sqrt(var);
    System.out.println("Varianza: " + var);
    System.out.println("Sd: " + result);
    return result;
  }
}
