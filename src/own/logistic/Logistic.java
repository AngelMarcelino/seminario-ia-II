package logistic;

import java.util.ArrayList;

public class Logistic {
  private SigmoidCalculator sc;
  private ArrayList<DataObservation> collection;
  private double[] weights;
  private long m;
  private double learningRate;

  public Logistic(ArrayList<DataObservation> collection) {
    initializeDefaults();
    this.setCollection(collection);
  }

  public Logistic() {
    initializeDefaults();
  }

  private void initializeDefaults() {
    this.m = 100000000L;
    this.learningRate = 0.2;
    this.sc = new SigmoidCalculator();
  }

  public void setCollection(ArrayList<DataObservation> collection) {
    this.collection = collection;
    train();
  }

  public boolean makePrediction(DataObservation observation) {
    double probability = sc.calculate(observation, weights);
    System.out.println("Probability: " + probability);
    boolean prediction = sc.veredict(probability);
    return prediction;
  }

  private void train() {
    this.weights = getWeights();
  }

  private double[] getWeights() {
    double[] currentWs = createWeights(this.collection.get(0).getXForSigmoid().size());
    for (int n = 0; n < m; n++) {
      double[] newWs = new double[currentWs.length];
      for (int j = 0; j < currentWs.length; j++) {
        newWs[j] = currentWs[j] - this.learningRate * calculateSummation(currentWs, j);
      }
      currentWs = newWs;
      if (weightsMatchWithRealData(currentWs)) {
        System.out.println("Si se encontró");
        return currentWs;
      }
    }
    System.out.println("No coincidieron, se necesitan más iteraciones");
    System.out
        .println("W0: " + currentWs[0] + ", W1: " + currentWs[1] + ", W2: " + currentWs[2] + ", W3: " + currentWs[3]);
    return currentWs;
  }

  private double[] createWeights(int size) {
    double[] currentWs = new double[size];
    for (int i = 0; i < currentWs.length; i++) {
      currentWs[i] = 0;
    }
    return currentWs;
  }

  private double calculateSummation(double[] weights, int jIndex) {
    double result = 0;
    for (int i = 0; i < this.collection.size(); i++) {
      DataObservation currentObservation = this.collection.get(i);
      double calculated = sc.calculate(currentObservation, weights);
      double known = currentObservation.getVeredict() ? 1 : 0;
      double xij = currentObservation.getXForSigmoid().get(jIndex);
      double itResult = (calculated - known) * xij;
      result += itResult;
    }
    return result;
  }

  private boolean weightsMatchWithRealData(double[] weights) {
    int differences = 0;
    for (int i = 0; i < this.collection.size() && differences == 0; i++) {
      DataObservation currentObservation = this.collection.get(i);
      double probability = sc.calculate(currentObservation, weights);
      boolean caluclatedBoolean = sc.veredict(probability);
      if (caluclatedBoolean != currentObservation.getVeredict()) {
        differences++;
      }
    }
    return differences == 0;
  }
}
