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
import org.knowm.xchange.liqui.dto.LiquiException;
import org.knowm.xchange.service.marketdata.MarketDataService;
import org.knowm.xchange.service.trade.params.TradeHistoryParams;

import org.knowm.xchange.liqui.dto.marketdata.LiquiTicker;
import org.knowm.xchange.liqui.service.LiquiAccountService;
import org.knowm.xchange.liqui.service.LiquiMarketDataService;
import org.knowm.xchange.liqui.service.LiquiTradeService;

public class ExchangeTester {

    public static final void main(final String[] args) throws IOException {
        final Exchange exchange = TestExchangeFactory.createTestExchange();

        testMarketDataService(exchange);
        testAccountService(exchange);
        testTradeService(exchange);
    }

    private static void testMarketDataService(final Exchange liquiExchange) throws IOException {
        final LiquiMarketDataService liquiMarketDataService = (LiquiMarketDataService) liquiExchange.getMarketDataService();

        CurrencyPair testPair = CurrencyPair.ETH_BTC;

        System.out.println("******************  Market Data Service Tests!  ******************\n\n");

        try {
            System.out.println("Trying liquiMarketDataService.getTicker(CurrencyPair.ETH_BTC)\n");

            Ticker ticker = liquiMarketDataService.getTicker(testPair, null, null);

            System.out.println("Success! Result:");
            System.out.println(ticker.toString());
            System.out.println("\n\n----------------------------------------------------------------------\n\n");
        } catch (NotAvailableFromExchangeException e) {
            System.err.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.err.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.err.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.err.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException " + e.getMessage());
        }

        try {
            System.out.println("Trying liquiMarketDataService.getOrderBook(CurrencyPair.ETH_BTC)\n");

            OrderBook orderBook = liquiMarketDataService.getOrderBook(testPair, null, null);

            System.out.println("Success! Result:");
            System.out.println(orderBook.toString());
            System.out.println("\n\n----------------------------------------------------------------------\n\n");
        } catch (NotAvailableFromExchangeException e) {
            System.err.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.err.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.err.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.err.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException " + e.getMessage());
        }

        try {
            System.out.println("Trying liquiMarketDataService.getTrades(CurrencyPair.ETH_BTC)\n");

            Trades trades = liquiMarketDataService.getTrades(testPair, null, null);

            System.out.println("Success! Result:");
            System.out.println(trades.toString());
            System.out.println("\n\n----------------------------------------------------------------------\n\n");
        } catch (NotAvailableFromExchangeException e) {
            System.err.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.err.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.err.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.err.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException " + e.getMessage());
        }
    }

    private static void testAccountService(final Exchange liquiExchange) throws IOException {
        final LiquiAccountService liquiAccountService = (LiquiAccountService) liquiExchange.getAccountService();

        System.out.println("******************  Account Service Tests!  ******************\n\n");

        try {
            System.out.println("Trying liquiAccountService.getAccountInfo()\n");

            AccountInfo accountInfo = liquiAccountService.getAccountInfo();

            System.out.println("Success! Result:");
            System.out.println(accountInfo.toString());
            System.out.println("\n\n----------------------------------------------------------------------\n\n");
        } catch (NotAvailableFromExchangeException e) {
            System.err.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.err.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.err.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.err.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException " + e.getMessage());
        }

        try {
            System.out.println("Trying liquiAccountService.withdrawFunds(Currency.BTC, new BigDecimal(0.01), \"ADDRESS\")\n");

            String address = "ADDRESS";
            BigDecimal amount = new BigDecimal(0.01);

            String response = liquiAccountService.withdrawFunds(Currency.BTC, amount, address);

            System.out.println("Success! Result:");
            System.out.println(response);
            System.out.println("\n\n----------------------------------------------------------------------\n\n");
        } catch (NotAvailableFromExchangeException e) {
            System.err.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.err.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.err.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.err.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException " + e.getMessage());
        }

        try {
            System.out.println("Trying liquiAccountService.requestDepositAddress(Currency.BTC)\n");

            String response = liquiAccountService.requestDepositAddress(Currency.BTC, null, null);

            System.out.println("Success! Result:");
            System.out.println(response);
            System.out.println("\n\n----------------------------------------------------------------------\n\n");
        } catch (NotAvailableFromExchangeException e) {
            System.err.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.err.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.err.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.err.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException " + e.getMessage());
        }

        try {
            System.out.println("Trying liquiAccountService.getFundingHistory(tradeHistoryParams)\n");

            TradeHistoryParams params = liquiAccountService.createFundingHistoryParams();

            List<FundingRecord> records = liquiAccountService.getFundingHistory(params);

            System.out.println("Success! Result:");
            System.out.println(records.toArray().toString());
            System.out.println("\n\n----------------------------------------------------------------------\n\n");
        } catch (NotAvailableFromExchangeException e) {
            System.err.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.err.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.err.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.err.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException " + e.getMessage());
        }
    }

