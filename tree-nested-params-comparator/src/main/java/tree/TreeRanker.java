package tree;

import static tree.enums.CalculatingStrategy.*;
import static tree.Params.CalculatingParam.*;
import static tree.enums.SortMode.*;

import java.util.Comparator;
import java.util.List;

import general.AbstractRanker;
import tree.enums.CalculatingStrategy;
import tree.enums.SortMode;
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
	 * {@link TreeRanker#printAndReturnRank(List, ApplicableFunction)}
	 */
	@Override
	public List<String> printAndReturnRank(List<Person> persons) throws NullPointerException {
		return printAndReturnRank(persons, new ApplicableFunction(MAX, AGE));
	}

	public List<String> printAndReturnRank(List<Person> persons, ApplicableFunction function) throws NullPointerException {

		if (persons == null)
			throw new NullPointerException("the input is null instead of List");

		Comparator<? super Person> comparator = (Comparator<Person>) (o1, o2) -> o1.calculate(function)
				.subtract(o2.calculate(function)).intValue();

		List<String> result = (function.getFunction() == MIN)
				? createStringRankedList(persons, comparator, ASC)
				: createStringRankedList(persons, comparator, DESC);

		result.forEach(System.out::println);
		return result;
	}

	public List<String> printAndReturnRank(List<Person> persons, ApplicableFunction function, SortMode sortingMode)
			throws NullPointerException {

		if (persons == null)
			throw new NullPointerException("the input is null instead of List");

		Comparator<? super Person> comparator = (Comparator<Person>) (o1, o2) -> o1.calculate(function)
				.subtract(o2.calculate(function)).intValue();

		List<String> result =  createStringRankedList(persons, comparator, sortingMode);

		result.forEach(System.out::println);
		return result;
	}
}
