import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.PriceRequestBuilder;

public class CheckPrice {
    public double checkPrice(String symbol) {
        IEXTradingClient iexTradingClient = (IEXTradingClient) IEXTradingClient.create();
        double price = iexTradingClient.executeRequest(new PriceRequestBuilder().withSymbol(symbol).build()).doubleValue();
        return price;
    }
}
