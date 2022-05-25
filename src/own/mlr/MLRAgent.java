package mlr;

import java.util.ArrayList;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import utils.*;

public class MLRAgent extends Agent {
  MLRGUI mlrgui;
  MLR mlr;
  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    mlr = new MLR(new MLRCramerStrategy());
    mlr.setCollection(this.getDataSet());
    mlrgui = new MLRGUI(this);  
		mlrgui.showGui();
  }

  public void makePrediction(double x1, double x2) {
    addBehaviour(new OneShotBehaviour(){
      @Override
      public void action() {
        double predictedY = mlr.getPrediction(x1, x2);
        double b_0 = mlr.getB_0();
        double b_1 = mlr.getB_1();
        double b_2 = mlr.getB_2();
        System.out.println("y = B_0 + (B_1)(X_1) + (B_2)(X_2)");
        System.out.println(String.valueOf(predictedY) + " = " + String.valueOf(b_0) + " + (" + String.valueOf(b_1) + ")(" + String.valueOf(x1) + ")" + " + (" + String.valueOf(b_2) + ")(" + String.valueOf(x2) + ")");
      }
    });
  }

  private ArrayList<DataTriplet> getDataSet() {
    ArrayList<DataTriplet> dataSet = new ArrayList<DataTriplet>();
    dataSet.add(new DataTriplet(41.9, 29.1, 251.3));
    dataSet.add(new DataTriplet(43.4, 29.3, 251.3));
    dataSet.add(new DataTriplet(43.9, 29.5, 248.3));
    dataSet.add(new DataTriplet(44.5, 29.7, 267.5));
    dataSet.add(new DataTriplet(47.3, 29.9, 273));
    dataSet.add(new DataTriplet(47.5, 30.3, 276.5));
    dataSet.add(new DataTriplet(47.9, 30.5, 270.3));
    dataSet.add(new DataTriplet(50.2, 30.7, 274.9));
    dataSet.add(new DataTriplet(52.8, 30.8, 285));
    dataSet.add(new DataTriplet(53.2, 30.9, 290));
    dataSet.add(new DataTriplet(56.7, 31.5, 297));
    dataSet.add(new DataTriplet(57.0, 31.7, 302.5));
    dataSet.add(new DataTriplet(63.5, 31.9, 304.5));
    dataSet.add(new DataTriplet(63.3, 32.0, 309.3));
    dataSet.add(new DataTriplet(71.1, 32.1, 321.7));
    dataSet.add(new DataTriplet(77.0, 32.5, 330.7));
    dataSet.add(new DataTriplet(77.8, 32.9, 349.0));
    
    return dataSet;
  }
}
