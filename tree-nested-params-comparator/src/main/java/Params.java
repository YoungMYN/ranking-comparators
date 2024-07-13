import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Params {
    private String name;
    private int age;//If the person is deceased, this field indicates the maximum age the person was alive.
    private int height;
    private BigDecimal weight;
    private boolean isAlive = false;


    public Number getParam(@NonNull CalculatingParam name){
        return switch (name){
            case AGE -> age;
            case HEIGHT -> height;
            case WEIGHT -> weight;
        };
    }


    /**
     * Stores the names of a subset of parameters of the Params class - only those over which numerical calculations can be made
     */
    enum CalculatingParam{
        AGE,
        HEIGHT,
        WEIGHT
    }

}
