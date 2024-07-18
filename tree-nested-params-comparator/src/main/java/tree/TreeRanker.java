package tree;

import java.util.Comparator;
import java.util.List;

import general.AbstractRanker;
import tree.nodes.Person;

public class TreeRanker extends AbstractRanker<Person> {
	/**
	 * The method makes a comparison by default: with the
	 * {@link CalculatingStrategy#MAX} mod and the
	 * {@link Params.CalculatingParam#AGE} parameter, that is, it sorts everyone by
	 * {@link Params.CalculatingParam#AGE age} DESC.
	 * <p>
	 * If you want to configure the comparison parameters, refer to the overloaded
	 * version of the method -
	 * {@link TreeRanker#printAndReturnRank(List,CalculatingStrategy, Params.CalculatingParam)}
	 */
	@Override
	public List<String> printAndReturnRank(List<Person> persons) throws NullPointerException {
		return printAndReturnRank(persons, CalculatingStrategy.MAX, Params.CalculatingParam.AGE);
	}

	public List<String> printAndReturnRank(List<Person> persons, CalculatingStrategy strategy,
			Params.CalculatingParam param) throws NullPointerException {

		if (persons == null)
			throw new NullPointerException("the input is null instead of List");

		Comparator<? super Person> comparator = (Comparator<Person>) (o1, o2) -> o1.calculate(strategy, param)
				.subtract(o2.calculate(strategy, param)).intValue();

		List<String> result = createStringRankedList(persons, comparator);
		result.forEach(System.out::println);

		return result;
	}
}
