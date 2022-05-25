package mlr;

import java.util.ArrayList;
import utils.*;

public class MLR {
  private double B_0;
  private double B_1;
  private double B_2;
  MLRStrategy strategy;
  MLR(MLRStrategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(MLRStrategy strategy) {
    this.strategy = strategy;
  }
  public void setCollection(ArrayList<DataTriplet> dataSet) {
    DataTriplet t = this.strategy.calculate(dataSet);
    B_0 = t.getX1();
    B_1 = t.getX2();
    B_2 = t.getY();
  }

  public double getPrediction(double x1, double x2) {
    return this.B_0 + this.B_1 * x1 + this.B_2 * x2;
  }

  public double getB_0() {
    return this.B_0;
  }
  public double getB_1() {
    return this.B_1;
  }
  public double getB_2() {
    return this.B_2;
  }
}
