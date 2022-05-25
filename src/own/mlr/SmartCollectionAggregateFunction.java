package mlr;

public interface SmartCollectionAggregateFunction<Type, TResult> {
  TResult aggregateFn(TResult accum, Type current, int index);
}