import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class Unit<V extends Comparable<? super V>> implements Comparable<Unit<V>>
{
    public final String name;

    @Setter
    private Map<ParamsName, V> params;

    public Unit(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Unit<V> u) {
        for(Integer priorityValue: Priority.paramsPriority.keySet()) {
            ParamsName paramName= Priority.paramsPriority.get(priorityValue);
            int delta = params.get(paramName).compareTo(u.params.get(paramName));
            if (delta!=0) return delta;
        }
        return 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
