
public class SomeUniqueParam implements Comparable<SomeUniqueParam>{
    private final int variable;

    public SomeUniqueParam(int variable) {
        this.variable = variable;
    }

    @Override
    public int compareTo(SomeUniqueParam s) {
        return this.variable-s.variable;
    }

    @Override
    public String toString() {
        return "SomeUniqueParam{" +
                "variable=" + variable +
                '}';
    }
}
