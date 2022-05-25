package mlr;

import utils.DataTriplet;
import java.util.ArrayList;

public class SmartCollectionDataTriplet extends SmartCollection<DataTriplet> {
  public SmartCollectionDataTriplet(ArrayList<DataTriplet> collection) {
    super(collection);
  }

  public double sumX2() {
    double result = this.aggregate((Double accum, DataTriplet current, int index) -> {
      double res = accum + current.getX2();
      return res;
    });
    return result;
  }

  public int size() {
    return this.list.size();
  }

  public double sumX1() {
    double result = this.aggregate((Double accum, DataTriplet current, int index) -> {
      double res = accum + current.getX1();
      return res;
    });
    return result;
  }

  public double sumX1X2() {
    double result = this.aggregate((Double accum, DataTriplet current, int index) -> {
      double x2 = this.list.get(index).getX2();
      double res = accum + current.getX1() * x2;
      return res;
    });
    return result;
  }

  public double sumX1Square() {
    double result = this.aggregate((Double accum, DataTriplet current, int index) -> {
      double res = accum + current.getX1() * current.getX1();
      return res;
    });
    return result;
  }

  public double sumX2Square() {
    double result = this.aggregate((Double accum, DataTriplet current, int index) -> {
      double res = accum + current.getX2() * current.getX2();
      return res;
    });
    return result;
  }

  public double sumX2Y() {
    double result = this.aggregate((Double accum, DataTriplet current, int index) -> {
      double y = this.list.get(index).getY();
      double res = accum + current.getX2() * y;
      return res;
    });
    return result;
  }

  public double sumX1Y() {
    double result = this.aggregate((Double accum, DataTriplet current, int index) -> {
      double y = this.list.get(index).getY();
      double res = accum + current.getX1() * y;
      return res;
    });
    return result;
  }

  public double sumY() {
    double result = this.aggregate((Double accum, DataTriplet current, int index) -> {
      double res = accum + current.getY();
      return res;
    });
    return result;
  }
}
