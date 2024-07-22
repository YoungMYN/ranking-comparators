package tree;

import lombok.Getter;
import tree.enums.CalculatingStrategy;

@Getter
public class ApplicableFunction {
    private CalculatingStrategy function;
    private Params.CalculatingParam argument;
    private ApplicableFunction(){}

    public ApplicableFunction(CalculatingStrategy function, Params.CalculatingParam argument) {
        this.function = function;
        this.argument = argument;
    }
}
