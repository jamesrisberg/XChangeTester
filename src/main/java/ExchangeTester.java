import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.knowm.xchange.Exchange;

import org.knowm.xchange.currency.Currency;
import org.knowm.xchange.currency.CurrencyPair;

import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.marketdata.OrderBook;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.marketdata.Trades;


import org.knowm.xchange.dto.account.FundingRecord;
import org.knowm.xchange.dto.account.AccountInfo;

import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.MarketOrder;
import org.knowm.xchange.dto.trade.OpenOrders;
import org.knowm.xchange.dto.trade.StopOrder;
import org.knowm.xchange.dto.trade.UserTrades;

import org.knowm.xchange.exceptions.NotAvailableFromExchangeException;
import org.knowm.xchange.exceptions.NotYetImplementedForExchangeException;
import org.knowm.xchange.liqui.LiquiExchange;
import org.knowm.xchange.liqui.dto.LiquiException;
import org.knowm.xchange.service.account.AccountService;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.service.trade.TradeService;
import org.knowm.xchange.service.trade.params.TradeHistoryParams;

import org.knowm.xchange.liqui.dto.marketdata.LiquiTicker;
import org.knowm.xchange.liqui.service.LiquiAccountService;
import org.knowm.xchange.liqui.service.LiquiMarketDataService;
import org.knowm.xchange.liqui.service.LiquiTradeService;

public class ExchangeTester {

    public static final void main(final String[] args) throws IOException {
        final Exchange exchange = TestExchangeFactory.createTestExchange(LiquiExchange.class, TestExchangeFactory.KEY, TestExchangeFactory.SECRET);

        testMarketDataService(exchange);
        testAccountService(exchange);
        testTradeService(exchange);
    }

    private static void testMarketDataService(final Exchange exchange) throws IOException {
        final MarketDataService marketDataService = exchange.getMarketDataService();

        CurrencyPair testPair = CurrencyPair.ETH_BTC;

        System.out.println("******************  Market Data Service Tests!  ******************\n\n");

        try {
            System.out.println("Trying getTicker(CurrencyPair.ETH_BTC)\n");

            Ticker ticker = marketDataService.getTicker(testPair, null, null);

            System.out.println("Success! Result:");
            System.out.println(ticker.toString());
        } catch (NotAvailableFromExchangeException e) {
            System.out.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.out.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.out.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.out.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage());
        }

        System.out.println("\n\n----------------------------------------------------------------------\n\n");

