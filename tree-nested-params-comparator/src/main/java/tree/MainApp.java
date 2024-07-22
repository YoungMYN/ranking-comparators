package tree;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import tree.enums.CalculatingStrategy;
import tree.nodes.LastDescendant;
import tree.nodes.Person;

public class MainApp {
	public static void main(String[] args) {
		// TODO Create autotests for in non nested comparator ASC/DESC mode

		Person grand = new Person(new Params("John", 80, 180, BigDecimal.valueOf(75), true));

		Person son1 = new Person(new Params("Andrew", 55, 190, BigDecimal.valueOf(90), true));
		Person son2 = new Person(new Params("Michel", 60, 160, BigDecimal.valueOf(75), false));

		Person grandson1 = new LastDescendant(new Params("Tate", 30, 180, BigDecimal.valueOf(60), true));
		Person grandson2 = new LastDescendant(new Params("Larry", 35, 180, BigDecimal.valueOf(90), true));
		Person grandson3 = new LastDescendant(new Params("Viktor", 20, 200, BigDecimal.valueOf(100), true));

		grand.addChild(son1);
		grand.addChild(son2);

		son1.addChild(grandson1);
		son1.addChild(grandson2);

		son2.addChild(grandson3);

		System.out.println(grand.calculate(new ApplicableFunction(CalculatingStrategy.SUM, Params.CalculatingParam.AGE)));// waiting for 280
		System.out.println(grand.calculate(new ApplicableFunction(CalculatingStrategy.AVERAGE, Params.CalculatingParam.AGE)));// waiting for 47
		System.out.println(grand.calculate(new ApplicableFunction(CalculatingStrategy.MIN, Params.CalculatingParam.AGE)));// waiting for 20
		System.out.println(grand.calculate(new ApplicableFunction(CalculatingStrategy.MAX, Params.CalculatingParam.AGE)));// waiting for 80

		System.out.println(son1.calculate(new ApplicableFunction(CalculatingStrategy.MAX, Params.CalculatingParam.AGE)));
		System.out.println(son2.calculate(new ApplicableFunction(CalculatingStrategy.MAX, Params.CalculatingParam.AGE)));
		System.out.println("-----------");
		List<Person> persons = new ArrayList<>();
		persons.add(son1);
		persons.add(son2);
		new TreeRanker().printAndReturnRank(persons);

		// TODO generate testdata https://github.com/DiUS/java-faker
	}

}
