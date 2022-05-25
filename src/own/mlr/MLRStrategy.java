package mlr;

import java.util.ArrayList;

import utils.DataTriplet;

public interface MLRStrategy {
  DataTriplet calculate(ArrayList<DataTriplet> data);
}
