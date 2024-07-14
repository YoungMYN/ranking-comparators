import java.math.BigDecimal;

public interface MultiCalculable {
    BigDecimal calculate(CalculatingStrategy strategy, Params.CalculatingParam param);
}
