import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.liqui.LiquiExchange;

public class TestExchangeFactory {

    public static final String KEY = "DFEZYROH-AVBJXNC9-AEHL1LCJ-WEUF6MSX-94TCNKBW";
    public static final String SECRET = "87bacce93c1cb848c5bff8b3ea6bb64b87e306f1fa1afae6afbe2c7d6a421ba1";

    public static Exchange createTestExchange() {
        final Exchange liquiExchange = ExchangeFactory.INSTANCE.createExchange(LiquiExchange.class.getName());
        liquiExchange.getExchangeSpecification().setApiKey(KEY);
        liquiExchange.getExchangeSpecification().setSecretKey(SECRET);
        liquiExchange.applySpecification(liquiExchange.getExchangeSpecification());

        return liquiExchange;
    }
}
