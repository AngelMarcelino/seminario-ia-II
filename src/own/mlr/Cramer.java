package mlr;

public class Cramer {

  public double[] solution(double[][] matrix) {
    int nCols = matrix[0].length;
    double[][] sMatrix = excludeCol(matrix, nCols - 1);
    MatrixPrinter.PrintMatrix(sMatrix);
    double dS = deltaS(sMatrix);
    System.out.println("dS: " + dS);
    double[][] xMatrix = excludeCol(setColumn(matrix, getColumn(matrix, nCols - 1), 0), nCols - 1);
    MatrixPrinter.PrintMatrix(xMatrix);
    double dX = deltaX(xMatrix);
    System.out.println("dX: " + dX);
    double[][] yMatrix = excludeCol(setColumn(matrix, getColumn(matrix, nCols - 1), 1), nCols - 1);
    double dY = deltaY(yMatrix);
    System.out.println("dY: " + dY);
    double[][] zMatrix = excludeCol(setColumn(matrix, getColumn(matrix, nCols - 1), 2), nCols - 1);
    double dZ = deltaZ(zMatrix);
    System.out.println("dZ: " + dZ);

    double[] result = new double[3];
    double[] d = new double[] { dX, dY, dZ };
    for (int i = 0; i < d.length; i++) {
      result[i] = d[i] / dS;
    }
    return result;
  }

  private double deltaS(double[][] matrix) {
    double diagonal = calculateDiagonals(matrix, 0, 0, false, true);
    double diagonalInverse = calculateDiagonals(matrix, 0, 2, true, true);
    return diagonal - diagonalInverse;
  }

  private double deltaX(double[][] matrix) {
    double diagonal = calculateDiagonals(matrix, 0, 0, false, false);
    double diagonalInverse = calculateDiagonals(matrix, 0, 2, true, false);
    return diagonal - diagonalInverse;
  }

  private double deltaY(double[][] matrix) {
    double diagonal = calculateDiagonals(matrix, 0, 0, false, true);
    double diagonalInverse = calculateDiagonals(matrix, 0, 2, true, true);
    return diagonal - diagonalInverse;
  }

  private double deltaZ(double[][] matrix) {
    double diagonal = calculateDiagonals(matrix, 0, 0, false, false);
    double diagonalInverse = calculateDiagonals(matrix, 0, 2, true, false);
    return diagonal - diagonalInverse;
  }

  private double calculateDiagonals(double[][] matrix, int initialI, int initialJ, boolean reverse, boolean vertical) {
    double result = 0;
    if (vertical) {
      result = verticalDiagonal(matrix, initialI, initialJ, reverse);
    } else {
      result = horizontalDiagonal(matrix, initialI, initialJ, reverse);
    }
    return result;
  }

  private double verticalDiagonal(double[][] matrix, int initialI, int initialJ, boolean reverse) {
    int nRows = getSize(matrix)[0];
    int nCols = getSize(matrix)[1];
    double diagonalSumation = 0;
    for (int i = initialI; i < nRows; i++) {
      int currentRowPointer = i;
      double multiplication = 1;
      String multiplicationSeries = "";
      int step = reverse ? -1 : 1;
      for (int j = initialJ; true; j+=step) {
        if (reverse && j < 0) {
          break;
        }
        if (!reverse && j >= nCols) {
          break;
        }
        double number = expanded(currentRowPointer, j, matrix);
        multiplicationSeries += "" + currentRowPointer + ", " + j + ": " + number + "; ";
        multiplication = number * multiplication;
        System.out.println("Multiplication: " + multiplication);
        currentRowPointer++;
      }
      System.out.println(multiplicationSeries);
      diagonalSumation += multiplication;
    }
    return diagonalSumation;
  }

  private double horizontalDiagonal(double[][] matrix, int initialI, int initialJ, boolean reverse) {
    int nRows = getSize(matrix)[0];
    int nCols = getSize(matrix)[1];
    int limit = reverse ? nCols + 2 : nCols;
    double diagonalSumation = 0;
    for (int j = initialJ; j < limit; j++) {
      int currentColPointer = j;
      double multiplication = 1;
      String multiplicationSeries = "";
      for (int i = initialI; i < nRows; i++) {
        double number = expanded(i, currentColPointer, matrix);
        multiplicationSeries += "" + i + ", " + currentColPointer + ": " + number + "; ";
        multiplication = number * multiplication;
        if (reverse) {
          currentColPointer--;
        } else {
          currentColPointer++;
        }
      }
      System.out.println(multiplicationSeries);
      diagonalSumation += multiplication;
    }
    return diagonalSumation;
  }

  private double expanded(int i, int j, double[][] matrix) {
    int nRows = getSize(matrix)[0];
    int nCols = getSize(matrix)[1];

    int realI = i % nRows;
    int realJ = j % nCols;

    return matrix[realI][realJ];
  }

  private double[][] excludeCol(double[][] matrix, int colndex) {
    int[] matrixSize = getSize(matrix);
    int nRows = matrixSize[0];
    int nCols = matrixSize[1];
    double[][] result = new double[nRows][nCols - 1];
    for (int i = 0; i < nRows; i++) {
      int resultJ = 0;
      for (int j = 0; j < nCols; j++) {
        if (colndex != j) {
          result[i][resultJ] = matrix[i][j];
          resultJ++;
        }
      }
    }
    return result;
  }

  private double[][] setColumn(double[][] matrix, double[] column, int colIndex) {
    int nRows = getSize(matrix)[0];
    int nCols = getSize(matrix)[1];
    double[][] result = new double[nRows][nCols];
    for (int i = 0; i < nRows; i++) {
      for (int j = 0; j < nCols; j++) {
        if (j == colIndex) {
          result[i][j] = column[i];
        } else {
          result[i][j] = matrix[i][j];
        }
      }
    }
    return result;
  }

  private double[] getColumn(double[][] matrix, int colIndex) {
    int nRows = getSize(matrix)[0];
    double[] result = new double[nRows];
    for (int i = 0; i < matrix.length; i++) {
      result[i] = matrix[i][colIndex];
    }
    return result;
  }

  private int[] getSize(double[][] matrix) {
    int nRows = matrix.length;
    int nCols = matrix[0].length;
    return new int[] { nRows, nCols };
  }
}
