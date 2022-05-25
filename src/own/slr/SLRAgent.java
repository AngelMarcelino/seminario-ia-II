package slr;

import java.util.ArrayList;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import utils.*;
import slr.*;

public class SLRAgent extends Agent {
  SLRGUI slrgui;
  SLR slr;
  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    slr = new SLR();
    slr.setCollection(this.getDataSet());
    slrgui = new SLRGUI(this);  
		slrgui.showGui();
  }

  public void makePrediction(double x) {
    addBehaviour(new OneShotBehaviour(){
      @Override
      public void action() {
        double predictedY = slr.getPrediction(x);
        double alpha = slr.getAlpha();
        double beta = slr.getBeta();
        System.out.println("y = B_0 + (B_1)(X_1)");
        System.out.println(String.valueOf(predictedY) + " = " + String.valueOf(alpha) + " + (" + String.valueOf(beta) + ")(" + String.valueOf(x) + ")");
      }
    });
  }

  private ArrayList<DataPair> getDataSet() {
    ArrayList<DataPair> dataSet = new ArrayList<DataPair>();
    for (int i = 1; i <= 10; i ++) {
      dataSet.add(new DataPair(i * 2, i));
    }
    return dataSet;
  }
}
