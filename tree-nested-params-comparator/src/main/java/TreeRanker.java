import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TreeRanker implements Ranker<Person> {
    /**
     * The method makes a comparison by default: with the {@link CalculatingStrategy#MAX} mod and the {@link Params.CalculatingParam#AGE} parameter, that is, it sorts everyone by {@link Params.CalculatingParam#AGE age} DESC.
     * <p>
     * If you want to configure the comparison parameters, refer to the overloaded version of the method - {@link TreeRanker#printAndReturnRank(List,CalculatingStrategy, Params.CalculatingParam)}
     */
    @Override
    public List<String> printAndReturnRank(List<Person> persons) throws NullPointerException {
        return printAndReturnRank(persons, CalculatingStrategy.MAX, Params.CalculatingParam.AGE);
    }

    public List<String> printAndReturnRank(List<Person> persons, CalculatingStrategy strategy, Params.CalculatingParam param) throws NullPointerException {
        if (persons == null) throw new NullPointerException("the input is null instead of List");

        Comparator<? super Person> comparator = (Comparator<Person>) (o1, o2) -> o1.calculate(strategy, param)
                .subtract(o2.calculate(strategy, param))
                .intValue();

        persons.sort(comparator);
        Collections.reverse(persons);

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < persons.size(); i++) {
            sb.append(persons.get(i).toString());
            if(i == persons.size()-1) {
                result.add(sb.toString());
                break;
            }
            if(comparator.compare(persons.get(i),persons.get(i+1)) == 0){
                sb.append("\t");
            }
            else{
                result.add(sb.toString());
                sb.setLength(0);
            }
        }

        result.forEach(System.out::println);

        return result;
    }
}
