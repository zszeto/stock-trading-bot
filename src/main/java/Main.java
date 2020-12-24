import net.jacobpeterson.alpaca.rest.exception.AlpacaAPIRequestException;

import java.util.Timer;

public class Main {
    public static void main(String[] args) throws AlpacaAPIRequestException {
Timer timer = new Timer();
timer.schedule(new SellTimer(), 0,3600000);

while(AccountInfo.buyPower()>50000) {
    timer.schedule(new BuyTimer(), 0, 3600000);
}
    }
}
