import com.barchart.ondemand.BarchartOnDemandClient;
import com.barchart.ondemand.api.TechnicalsRequest;
import com.barchart.ondemand.api.TechnicalsRequestField;
import com.barchart.ondemand.api.responses.Technical;
import com.barchart.ondemand.api.responses.Technicals;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.PriceRequestBuilder;

public class CheckPrice {
    public static double checkPrice(String symbol) {
        IEXTradingClient iexTradingClient = (IEXTradingClient) IEXTradingClient.create();
        double price = iexTradingClient.executeRequest(new PriceRequestBuilder().withSymbol(symbol).build()).doubleValue();
        return price;
    }
    public static double fiveDaySMA(String symbol) throws Exception {
        BarchartOnDemandClient onDemand = new BarchartOnDemandClient.Builder().build();
        final TechnicalsRequest.Builder builder = new TechnicalsRequest.Builder();

        String[] symbolsArray = {symbol};

        builder.symbols(symbolsArray);
        builder.fields(TechnicalsRequestField.all());

        final Technicals results = (Technicals) onDemand.fetch(builder.build());

        double[] fiveDayMovingAverageList = new double[symbolsArray.length];

        for (Technical q : results.all()) {
            fiveDayMovingAverageList[0] = q.getMovingAverageFiveDay();
        }

        double sma = fiveDayMovingAverageList[0];

   return sma;
    }

    public static double hundredDaySMA(String symbol) throws Exception {
        BarchartOnDemandClient onDemand = new BarchartOnDemandClient.Builder().build();
        final TechnicalsRequest.Builder builder = new TechnicalsRequest.Builder();

        String[] symbolsArray = {symbol};

        builder.symbols(symbolsArray);
        builder.fields(TechnicalsRequestField.all());

        final Technicals results = (Technicals) onDemand.fetch(builder.build());

        double[] hundredDayMovingAverageList = new double[symbolsArray.length];

        for (Technical q : results.all()) {
            hundredDayMovingAverageList[0] = q.getMovingAverageFiveDay();
        }

        double sma = hundredDayMovingAverageList[0];

        return sma;
    }
}
