import lombok.NonNull;

import java.math.BigDecimal;

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
    public void addChild(Person child){
        throw new UnsupportedOperationException("The object is already a leaf of the tree and cannot have an extension");
    }


}
