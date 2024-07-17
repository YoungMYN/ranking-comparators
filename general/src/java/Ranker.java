import java.util.List;

interface Ranker<T>{
    List<String> printAndReturnRank(List<T> units);
}
