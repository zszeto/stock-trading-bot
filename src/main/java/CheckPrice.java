import org.patriques.AlphaVantageConnector;
import org.patriques.TechnicalIndicators;
import org.patriques.input.technicalindicators.Interval;
import org.patriques.input.technicalindicators.SeriesType;
import org.patriques.input.technicalindicators.TimePeriod;
import org.patriques.output.technicalindicators.SMA;
import org.patriques.output.technicalindicators.data.IndicatorData;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CheckPrice {
    public static double checkPrice(String symbol) {
        IEXCloudClient cloudClient = IEXTradingClient.create(new IEXCloudTokenBuilder().withPublishableToken(Keys.iexPublic).withSecretToken(Keys.iexPrivate).build());
        double price = cloudClient.executeRequest(new QuoteRequestBuilder().withSymbol(symbol).build()).getLatestPrice().doubleValue();
        return price;
    }

    public static double fiftyDaySMA(String symbol) throws Exception {
        String alphaVantageKey = Keys.alphaVantageKey;
        int timeout = 3000;
        AlphaVantageConnector apiConnector = new AlphaVantageConnector(alphaVantageKey, timeout);
        TechnicalIndicators technicalIndicators = new TechnicalIndicators(apiConnector);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        SMA response = technicalIndicators.sma(symbol, Interval.SIXTY_MIN, TimePeriod.of(1200), SeriesType.CLOSE);
        List<IndicatorData> indicatorData = response.getData();

        AtomicReference<Double> sma = new AtomicReference<>((double) 0);

        indicatorData.forEach(data -> {
            if (dtf.format(now).equals(data.getDateTime().toString())) {
                sma.set(data.getData());
            }
        });

        double fiftyDaySMA = sma.get();
        return fiftyDaySMA;
    }
}
