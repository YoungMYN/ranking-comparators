package tree;

import static org.junit.jupiter.api.Assertions.*;
import static tree.FamilyExample.*;
import static tree.enums.CalculatingStrategy.*;
import static tree.Params.CalculatingParam.*;

import org.junit.jupiter.api.Test;
import tree.enums.SortMode;
import tree.nodes.Person;

import java.util.ArrayList;
import java.util.List;

public class TreeCalcTest {

    @Test
    public void normalCasesTest(){
        System.out.println("-----------");
        List<Person> persons = new ArrayList<>();
        persons.add(andrew);
        persons.add(michel);
        persons.add(alex);
        persons.add(stephan);

        List<String> rank = new TreeRanker().printAndReturnRank(persons, new ApplicableFunction(MAX, HEIGHT));

        assertEquals(rank.get(0), alex.toString());
        assertEquals(rank.get(1), michel.toString());
        assertEquals(rank.get(2), stephan + "\t"+ andrew);

        System.out.println("-----------");
        rank = new TreeRanker().printAndReturnRank(persons, new ApplicableFunction(MIN, HEIGHT));

        assertEquals(rank.get(0), michel.toString());
        assertEquals(rank.get(1), andrew.toString());
        assertEquals(rank.get(2), stephan.toString());
        assertEquals(rank.get(3), alex.toString());

        System.out.println("-----------");
        rank = new TreeRanker().printAndReturnRank(persons, new ApplicableFunction(MIN, AGE));

        assertEquals(rank.get(0), michel.toString());
        assertEquals(rank.get(1), andrew +"\t" + stephan);
        assertEquals(rank.get(2), alex.toString());

        System.out.println("-----------");
        rank = new TreeRanker().printAndReturnRank(persons, new ApplicableFunction(AVERAGE, AGE));

        assertEquals(rank.get(0), andrew +"\t" + michel);
        assertEquals(rank.get(1), alex.toString());
        assertEquals(rank.get(2), stephan.toString());

        System.out.println("-----------");
        rank = new TreeRanker().printAndReturnRank(persons, new ApplicableFunction(SUM, WEIGHT));

        assertEquals(rank.get(0), andrew.toString());
        assertEquals(rank.get(1), michel.toString());
        assertEquals(rank.get(2), alex.toString());
        assertEquals(rank.get(3), stephan.toString());

    }

    @Test
    public void sortModesTest(){
        List<Person> persons = new ArrayList<>();
        persons.add(andrew);
        persons.add(michel);
        persons.add(alex);
        persons.add(stephan);

        System.out.println("-----------");
        List<String> rank = new TreeRanker().printAndReturnRank(persons, new ApplicableFunction(MAX, HEIGHT), SortMode.ASC);

        assertEquals(rank.get(0), andrew + "\t" + stephan);
        assertEquals(rank.get(1), michel.toString());
        assertEquals(rank.get(2), alex.toString());

        System.out.println("-----------");
        rank = new TreeRanker().printAndReturnRank(persons, new ApplicableFunction(MIN, AGE), SortMode.ASC);

        assertEquals(rank.get(0), michel.toString());
        assertEquals(rank.get(1), andrew +"\t" + stephan);
        assertEquals(rank.get(2), alex.toString());

        System.out.println("-----------");
        rank = new TreeRanker().printAndReturnRank(persons, new ApplicableFunction(MIN, AGE), SortMode.DESC);

        assertEquals(rank.get(0), alex.toString());
        assertEquals(rank.get(1), stephan + "\t" + andrew);
        assertEquals(rank.get(2), michel.toString());

        System.out.println("-----------");//
        rank = new TreeRanker().printAndReturnRank(persons, new ApplicableFunction(AVERAGE, WEIGHT), SortMode.ASC);

        assertEquals(rank.get(0), stephan + "\t" + andrew);
        assertEquals(rank.get(1), michel.toString());
        assertEquals(rank.get(2), alex.toString());

        System.out.println("-----------");
        rank = new TreeRanker().printAndReturnRank(persons, new ApplicableFunction(SUM, WEIGHT), SortMode.ASC);

        assertEquals(rank.get(0), stephan.toString());
        assertEquals(rank.get(1), alex.toString());
        assertEquals(rank.get(2), michel.toString());
        assertEquals(rank.get(3), andrew.toString());
    }
}
