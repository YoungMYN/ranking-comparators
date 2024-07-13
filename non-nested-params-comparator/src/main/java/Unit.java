import lombok.Getter;

import java.util.Map;


public class Unit<V extends Comparable<? super V>> implements Comparable<Unit<V>>
{
    public final String name;

    @Getter
    private Map<ParamsName, V> params;

    public Unit(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Unit<V> u) {
        for(Integer priorityValue: Priority.paramsPriority.keySet()) {
            ParamsName paramName= Priority.paramsPriority.get(priorityValue);
            if(params.get(paramName) == null || u.params.get(paramName) == null){
                continue;
            }
            int delta = params.get(paramName).compareTo(u.params.get(paramName));
            if (delta!=0) return delta;
        }
        return 0;
    }

    public void setParams(Map<ParamsName, V> params) throws NullPointerException
    {
        if(params == null) throw new NullPointerException("the input is null instead of Map");
        if(params.containsKey(null) || params.containsValue(null)) throw new NullPointerException("Null containing entry detected");

        this.params = params;
    }

    @Override
    public String toString() {
        return name;
    }
}
