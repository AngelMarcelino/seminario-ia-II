package logistic;

import java.util.ArrayList;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class LogisticAgent extends Agent {
  LogisticGUI mlrgui;
  Logistic logistic;

  protected void setup() {
    System.out.println("Agent " + getLocalName() + " started.");
    logistic = new Logistic();
    logistic.setCollection(this.getDataSet2());
    mlrgui = new LogisticGUI(this);
    mlrgui.showGui();
  }

  public void makePrediction(double x1, double x2, double x3) {
    addBehaviour(new OneShotBehaviour() {
      @Override
      public void action() {
        boolean predictedClass = logistic.makePrediction(new DataObservation(new double[] { x1, x2, x3 }, false));
        System.out.println(
            "Los valores " + x1 + ", " + x2 + ", " + x3 + " corresponden a la clase: " + (predictedClass ? "Verdadero" : "Falso"));
      }
    });
  }

  private ArrayList<DataObservation> getDataSet() {
    ArrayList<DataObservation> dataSet = new ArrayList<DataObservation>();
    dataSet.add(new DataObservation(new double[] { 1, 1 }, false));
    dataSet.add(new DataObservation(new double[] { 4, 2 }, true));
    dataSet.add(new DataObservation(new double[] { 2, 4 }, true));
    return dataSet;
  }

  private ArrayList<DataObservation> getDataSet2() {
    ArrayList<DataObservation> dataSet = new ArrayList<DataObservation>();
    dataSet.add(new DataObservation(new double[] { 780, 4, 3 }, true));
    dataSet.add(new DataObservation(new double[] { 750, 3.9, 4 }, true));
    dataSet.add(new DataObservation(new double[] { 690, 3.3, 3 }, false));
    dataSet.add(new DataObservation(new double[] { 710, 3.7, 5 }, true));
    dataSet.add(new DataObservation(new double[] { 680, 3.9, 4 }, false));
    dataSet.add(new DataObservation(new double[] { 730, 3.7, 6 }, true));
    dataSet.add(new DataObservation(new double[] { 690, 2.3, 1 }, false));
    dataSet.add(new DataObservation(new double[] { 720, 3.3, 4 }, true));
    dataSet.add(new DataObservation(new double[] { 740, 3.3, 5 }, true));
    return dataSet;
  }
}
