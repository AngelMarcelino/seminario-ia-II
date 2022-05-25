package mlr;
import java.util.ArrayList;

public class SmartCollection<Type> {
  protected ArrayList<Type> list;
  public SmartCollection(ArrayList<Type> list) {
    this.list = list;
  }

  public double aggregate(SmartCollectionAggregateFunction<Type, Double> smartCollectionAggregate) {
    double accum = 0d;
    for (int i = 0; i < list.size(); i++) {
      accum = smartCollectionAggregate.aggregateFn(accum, list.get(i), i);
    }
    return accum;
  }

  
}
