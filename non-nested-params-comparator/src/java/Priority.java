import java.util.Collections;
import java.util.TreeMap;

public class Priority {
    public static final TreeMap<Integer,ParamsName> paramsPriority = new TreeMap<>(Collections.reverseOrder());
    static{
        paramsPriority.put(10,ParamsName.PARAM1);
        paramsPriority.put(9,ParamsName.PARAM2);
        paramsPriority.put(8,ParamsName.PARAM3);
        paramsPriority.put(7,ParamsName.PARAM4);
        paramsPriority.put(6,ParamsName.PARAM5);
        //...
    }
}
