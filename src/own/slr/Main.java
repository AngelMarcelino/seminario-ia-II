package slr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import utils.*;

public class Main {
  public static void main(String[] args) throws IOException {
    SLR slr = new SLR();
    ArrayList<DataPair> dataSet = getHardCodedDataSet();
    slr.setCollection(dataSet);
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingresa el valor que quieres predecir: ");
    double toPredict = scanner.nextDouble();
    System.out.println(String.valueOf(slr.getPrediction(toPredict)));
    scanner.close();
  }

  private static ArrayList<DataPair> getHardCodedDataSet() {
    ArrayList<DataPair> dataSet = new ArrayList<DataPair>();
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