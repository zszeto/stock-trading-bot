import java.util.TimerTask;

public class SellTimer extends TimerTask {

    @Override
    public void run() {
        try {
            Trading.autoSell("PTON");
            Trading.autoSell("AAPL");
            Trading.autoSell("TSLA");
            Trading.autoSell("PLTR");
            Trading.autoSell("WFC");
            Trading.autoSell("FCEL");
            Trading.autoSell("GE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
