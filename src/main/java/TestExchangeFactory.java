import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.liqui.LiquiExchange;

import java.util.Dictionary;

public class TestExchangeFactory {

    public static final String KEY = "DFEZYROH-AVBJXNC9-AEHL1LCJ-WEUF6MSX-94TCNKBW";
    public static final String SECRET = "87bacce93c1cb848c5bff8b3ea6bb64b87e306f1fa1afae6afbe2c7d6a421ba1";

    public static Exchange createTestExchange(Class exchangeClass, String key, String secret) {
        final Exchange exchange = ExchangeFactory.INSTANCE.createExchange(exchangeClass.getName());
        exchange.getExchangeSpecification().setApiKey(key);
        exchange.getExchangeSpecification().setSecretKey(secret);
        exchange.applySpecification(exchange.getExchangeSpecification());

        return exchange;
    }
}
