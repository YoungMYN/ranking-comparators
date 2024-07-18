package tree.interfaces;

import java.math.BigDecimal;

import tree.CalculatingStrategy;
import tree.Params;

public interface MultiCalculable {
	BigDecimal calculate(CalculatingStrategy strategy, Params.CalculatingParam param);
}
