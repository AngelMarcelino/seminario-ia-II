package examples.behaviours;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class CyclicAgent extends Agent {

  protected void setup() {
    System.out.println("Agent " + getLocalName() + " started.");
    addBehaviour(new MyCyclicBehaviour("1"));
    addBehaviour(new MyCyclicBehaviour("2"));
  }

  private class MyCyclicBehaviour extends CyclicBehaviour {
    String param;

    public MyCyclicBehaviour(String param) {
      this.param = param;
    }

    public void action() {
      System.out.println("Agent's " + this.param + " action method is executed");
    }

    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    }
  } // END of inner class ...Behaviour
}
