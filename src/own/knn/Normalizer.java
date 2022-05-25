package knn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.util.Collection;

public class Normalizer {
  StatisticUtils statistics;

  public Normalizer() {
    this.statistics = new StatisticUtils();
  }

  public ArrayList<DataWithLabel> normalizeData(List<DataWithLabel> data) {
    PrintArray(data);
    List<Double> xs = data.stream().map((e) -> e.getX()).collect(Collectors.toList());
    List<Double> ys = data.stream().map((e) -> e.getY()).collect(Collectors.toList());

    double[] normalizedX = normalize(xs);
    double[] normalizedY = normalize(ys);

    ArrayList<DataWithLabel> result = new ArrayList<DataWithLabel>(data.size());
    for (int i = 0; i < data.size(); i++) {
      result.add(new DataWithLabel(normalizedX[i], normalizedY[i], data.get(i).getLabel()));
    }
    PrintArray(result);
    return result;
  }

  public double[] normalize(List<Double> toNormalize) {
    double xMean = statistics.mean(toNormalize.toArray(new Double[0]));
    double xSd = statistics.standardDeviation(toNormalize.toArray(new Double[0]));
    double[] result = new double[toNormalize.size()];
    int i = 0;
    for (Double double1 : toNormalize) {
      result[i] = (double1 - xMean) / xSd;
      i++;
    }
    return result;
  }

  private void PrintArray(Collection<DataWithLabel> data) {
    for (DataWithLabel dataWithLabel : data) {
      System.out.println("X: " + dataWithLabel.getX() + ", Y: " + dataWithLabel.getY());
    }
  }

}
