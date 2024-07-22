package tree;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParamsTest {
	@Test
	public void calculatingParamIsSubsetOfParams() {
		Field[] paramsFields = Params.class.getDeclaredFields();
		List<String> namesOfAllFields = Arrays.stream(paramsFields).map(x -> x.getName().toLowerCase()).toList();

		Params.CalculatingParam[] calculatingParams = Params.CalculatingParam.values();
		List<String> namesOfCalculatingParamFields = Arrays.stream(calculatingParams).map(x -> x.name().replaceAll("_","").toLowerCase())
				.toList();

		namesOfAllFields.forEach(System.out::println);
		System.out.println("=======================");
		namesOfCalculatingParamFields.forEach(System.out::println);

		Assertions.assertTrue(namesOfAllFields.containsAll(namesOfCalculatingParamFields));
	}
}
