package general;

import java.util.List;

interface Ranker<T> {
	/**
	 * Creates, prints and returns a ranked list of string representations of passed objects.
	 *
	 *
	 * @param objects The list of objects to rank
	 * @return list of strings
	 */
	List<String> printAndReturnRank(List<T> objects);
}
