package tree.nodes;

import java.util.Collections;
import java.util.List;

import tree.Params;

public class LastDescendant extends Person {
	public LastDescendant(Params p) {
		super(p);
	}

	@Override
	public void addChild(Person child) throws UnsupportedOperationException {
		throwUOE();
	}

	@Override
	public List<Person> getChildren() {
		return Collections.emptyList();
	}

	@Override
	public void setChildren(List<Person> children) throws UnsupportedOperationException {
		throwUOE();
	}

	private void throwUOE() throws UnsupportedOperationException {
		throw new UnsupportedOperationException(
				"The object is already a leaf of the tree and cannot have an extension");
	}
}