        try {
            System.out.println("Trying getOrderBook(CurrencyPair.ETH_BTC)\n");

            OrderBook orderBook = marketDataService.getOrderBook(testPair, null, null);

            System.out.println("Success! Result:");
            System.out.println(orderBook.toString());
        } catch (NotAvailableFromExchangeException e) {
            System.out.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.out.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.out.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.out.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage());
        }

        System.out.println("\n\n----------------------------------------------------------------------\n\n");

        try {
            System.out.println("Trying getTrades(CurrencyPair.ETH_BTC)\n");

            Trades trades = marketDataService.getTrades(testPair, null, null);

            System.out.println("Success! Result:");
            System.out.println(trades.toString());
        } catch (NotAvailableFromExchangeException e) {
            System.out.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.out.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.out.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.out.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage());
        }

        System.out.println("\n\n----------------------------------------------------------------------\n\n");
    }

    private static void testAccountService(final Exchange exchange) throws IOException {
        final AccountService accountService = exchange.getAccountService();

        System.out.println("******************  Account Service Tests!  ******************\n\n");

        try {
            System.out.println("Trying getAccountInfo()\n");

            AccountInfo accountInfo = accountService.getAccountInfo();

            System.out.println("Success! Result:");
            System.out.println(accountInfo.toString());
        } catch (NotAvailableFromExchangeException e) {
            System.out.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.out.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.out.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.out.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage());
        }

        System.out.println("\n\n----------------------------------------------------------------------\n\n");

        try {
            System.out.println("Trying withdrawFunds(Currency.BTC, new BigDecimal(0.01), \"ADDRESS\")\n");

            String address = "ADDRESS";
            BigDecimal amount = new BigDecimal(0.01);

            String response = accountService.withdrawFunds(Currency.BTC, amount, address);

            System.out.println("Success! Result:");
            System.out.println(response);
        } catch (NotAvailableFromExchangeException e) {
            System.out.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.out.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.out.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.out.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage());
        }

        System.out.println("\n\n----------------------------------------------------------------------\n\n");

        try {
            System.out.println("Trying requestDepositAddress(Currency.BTC)\n");

            String response = accountService.requestDepositAddress(Currency.BTC, null, null);

            System.out.println("Success! Result:");
            System.out.println(response);
        } catch (NotAvailableFromExchangeException e) {
            System.out.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.out.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.out.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.out.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage());
        }

        System.out.println("\n\n----------------------------------------------------------------------\n\n");

        try {
            System.out.println("Trying getFundingHistory(tradeHistoryParams)\n");

            TradeHistoryParams params = accountService.createFundingHistoryParams();

            List<FundingRecord> records = accountService.getFundingHistory(params);

            System.out.println("Success! Result:");
            System.out.println(records.toArray().toString());
        } catch (NotAvailableFromExchangeException e) {
            System.out.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.out.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.out.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.out.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage());
        }

        System.out.println("\n\n----------------------------------------------------------------------\n\n");
    }

    private static void testTradeService(final Exchange exchange) throws IOException {
        final TradeService tradeService = exchange.getTradeService();

        System.out.println("******************  Trade Service Tests!  ******************\n\n");

        try {
            System.out.println("Trying getOpenOrders()\n");

            OpenOrders openOrders = tradeService.getOpenOrders();

            System.out.println("Success! Result:");
            System.out.println(openOrders.toString());
        } catch (NotAvailableFromExchangeException e) {
            System.out.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.out.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.out.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.out.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage());
        }

        System.out.println("\n\n----------------------------------------------------------------------\n\n");

        try {
            System.out.println("Trying placeMarketOrder(marketOrder)\n");

            MarketOrder order = new MarketOrder(Order.OrderType.BID, new BigDecimal(0.01), CurrencyPair.BTC_USD);
            String response = tradeService.placeMarketOrder(order);

            System.out.println("Success! Result:");
            System.out.println(response);
        } catch (NotAvailableFromExchangeException e) {
            System.out.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.out.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.out.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.out.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage());
        }

        System.out.println("\n\n----------------------------------------------------------------------\n\n");

        try {
            System.out.println("Trying placeLimitOrder(limitOrder)\n");

            LimitOrder order = new LimitOrder(Order.OrderType.BID, new BigDecimal(0.01), CurrencyPair.BTC_USD, "ID", Date.from(Instant.now()), new BigDecimal(10000));
            String response = tradeService.placeLimitOrder(order);

            System.out.println("Success! Result:");
            System.out.println(response);
        } catch (NotAvailableFromExchangeException e) {
            System.out.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.out.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.out.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.out.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage());
        }

        System.out.println("\n\n----------------------------------------------------------------------\n\n");

        try {
            System.out.println("Trying placeStopOrder(stopOrder)\n");

            StopOrder order = new StopOrder(Order.OrderType.BID, new BigDecimal(0.01), CurrencyPair.BTC_USD, "ID", Date.from(Instant.now()), new BigDecimal(10000));
            String response = tradeService.placeStopOrder(order);

            System.out.println("Success! Result:");
            System.out.println(response);
        } catch (NotAvailableFromExchangeException e) {
            System.out.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.out.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.out.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.out.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage());
        }

        System.out.println("\n\n----------------------------------------------------------------------\n\n");

        try {
            System.out.println("Trying cancelOrder(orderID)\n");

            boolean canceled = tradeService.cancelOrder("1");

            System.out.println("Success! Result:");
            System.out.println(canceled);
        } catch (NotAvailableFromExchangeException e) {
            System.out.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.out.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.out.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.out.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage());
        }

        System.out.println("\n\n----------------------------------------------------------------------\n\n");

        try {
            System.out.println("Trying getTradeHistory(tradeHistoryParams)\n");

            TradeHistoryParams params = tradeService.createTradeHistoryParams();
            UserTrades trades = tradeService.getTradeHistory(params);

            System.out.println("Success! Result:");
            System.out.println(trades.getUserTrades().toArray().toString());
        } catch (NotAvailableFromExchangeException e) {
            System.out.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.out.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.out.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.out.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage());
        }

        System.out.println("\n\n----------------------------------------------------------------------\n\n");

        try {
            System.out.println("Trying getOrder(orderIDs)\n");

            Collection<Order> orders = tradeService.getOrder("1");

            System.out.println("Success! Result:");
            System.out.println(orders.toArray().toString());
        } catch (NotAvailableFromExchangeException e) {
            System.out.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.out.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.out.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.out.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException " + e.getMessage());
        }

        System.out.println("\n\n----------------------------------------------------------------------\n\n");
    }
}