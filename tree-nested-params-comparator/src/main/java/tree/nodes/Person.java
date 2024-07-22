package tree.nodes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import tree.Algorithms;
import tree.ApplicableFunction;
import tree.Params;
import tree.interfaces.MultiCalculable;

@Data
public class Person implements MultiCalculable {
	protected Params params;
	@Getter
	@Setter
	private List<Person> children = new ArrayList<>();

	public Person(Params p) {
		params = p;
	}

	/**
	 * The method delegates the execution of the calculation method to the
	 * {@link Algorithms} class by passing the parameters of the calculation itself
	 * further.
	 *
	 * @return the result of the algorithm execution in the {@link Algorithms} class
	 */
	@Override
	public BigDecimal calculate(@NonNull ApplicableFunction function) {
		return Algorithms.executeAlgorithmWithPerson(this, function);
	}

	public void addChild(Person child) {
		children.add(child);
	}

	public long countChildren() {
		long c = 1;// including current nodes.Person
		for (Person child : this.getChildren()) {
			c += child.countChildren();
		}
		return c;
	}

}
