import interfaces.MultiCalculable;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Person implements MultiCalculable {
    protected Params params;
    @Getter
    @Setter
    private List<Person> children = new ArrayList<>();

    public Person(Params p){
        params = p;
    }

    @Override
    public BigDecimal calculate(@NonNull CalculatingStrategy strategy, @NonNull Params.CalculatingParam param) {
        return switch (strategy){
            case SUM -> Algorithm.sumParameters(this, param);
            case AVERAGE -> Algorithm.avgParam(this, param);
            case MIN -> Algorithm.minParam(this, param);
            case MAX -> Algorithm.maxParam(this, param);
        };
    }

    public void addChild(Person child){
        children.add(child);
    }
    long countChildren(){
        long c = 1;//including current nodes.Person
        for (Person child: children) {
            c+=child.countChildren();
        }
        return c;
    }

}