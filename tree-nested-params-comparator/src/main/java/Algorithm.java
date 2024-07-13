import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Algorithm {
    public static BigDecimal sumParameters(Person person, Params.CalculatingParam param ){
        /* https://stackoverflow.com/questions/16216248/convert-java-number-to-bigdecimal-best-way */
        //TODO check for Double for Nan and Infinity or try catch

        //add the value of the parameter for the person himself
        BigDecimal sum = BigDecimal.valueOf(0);
        sum = sum.add(new BigDecimal(person.getParams().getParam(param).toString()));

        //add the value of the parameter for each child(recursion)
        for (Person child: person.getChildren()) {
            sum = sum.add(child.calculate(CalculatingStrategy.SUM, param));
        }
        return sum;
    }



    public static BigDecimal avgParam(Person person, Params.CalculatingParam param){
        return sumParameters(person,param).divide(BigDecimal.valueOf(countChildren(person)), RoundingMode.HALF_UP);
    }

    public static BigDecimal minParam(Person person, Params.CalculatingParam param){
        return null;//TODO implement
    }

    public static BigDecimal maxParam(Person person, Params.CalculatingParam param){
        return null;//TODO implement
    }

    public static long countChildren(Person person){
        return person.countChildren();
    }

 /*
    public static long countAliveChildren(Person person){
        return 0;
    }

 */
}
