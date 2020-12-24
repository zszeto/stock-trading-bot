import net.jacobpeterson.alpaca.rest.exception.AlpacaAPIRequestException;

public class BuyAmount {
    public static int buyAmount(String symbol) throws AlpacaAPIRequestException {
     double total = (AccountInfo.buyPower() - 50000)/5;
     double doubleAmount = total/CheckPrice.checkPrice(symbol);
     int amount = (int) doubleAmount;
        return amount;
    }
}
