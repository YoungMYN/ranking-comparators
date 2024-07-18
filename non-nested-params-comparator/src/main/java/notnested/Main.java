package notnested;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		// first comparable object
		Unit unit1 = new Unit<>("unit1");

		// params of first object
		Map<ParamsName, Comparable> params1 = new HashMap<>();
		params1.put(ParamsName.PARAM1, 1);
		params1.put(ParamsName.PARAM2, 10);

		unit1.setParams(params1);

		// second comparable object
		Unit unit2 = new Unit("unit2");

		// params of second object
		Map<ParamsName, Comparable> params2 = new HashMap<>();
		params2.put(ParamsName.PARAM1, 2);
		params2.put(ParamsName.PARAM2, 10);

		unit2.setParams(params2);

		List<Unit> units = new ArrayList<>();
		units.add(unit1);
		units.add(unit2);

		// result:
		new NonNestedRanker().printAndReturnRank(units);
	}
}