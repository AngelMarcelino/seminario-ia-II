package knn;

import java.util.ArrayList;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class KNNAgent extends Agent {
  KNNGUI mlrgui;
  KNN knn;

  protected void setup() {
    System.out.println("Agent " + getLocalName() + " started.");
    knn = new KNN();
    knn.setCollection(this.getDataSet());
    mlrgui = new KNNGUI(this);
    mlrgui.showGui();
  }

  public void makePrediction(double x1, double x2, int k) {
    addBehaviour(new OneShotBehaviour() {
      @Override
      public void action() {
        knn.setK(k);
        String predictedClass = knn.makePrediction(x1, x2);
        System.out.println("Los valores " + x1 + ", " + x2 + " corresponden a la clase: " + predictedClass);
      }
    });
  }

  private ArrayList<DataWithLabel> getDataSet() {
    Normalizer normalizer = new Normalizer();
    ArrayList<DataWithLabel> dataSet = new ArrayList<DataWithLabel>();
    dataSet.add(new DataWithLabel(5.3, 3.7, "Setosa"));
    dataSet.add(new DataWithLabel(5.1, 3.8, "Setosa"));
    dataSet.add(new DataWithLabel(7.2, 3.0, "Virginica"));
    dataSet.add(new DataWithLabel(5.4, 3.4, "Setosa"));
    dataSet.add(new DataWithLabel(5.1, 3.3, "Setosa"));
    dataSet.add(new DataWithLabel(5.4, 3.9, "Setosa"));
    dataSet.add(new DataWithLabel(7.4, 2.8, "Virginica"));
    dataSet.add(new DataWithLabel(6.1, 2.8, "Verscicolor"));
    dataSet.add(new DataWithLabel(7.3, 2.9, "Virginica"));
    dataSet.add(new DataWithLabel(6.0, 2.7, "Verscicolor"));
    dataSet.add(new DataWithLabel(5.8, 2.8, "Virginica"));
    dataSet.add(new DataWithLabel(6.3, 2.3, "Verscicolor"));
    dataSet.add(new DataWithLabel(5.1, 2.5, "Verscicolor"));
    dataSet.add(new DataWithLabel(6.3, 2.5, "Verscicolor"));
    dataSet.add(new DataWithLabel(5.5, 2.4, "Verscicolor"));
    return dataSet;
  }

}
