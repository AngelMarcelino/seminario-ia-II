package logistic;

import java.util.ArrayList;

public class DataObservation {
  private ArrayList<Double> xEntries;
  private ArrayList<Double> xEntriesPlusOne;
  private boolean result;

  public DataObservation(double[] x, boolean result) {
    this.setX(x);
    this.result = result;
  }

  private void setX(double[] x) {
    this.xEntries = new ArrayList<>();
    this.xEntriesPlusOne = new ArrayList<>();
    this.xEntriesPlusOne.add(1d);
    for (int i = 0; i < x.length; i++) {
      this.xEntries.add(x[i]);
      this.xEntriesPlusOne.add(x[i]);
    }
  }

  public ArrayList<Double> getX() {
    return this.xEntries;
  }
  public ArrayList<Double> getXForSigmoid() {
    return this.xEntriesPlusOne;
  }

  public boolean getVeredict() {
    return result;
  }
}
