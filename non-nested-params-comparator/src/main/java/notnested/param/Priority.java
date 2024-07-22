package notnested.param;

import java.util.Collections;
import java.util.TreeMap;

/**
 * Class for setting a priority for each of the existing parameters. Determines
 * the order of sorting objects containing these parameters. The key of Map
 * {@link Priority#paramsPriority} is the priority (in my case it is represented
 * by a number of type {@link Integer}), and the value is the name of the
 * parameter. Thus, each parameter has a different priority from other
 * parameters.
 */
public class Priority {
	public static final TreeMap<Integer, ParamsName> paramsPriority = new TreeMap<>(Collections.reverseOrder());
	static {
		paramsPriority.put(10, ParamsName.PARAM1);
		paramsPriority.put(9, ParamsName.PARAM2);
		paramsPriority.put(8, ParamsName.PARAM3);
		paramsPriority.put(7, ParamsName.PARAM4);
		paramsPriority.put(6, ParamsName.PARAM5);
		// ...
	}
}
