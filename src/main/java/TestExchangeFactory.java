import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.liqui.LiquiExchange;

public class TestExchangeFactory {

    public static final String KEY = "MyKey";
    public static final String SECRET = "MySecret";

    public static Exchange createTestExchange() {
        final Exchange liquiExchange = ExchangeFactory.INSTANCE.createExchange(LiquiExchange.class.getName());
        liquiExchange.getExchangeSpecification().setApiKey(KEY);
        liquiExchange.getExchangeSpecification().setSecretKey(SECRET);
        liquiExchange.applySpecification(liquiExchange.getExchangeSpecification());

        return liquiExchange;
    }
}
