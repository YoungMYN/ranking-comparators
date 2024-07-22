package tree;


import tree.nodes.LastDescendant;
import tree.nodes.Person;

import java.math.BigDecimal;

public class FamilyExample {
    public static final Person john;
    public static final Person steve;
    public static final Person andrew;
    public static final Person michel;
    public static final Person alex;
    public static final Person stephan;
    public static final Person tate;
    public static final Person larry;
    public static final Person viktor;

    static {
        john = new Person(new Params("John", 80, 180, BigDecimal.valueOf(75), true));
        steve = new Person(new Params("Steve", 60, 160, BigDecimal.valueOf(90), true));

        andrew = new Person(new Params("Andrew", 55, 190, BigDecimal.valueOf(90), true));
        michel = new Person(new Params("Michel", 60, 160, BigDecimal.valueOf(75), false));

        alex = new LastDescendant(new Params("Alex", 35, 210, BigDecimal.valueOf(130), true));
        stephan = new LastDescendant(new Params("Stephan", 30, 190, BigDecimal.valueOf(80), true));

        tate = new LastDescendant(new Params("Tate", 30, 180, BigDecimal.valueOf(60), true));
        larry = new LastDescendant(new Params("Larry", 35, 180, BigDecimal.valueOf(90), true));
        viktor = new LastDescendant(new Params("Viktor", 20, 200, BigDecimal.valueOf(100), true));

        john.addChild(andrew);
        john.addChild(michel);

        steve.addChild(alex);
        steve.addChild(stephan);

        andrew.addChild(tate);
        andrew.addChild(larry);

        michel.addChild(viktor);
    }
}
