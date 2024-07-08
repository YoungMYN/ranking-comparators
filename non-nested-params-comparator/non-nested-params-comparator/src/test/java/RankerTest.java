import exceptions.ElementConsistentException;
import  org.junit.jupiter.api.*;

import java.util.*;

public class RankerTest {
    @BeforeAll
    public static void setUp() {
        Priority.paramsPriority.put(10,ParamsName.PARAM1);
        Priority.paramsPriority.put(9,ParamsName.PARAM2);
        Priority.paramsPriority.put(8,ParamsName.PARAM3);
        Priority.paramsPriority.put(7,ParamsName.PARAM4);
        Priority.paramsPriority.put(6,ParamsName.PARAM5);

    }


    @Test
    public void NormalRankingWithDifferentObjects() {
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

        //iteration:
        Iterator<String> rankIter = Ranker.printAndReturnRank(units).iterator();

        Assertions.assertEquals(rankIter.next(),unit2.toString());
        Assertions.assertEquals(rankIter.next(),unit1.toString());
        Assertions.assertEquals(rankIter.next(),unit3.toString());
        Assertions.assertEquals(rankIter.next(),unit4.toString());

    }

    @Test
    public void NormalRankingWithFewSameObjects() {
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
        params2.put(ParamsName.PARAM4, new SomeUniqueParam(3));

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

        //iteration:
        Iterator<String> rankIter = Ranker.printAndReturnRank(units).iterator();

        Assertions.assertEquals(rankIter.next(),unit2 + "\t" + unit1);
        Assertions.assertEquals(rankIter.next(),unit3.toString());
        Assertions.assertEquals(rankIter.next(),unit4.toString());

    }

    @Test
    public void NormalRankingWithAllSameObjects() {
        Unit unit1 = new Unit<>("unit1");


        Map<ParamsName, Comparable> params1 = new HashMap<>();
        params1.put(ParamsName.PARAM1, 1);
        params1.put(ParamsName.PARAM2, 10);

        unit1.setParams(params1);

//----------------------------------------------------
        Unit unit2 = new Unit("unit2");

        Map<ParamsName, Comparable> params2 = new HashMap<>();
        params2.put(ParamsName.PARAM1, 1);
        params2.put(ParamsName.PARAM2, 10);

        unit2.setParams(params2);
//----------------------------------------------------
        Unit unit3 = new Unit("unit3");

        Map<ParamsName, Comparable> params3 = new HashMap<>();
        params3.put(ParamsName.PARAM1, 1);
        params3.put(ParamsName.PARAM2, 10);

        unit3.setParams(params3);
//----------------------------------------------------
        Unit unit4 = new Unit("unit4");

        Map<ParamsName, Comparable> params4 = new HashMap<>();
        params4.put(ParamsName.PARAM1, 1);
        params4.put(ParamsName.PARAM2, 10);

        unit4.setParams(params4);
//----------------------------------------------------
        List<Unit> units= new ArrayList<>();
        units.add(unit1);
        units.add(unit2);
        units.add(unit3);
        units.add(unit4);

        //iteration:
        Iterator<String> rankIter = Ranker.printAndReturnRank(units).iterator();

        Assertions.assertEquals(rankIter.next(),unit4+ "\t" + unit3+ "\t" + unit2 + "\t" + unit1);

    }

    @Test
    public void NormalRankingWithNoConsistenceDataWithoutMode() {
        Unit unit1 = new Unit<>("unit1");


        Map<ParamsName, Comparable> params1 = new HashMap<>();
        params1.put(ParamsName.PARAM1, 1);

        unit1.setParams(params1);

//----------------------------------------------------
        Unit unit2 = new Unit("unit2");

        Map<ParamsName, Comparable> params2 = new HashMap<>();
        params2.put(ParamsName.PARAM1, 1);
        params2.put(ParamsName.PARAM2, 10);
        params2.put(ParamsName.PARAM3, 11);

        unit2.setParams(params2);
//----------------------------------------------------
        Unit unit3 = new Unit("unit3");

        Map<ParamsName, Comparable> params3 = new HashMap<>();
        params3.put(ParamsName.PARAM1, 1);
        params3.put(ParamsName.PARAM2, 10);
        params3.put(ParamsName.PARAM3, 16);
        params3.put(ParamsName.PARAM4, 100);
        params3.put(ParamsName.PARAM5, 34);

        unit3.setParams(params3);
//----------------------------------------------------
        Unit unit4 = new Unit("unit4");

        Map<ParamsName, Comparable> params4 = new HashMap<>();
        params4.put(ParamsName.PARAM1, 2);
        params4.put(ParamsName.PARAM2, 10);

        unit4.setParams(params4);
//----------------------------------------------------
        List<Unit> units= new ArrayList<>();
        units.add(unit1);
        units.add(unit2);
        units.add(unit3);
        units.add(unit4);

        //iteration:
        Iterator<String> rankIter = Ranker.printAndReturnRank(units).iterator();

        Assertions.assertEquals(rankIter.next(),unit4.toString());
        Assertions.assertEquals(rankIter.next(),unit3.toString());
        Assertions.assertEquals(rankIter.next(), unit2 + "\t" + unit1);
    }

