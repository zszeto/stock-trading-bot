import net.jacobpeterson.alpaca.AlpacaAPI;
import net.jacobpeterson.alpaca.enums.OrderTimeInForce;
import net.jacobpeterson.domain.alpaca.position.Position;

import static java.lang.Integer.parseInt;

public class Trading {

    private static final String key = Keys.alpacaKeyID;
    private static final String secretKey = Keys.alpacaKeyID;
    static AlpacaAPI alpacaAPI = new AlpacaAPI(key, secretKey, "https://paper-api.alpaca.markets");

    public static void autoBuy(String symbol, int amount) throws Exception {
        double fiftyDaySMA = CheckPrice.fiftyDaySMA(symbol);
        double currentPrice = CheckPrice.checkPrice(symbol);

        if (currentPrice>fiftyDaySMA) {
            Buy.marketBuy(symbol, amount, OrderTimeInForce.DAY);
        }
    }

    public static void autoSell(String symbol) throws Exception {
        double fiftyDaySMA = CheckPrice.fiftyDaySMA(symbol);
        double currentPrice = CheckPrice.checkPrice(symbol);

        Position position = alpacaAPI.getOpenPositionBySymbol(symbol);
        int amount = parseInt(position.getQty());

        if (currentPrice<fiftyDaySMA) {
            Sell.marketSell(symbol, amount, OrderTimeInForce.DAY);
        }
    }
}
