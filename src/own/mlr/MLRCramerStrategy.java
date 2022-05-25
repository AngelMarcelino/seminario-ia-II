package mlr;

import java.util.ArrayList;

import utils.DataTriplet;

public class MLRCramerStrategy implements MLRStrategy {
  SmartCollectionDataTriplet sc;
  Cramer cramerSolver;

  public MLRCramerStrategy() {
    this.cramerSolver = new Cramer();
  }

  @Override
  public DataTriplet calculate(ArrayList<DataTriplet> data) {
    this.sc = new SmartCollectionDataTriplet(data);
    double[][] matrix = new double[][] { { sc.sumX2(), sc.sumX1X2(), sc.sumX2Square(), sc.sumX2Y() },
        { sc.sumX1(), sc.sumX1Square(), sc.sumX1X2(), sc.sumX1Y() },
        { sc.size(), sc.sumX1(), sc.sumX2(), sc.sumY() } };
    System.out.println("Last");
    System.out.println(sc.sumX2Y());
    System.out.println(sc.sumX1Y());
    System.out.println(sc.sumY());
    double[] solutionArray = cramerSolver
        .solution(matrix);

    System.out.println("Matrix");
    MatrixPrinter.PrintMatrix(matrix);
    DataTriplet dt = new DataTriplet(solutionArray[0], solutionArray[1], solutionArray[2]);
    System.out.println("x: " + solutionArray[0] + ", y: " + solutionArray[1] + ", z: " + solutionArray[2]);
    return dt;
  }

}