    private static void testTradeService(final Exchange liquiExchange) throws IOException {
        final LiquiTradeService liquiTradeService = (LiquiTradeService) liquiExchange.getTradeService();

        System.out.println("******************  Trade Service Tests!  ******************\n\n");

        try {
            System.out.println("Trying liquiTradeService.getOpenOrders()\n");

            OpenOrders openOrders = liquiTradeService.getOpenOrders();

            System.out.println("Success! Result:");
            System.out.println(openOrders.toString());
            System.out.println("\n\n----------------------------------------------------------------------\n\n");
        } catch (NotAvailableFromExchangeException e) {
            System.err.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.err.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.err.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.err.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException " + e.getMessage());
        }

        try {
            System.out.println("Trying liquiTradeService.placeMarketOrder(marketOrder)\n");

            MarketOrder order = new MarketOrder(Order.OrderType.BID, new BigDecimal(0.01), CurrencyPair.BTC_USD);
            String response = liquiTradeService.placeMarketOrder(order);

            System.out.println("Success! Result:");
            System.out.println(response);
            System.out.println("\n\n----------------------------------------------------------------------\n\n");
        } catch (NotAvailableFromExchangeException e) {
            System.err.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.err.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.err.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.err.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException " + e.getMessage());
        }

        try {
            System.out.println("Trying liquiTradeService.placeLimitOrder(limitOrder)\n");

            LimitOrder order = new LimitOrder(Order.OrderType.BID, new BigDecimal(0.01), CurrencyPair.BTC_USD, "ID", Date.from(Instant.now()), new BigDecimal(10000));
            String response = liquiTradeService.placeLimitOrder(order);

            System.out.println("Success! Result:");
            System.out.println(response);
            System.out.println("\n\n----------------------------------------------------------------------\n\n");
        } catch (NotAvailableFromExchangeException e) {
            System.err.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.err.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.err.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.err.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException " + e.getMessage());
        }

        try {
            System.out.println("Trying liquiTradeService.placeStopOrder(stopOrder)\n");

            StopOrder order = new StopOrder(Order.OrderType.BID, new BigDecimal(0.01), CurrencyPair.BTC_USD, "ID", Date.from(Instant.now()), new BigDecimal(10000));
            String response = liquiTradeService.placeStopOrder(order);

            System.out.println("Success! Result:");
            System.out.println(response);
            System.out.println("\n\n----------------------------------------------------------------------\n\n");
        } catch (NotAvailableFromExchangeException e) {
            System.err.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.err.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.err.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.err.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException " + e.getMessage());
        }

        try {
            System.out.println("Trying liquiTradeService.cancelOrder(orderID)\n");

            boolean canceled = liquiTradeService.cancelOrder("1");

            System.out.println("Success! Result:");
            System.out.println(canceled);
            System.out.println("\n\n----------------------------------------------------------------------\n\n");
        } catch (NotAvailableFromExchangeException e) {
            System.err.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.err.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.err.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.err.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException " + e.getMessage());
        }

        try {
            System.out.println("Trying liquiTradeService.getTradeHistory(tradeHistoryParams)\n");

            TradeHistoryParams params = liquiTradeService.createTradeHistoryParams();
            UserTrades trades = liquiTradeService.getTradeHistory(params);

            System.out.println("Success! Result:");
            System.out.println(trades.getUserTrades().toArray().toString());
            System.out.println("\n\n----------------------------------------------------------------------\n\n");
        } catch (NotAvailableFromExchangeException e) {
            System.err.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.err.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.err.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.err.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException " + e.getMessage());
        }

        try {
            System.out.println("Trying liquiTradeService.getOrder(orderIDs)\n");

            Collection<Order> orders = liquiTradeService.getOrder("1");

            System.out.println("Success! Result:");
            System.out.println(orders.toArray().toString());
            System.out.println("\n\n----------------------------------------------------------------------\n\n");
        } catch (NotAvailableFromExchangeException e) {
            System.err.println("NotAvailableFromExchangeException " + e.getMessage());
        } catch (NotYetImplementedForExchangeException e) {
            System.err.println("NotYetImplementedForExchangeException " + e.getMessage());
        } catch (LiquiException e) {
            System.err.println("LiquiException " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException " + e.getMessage());
        } catch (UndeclaredThrowableException e) {
            System.err.println("UndeclaredThrowableException " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException " + e.getMessage());
        }
    }
}