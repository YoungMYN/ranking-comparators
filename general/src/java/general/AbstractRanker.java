package general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractRanker<T> implements Ranker<T> {

	/**
	 * Creates a ranked list of string representations of the passed objects based
	 * on the passed comparator. If the comparator considers several objects to be
	 * equal, they will be saved in one line
	 *
	 * @param objects
	 *            The list of objects to rank.
	 * @param comparator
	 *            The comparator to use for sorting.
	 * @return A new list of strings, sorted by the comparator in descending order.
	 */
	public List<String> createStringRankedList(List<T> objects, Comparator<? super T> comparator) {

		objects.sort(comparator);
		Collections.reverse(objects);

		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < objects.size(); i++) {
			sb.append(objects.get(i).toString());
			if (i == objects.size() - 1) {
				result.add(sb.toString());
				break;
			}
			if (comparator.compare(objects.get(i), objects.get(i + 1)) == 0) {
				sb.append("\t");
			} else {
				result.add(sb.toString());
				sb.setLength(0);
			}
		}

		return result;
	}
}
