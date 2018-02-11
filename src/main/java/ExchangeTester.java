import java.io.IOException;
import java.util.Map;

import org.knowm.xchange.Exchange;
import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.liqui.dto.marketdata.LiquiTicker;
import org.knowm.xchange.liqui.service.LiquiMarketDataServiceRaw;
import org.knowm.xchange.service.marketdata.MarketDataService;

public class ExchangeTester {

    public static final void main(final String[] args) throws IOException {
        final Exchange exchange = TestExchangeFactory.createTestExchange();

        raw(exchange);
    }

    private static void raw(final Exchange liquiExchange) throws IOException {

        final LiquiMarketDataServiceRaw liquiMarketDataServiceRaw = (LiquiMarketDataServiceRaw) liquiExchange.getMarketDataService();

        final Map<String, LiquiTicker> tickers = liquiMarketDataServiceRaw.getAllTickers();

        for (Map.Entry<String, LiquiTicker> ticker : tickers.entrySet()) {
            System.out.println("Ticker: " + ticker.getValue().toString());
            System.out.println("Pair: " + ticker.getKey());
            System.out.println("Last: " + ticker.getValue().getLast());
            System.out.println("Volume: " + ticker.getValue().getVol().toString());
            System.out.println("High: " + ticker.getValue().getHigh().toString());
            System.out.println("Low: " + ticker.getValue().getLow().toString());
        }
    }
}