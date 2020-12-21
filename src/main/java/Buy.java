import net.jacobpeterson.alpaca.AlpacaAPI;
import net.jacobpeterson.alpaca.enums.OrderSide;
import net.jacobpeterson.alpaca.enums.OrderTimeInForce;
import net.jacobpeterson.alpaca.rest.exception.AlpacaAPIRequestException;
import net.jacobpeterson.domain.alpaca.order.Order;

public class Buy {

    private static final String key = Keys.alpacaKeyID;
    private static final String secretKey = Keys.alpacaKeyID;

   AlpacaAPI alpacaAPI = new AlpacaAPI(key, secretKey, "https://paper-api.alpaca.markets");

    public void marketBuy(String symbol, int amount, OrderTimeInForce tif) throws AlpacaAPIRequestException {
Order buyOrder = alpacaAPI.requestNewMarketOrder(symbol, amount, OrderSide.BUY, tif);
    }
}