    @Test
    public void NormalRankingWithNoConsistenceDataWithMode() {
        Unit unit1 = new Unit<>("unit1");


        Map<ParamsName, Comparable> params1 = new HashMap<>();
        params1.put(ParamsName.PARAM1, 1);

        unit1.setParams(params1);

//----------------------------------------------------
        Unit unit2 = new Unit("unit2");

        Map<ParamsName, Comparable> params2 = new HashMap<>();
        params2.put(ParamsName.PARAM1, 1);
        params2.put(ParamsName.PARAM2, 10);
        params2.put(ParamsName.PARAM3, 11);

        unit2.setParams(params2);
//----------------------------------------------------
        Unit unit3 = new Unit("unit3");

        Map<ParamsName, Comparable> params3 = new HashMap<>();
        params3.put(ParamsName.PARAM1, 1);
        params3.put(ParamsName.PARAM2, 10);
        params3.put(ParamsName.PARAM3, 16);
        params3.put(ParamsName.PARAM4, 100);
        params3.put(ParamsName.PARAM5, 34);

        unit3.setParams(params3);
//----------------------------------------------------
        Unit unit4 = new Unit("unit4");

        Map<ParamsName, Comparable> params4 = new HashMap<>();
        params4.put(ParamsName.PARAM1, 2);
        params4.put(ParamsName.PARAM2, 10);

        unit4.setParams(params4);
//----------------------------------------------------
        List<Unit> units= new ArrayList<>();
        units.add(unit1);
        units.add(unit2);
        units.add(unit3);
        units.add(unit4);

        //checking the correct operation of the validation mod
        try {
            Ranker.setConsistent(true);
            Ranker.printAndReturnRank(units);
            Assertions.fail();
        }
        catch (ElementConsistentException e){}

        //check for setter of mode
        try {
            Ranker.setConsistent(false);

            //iteration:
            Iterator<String> rankIter = Ranker.printAndReturnRank(units).iterator();

            Assertions.assertEquals(rankIter.next(),unit4.toString());
            Assertions.assertEquals(rankIter.next(),unit3.toString());
            Assertions.assertEquals(rankIter.next(), unit2 + "\t" + unit1);
        }
        catch (ElementConsistentException e){
            Assertions.fail();
        }
    }

    @Test
    public void NullProtectionTest() {
        Unit unit = new Unit<>("unit");
        Map<ParamsName, Comparable> params = new HashMap<>();
        try {
            params.put(ParamsName.PARAM1, null);
            unit.setParams(params);

            Assertions.fail();//null pointer was not thrown
        }catch (NullPointerException e){
            Assertions.assertEquals(e.getMessage(), "Null containing entry detected");
        }

        try {
            params.put(null, 1);
            unit.setParams(params);

            Assertions.fail();//null pointer was not thrown
        }catch (NullPointerException e){
            Assertions.assertEquals(e.getMessage(), "Null containing entry detected");
        }

        try {
            params.put(null, null);
            unit.setParams(params);

            Assertions.fail();//null pointer was not thrown
        }catch (NullPointerException e){
            Assertions.assertEquals(e.getMessage(), "Null containing entry detected");
        }

        try {
            unit.setParams(null);

            Assertions.fail();//null pointer was not thrown
        }catch (NullPointerException e){
            Assertions.assertEquals(e.getMessage(), "the input is null instead of Map");
        }

        try {
            Ranker.printAndReturnRank(null);

            Assertions.fail(); //null pointer was not thrown
        }catch (NullPointerException e){
            Assertions.assertEquals(e.getMessage(), "the input is null instead of List");
        }
    }


}

