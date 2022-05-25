package mlr;

public class MatrixPrinter {
  public static void PrintMatrix(double[][] matrix) {
    int nRows = matrix.length;
    int nCols = matrix[0].length;
    for (int i = 0; i < nRows; i++) {
      String row = "";
      for (int j = 0; j < nCols; j++) {
        row += matrix[i][j] + ", ";
      }
      System.out.println(row);
    }
  }
}
