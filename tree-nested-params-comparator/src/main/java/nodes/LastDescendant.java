import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class LastDescendant extends Person{
    public LastDescendant(Params p) {
        super(p);
    }

    @Override
    public BigDecimal calculate(@NonNull CalculatingStrategy strategy, @NonNull Params.CalculatingParam param) {
        return new BigDecimal(params.getParam(param).toString());
    }

    @Override
    long countChildren(){
       return 1;
    }
    @Override
    public void addChild(Person child) throws UnsupportedOperationException
    {
        throwUOE();
    }

    @Override
    public List<Person> getChildren() {
        return Collections.emptyList();//maybe it's worth returning null?
    }

    @Override
    public void setChildren(List<Person> children) throws UnsupportedOperationException
    {
        throwUOE();
    }

    private void throwUOE() throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("The object is already a leaf of the tree and cannot have an extension");
    }
}
