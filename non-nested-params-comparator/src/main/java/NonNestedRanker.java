
import exceptions.ElementConsistentException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NonNestedRanker implements Ranker<Unit> {
    private boolean consistentMode = false;

    /**
     * This method creates a ranking list of the passed objects and prints it to the console. It returns a list of strings identical to the printed one.
     *
     * @param units the list of Units to compile the rating.
     * @return a List of strings - string representations of objects of the Unit class.
         * The elements with the highest values of the priority parameters are represented at the beginning of the list, starting from the zero element.
         * If several elements are identical, their string representations will be separated by a tab and form one element of the list.
     */
    public List<String> printAndReturnRank(List<Unit> units) throws NullPointerException
    {
        if(units == null) throw new NullPointerException("the input is null instead of List");
        if(consistentMode) checkConsistence(units);

        Collections.sort(units);
        Collections.reverse(units);

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < units.size(); i++) {
            sb.append(units.get(i).toString());
            if(i == units.size()-1) {
                result.add(sb.toString());
                break;
            }
            if(units.get(i).compareTo(units.get(i+1))==0){
                sb.append("\t");
            }
            else{
                result.add(sb.toString());
                sb.setLength(0);
            }
        }

        result.forEach(System.out::println);

        return result;
    }

    /**
     * This method sets or removes the consistency check mode for the compared objects.
     * In consistency check mode, before comparing elements (in the method {@link NonNestedRanker#printAndReturnRank(List)}), a comparison of all stored parameters will be performed.
     * And if there is at least one different object, an exception {@link ElementConsistentException} will be thrown in the validation method {@link NonNestedRanker#checkConsistence(List)}.
     * @param consistent the flag for setting the consistency check mode.
     */
    public void setConsistent(boolean consistent){
        consistentMode = consistent;
    }

    private void checkConsistence(List<Unit> in) throws ElementConsistentException
    {
        for (int i = 0; i < in.size(); i++){
            if(i+1 == in.size()) return;
            if(!in.get(i).getParams().keySet().equals(in.get(i+1).getParams().keySet())) throw new ElementConsistentException();

        }
    }
}
