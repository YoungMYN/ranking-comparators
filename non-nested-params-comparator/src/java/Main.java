import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Unit unit1 = new Unit<>("unit1");


        Map<ParamsName, Comparable> params1 = new HashMap<>();
        params1.put(ParamsName.PARAM1, 1);
        params1.put(ParamsName.PARAM2, 10);
        params1.put(ParamsName.PARAM3, "ABC");
        params1.put(ParamsName.PARAM4, new SomeUniqueParam(3));

        unit1.setParams(params1);

//----------------------------------------------------
        Unit unit2 = new Unit("unit2");

        Map<ParamsName, Comparable> params2 = new HashMap<>();
        params2.put(ParamsName.PARAM1, 1);
        params2.put(ParamsName.PARAM2, 10);
        params2.put(ParamsName.PARAM3, "ABC");
        params2.put(ParamsName.PARAM4, new SomeUniqueParam(4));

        unit2.setParams(params2);
//----------------------------------------------------
        Unit unit3 = new Unit("unit3");

        Map<ParamsName, Comparable> params3 = new HashMap<>();
        params3.put(ParamsName.PARAM1, 1);
        params3.put(ParamsName.PARAM2, 9);
        params3.put(ParamsName.PARAM3, "ABC");
        params3.put(ParamsName.PARAM4, new SomeUniqueParam(4));

        unit3.setParams(params3);
//----------------------------------------------------
        Unit unit4 = new Unit("unit4");

        Map<ParamsName, Comparable> params4 = new HashMap<>();
        params4.put(ParamsName.PARAM1, 1);
        params4.put(ParamsName.PARAM2, 1);
        params4.put(ParamsName.PARAM3, "ABC");
        params4.put(ParamsName.PARAM4, new SomeUniqueParam(100));

        unit4.setParams(params4);
//----------------------------------------------------
        List<Unit> units= new ArrayList<>();
        units.add(unit1);
        units.add(unit2);
        units.add(unit3);
        units.add(unit4);

        //result:
        Ranker.createAndPrintRank(units);
    }
}