import net.jacobpeterson.alpaca.AlpacaAPI;
import net.jacobpeterson.alpaca.enums.OrderTimeInForce;
import net.jacobpeterson.domain.alpaca.position.Position;

import static java.lang.Integer.parseInt;

public class Trading {

    private static final String key = Keys.alpacaKeyID;
    private static final String secretKey = Keys.alpacaKeyID;
    AlpacaAPI alpacaAPI = new AlpacaAPI(key, secretKey, "https://paper-api.alpaca.markets");

    public void autoBuy(String symbol, int amount) throws Exception {
        double fiveDaySMA = CheckPrice.fiveDaySMA(symbol);
        double hundredDaySMA = CheckPrice.hundredDaySMA(symbol);

        if (fiveDaySMA>hundredDaySMA) {
            Buy.marketBuy(symbol, amount, OrderTimeInForce.DAY);
        }
    }

    public void autoSell(String symbol) throws Exception {
        double fiveDaySMA = CheckPrice.fiveDaySMA(symbol);
        double hundredDaySMA = CheckPrice.hundredDaySMA(symbol);

        Position position = alpacaAPI.getOpenPositionBySymbol(symbol);
        int amount = parseInt(position.getQty());

        if (fiveDaySMA<hundredDaySMA) {
            Sell.marketSell(symbol, amount, OrderTimeInForce.DAY);
        }
    }
}
