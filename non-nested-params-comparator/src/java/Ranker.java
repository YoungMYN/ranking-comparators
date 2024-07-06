
import java.util.Collections;
import java.util.List;

public class Ranker {
    public static void createAndPrintRank(List<Unit> in){
        Collections.sort(in);
        for(int i= in.size()-1;i>=0;i--){
            System.out.println(in.get(i));
        }
    }
}
