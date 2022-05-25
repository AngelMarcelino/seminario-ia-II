package mlr;

import java.util.ArrayList;

import utils.DataTriplet;
import utils.MatrixOperations;

public class MLRMatrixStrategy implements MLRStrategy {
  MatrixOperations matrixOperations;

  MLRMatrixStrategy() {
    this.matrixOperations = new MatrixOperations();
  }

  @Override
  public DataTriplet calculate(ArrayList<DataTriplet> data) {
    Matrices matrices = convertIndependentToMatrix(data);
    double[][] y = getYMatrix(data);
    double[][] firstPart = matrixOperations.invert(matrixOperations.multiply(matrices.xTransposed, matrices.x));
    double[][] secondPart = matrixOperations.multiply(matrices.xTransposed, y);
    double[][] resultVector = matrixOperations.multiply(firstPart, secondPart);
    // for (int i = 0; i < resultVector.length; i++) {
    //   for (int j = 0; j < 1; j++) {
    //     System.out.print(resultVector[i][j] + ",");
    //   }
    // }
    DataTriplet dt = new DataTriplet(resultVector[0][0], resultVector[1][0], resultVector[2][0]);
    return dt;
  }

  private double[][] getYMatrix(ArrayList<DataTriplet> data) {
    double[][] result = new double[data.size()][1];
    for (int i = 0; i < data.size(); i++) {
      result[i][0] = data.get(i).getY();
    }
    return result;
  }

  private Matrices convertIndependentToMatrix(ArrayList<DataTriplet> data) {
    double[][] matrix = new double[data.size()][3];
    double[][] transposed = new double[3][data.size()];
    for (int i = 0; i < data.size(); i++) {
      matrix[i][0] = 1;
      matrix[i][1] = data.get(i).getX1();
      matrix[i][2] = data.get(i).getX2();

      transposed[0][i] = 1;
      transposed[1][i] = data.get(i).getX1();
      transposed[2][i] = data.get(i).getX2();
    }
    Matrices result = new Matrices();
    result.x = matrix;
    result.xTransposed = transposed;
    return result;
  }
}

class Matrices {
  double x[][];
  double xTransposed[][];
}
