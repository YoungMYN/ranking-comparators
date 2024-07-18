package tree;

import java.math.BigDecimal;
import java.math.RoundingMode;

import tree.nodes.Person;

public class Algorithms {

	public static BigDecimal executeAlgorithmWithPerson(CalculatingStrategy algorithm, Person person,
			Params.CalculatingParam param) {
		return switch (algorithm) {
			case SUM -> sumParameters(person, param);
			case AVERAGE -> avgParam(person, param);
			case MIN -> minParam(person, param);
			case MAX -> maxParam(person, param);
		};
	}

	public static BigDecimal sumParameters(Person person, Params.CalculatingParam param) {
		BigDecimal sum = BigDecimal.valueOf(0);

		// add the value of the parameter for the person himself
		BigDecimal personsValueOfParam = validateAndCreateBigDecimal(person.getParams().getParam(param));
		sum = sum.add(personsValueOfParam);

		// add the value of the parameter for each child(recursion)
		for (Person child : person.getChildren()) {
			sum = sum.add(child.calculate(CalculatingStrategy.SUM, param));
		}
		return sum;
	}

	public static BigDecimal avgParam(Person person, Params.CalculatingParam param) {
		return sumParameters(person, param).divide(BigDecimal.valueOf(countChildren(person)), RoundingMode.HALF_UP);
	}

	public static BigDecimal minParam(Person person, Params.CalculatingParam param) {
		BigDecimal min = validateAndCreateBigDecimal(person.getParams().getParam(param));

		for (Person child : person.getChildren()) {
			BigDecimal childMinValue = child.calculate(CalculatingStrategy.MIN, param);

			if (childMinValue.compareTo(min) < 0) {
				min = childMinValue;
			}
		}
		return min;
	}

	public static BigDecimal maxParam(Person person, Params.CalculatingParam param) {
		BigDecimal max = validateAndCreateBigDecimal(person.getParams().getParam(param));

		for (Person child : person.getChildren()) {
			BigDecimal childMaxValue = child.calculate(CalculatingStrategy.MAX, param);

			if (childMaxValue.compareTo(max) > 0) {
				max = childMaxValue;
			}
		}
		return max;
	}

	public static long countChildren(Person person) {
		return person.countChildren();
	}
	/**
	 * The method analyzes the incoming parameter Number and, in case of successful
	 * validation, creates and returns a BigDecimal object similar to the passed
	 * parameter in actual value.
	 * <p>
	 * The idea that BigDecimal needs validation is taken from the discussion below:
	 * <p>
	 * <a href=
	 * "https://stackoverflow.com/questions/16216248/convert-java-number-to-bigdecimal-best-way">stackoverflow-topic</a>
	 */
	public static BigDecimal validateAndCreateBigDecimal(Number number) {
		String numberAsStr = number.toString();
		validateStringValueOfNumber(numberAsStr);

		return new BigDecimal(numberAsStr);
	}

	public static void validateStringValueOfNumber(String numberAsStr) {
		if (numberAsStr.equals("Nan") || numberAsStr.contains("Infinity")) {
			throw new IllegalArgumentException(
					"The string contains a non-numeric value and cannot be used for further operations");
		}
	}
	/*
	 * public static long countAliveChildren(Person person){ return 0; }
	 * 
	 */
}
