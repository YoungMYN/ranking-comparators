package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tree.FamilyExample.*;
import static tree.enums.CalculatingStrategy.*;
import static tree.Params.CalculatingParam.*;

public class AlgorithmsTest {

    @Test
    public void sumTest(){
        assertEquals(john.calculate(new ApplicableFunction(SUM, AGE)).longValue(), 280);

    }

    @Test
    public void avgTest(){
        assertEquals(john.calculate(new ApplicableFunction(AVERAGE, AGE)).longValue(), 47);

    }

    @Test
    public void minTest(){
        assertEquals(john.calculate(new ApplicableFunction(MIN, AGE)).longValue(), 20);

    }

    @Test
    public void maxTest(){
        assertEquals(john.calculate(new ApplicableFunction(MAX, AGE)).longValue(), 80);

        assertEquals(andrew.calculate(new ApplicableFunction(MAX, AGE)).longValue(), 55);
        assertEquals(michel.calculate(new ApplicableFunction(MAX, AGE)).longValue(), 60);
    }

    @Test
    public void countTest(){

    }
}
