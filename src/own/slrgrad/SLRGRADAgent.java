package slrgrad;

import java.util.ArrayList;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import utils.*;
import slrgrad.*;

public class SLRGRADAgent extends Agent {
  SLRGRADGUI slrgradgui;
  SLRGRAD slrgrad;
  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    slrgrad = new SLRGRAD();
    slrgrad.setCollection(this.getDataSet());
    slrgradgui = new SLRGRADGUI(this);  
		slrgradgui.showGui();
  }

  public void makePrediction(double x) {
    addBehaviour(new OneShotBehaviour(){
      @Override
      public void action() {
        double predictedY = slrgrad.getPrediction(x);
        double alpha = slrgrad.getAlpha();
        double beta = slrgrad.getBeta();
        System.out.println("y = B_0 + (B_1)(X_1)");
        System.out.println(String.valueOf(predictedY) + " = " + String.valueOf(alpha) + " + (" + String.valueOf(beta) + ")(" + String.valueOf(x) + ")");
      }
    });
  }

  private ArrayList<DataPair> getDataSet() {
    ArrayList<DataPair> dataSet = new ArrayList<DataPair>();
    // for (int i = 1; i <= 10; i ++) {
    //   dataSet.add(new DataPair(i * 2, i));
    // }
    dataSet.add(new DataPair(23, 651));
    dataSet.add(new DataPair(26, 762));
    dataSet.add(new DataPair(30, 856));
    dataSet.add(new DataPair(34, 1063));
    dataSet.add(new DataPair(43, 1190));
    dataSet.add(new DataPair(48, 1298));
    dataSet.add(new DataPair(52, 1421));
    dataSet.add(new DataPair(57, 1440));
    dataSet.add(new DataPair(58, 1518));
    return dataSet;
  }
}
