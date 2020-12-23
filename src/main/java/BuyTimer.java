import java.util.TimerTask;

public class BuyTimer extends TimerTask {

    @Override
    public void run() {
        try {
            Trading.autoBuy("PTON", BuyAmount.buyAmount("PTON"));
            Trading.autoBuy("AAPL", BuyAmount.buyAmount("AAPL"));
            Trading.autoBuy("TSLA", BuyAmount.buyAmount("TSLA"));
            Trading.autoBuy("PLTR", BuyAmount.buyAmount("PLTR"));
            Trading.autoBuy("WFC", BuyAmount.buyAmount("WFC"));
            Trading.autoBuy("FCEL", BuyAmount.buyAmount("FCEL"));
            Trading.autoBuy("GE", BuyAmount.buyAmount("GE"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}