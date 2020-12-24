import net.jacobpeterson.alpaca.AlpacaAPI;
import net.jacobpeterson.alpaca.rest.exception.AlpacaAPIRequestException;

import static java.lang.Double.parseDouble;

public class AccountInfo {
    private static final String key = Keys.alpacaKeyID;
    private static final String secretKey = Keys.alpacaSecretKey;

    private static final AlpacaAPI alpacaAPI = new AlpacaAPI(key, secretKey, "https://paper-api.alpaca.markets");

    public static double buyPower() throws AlpacaAPIRequestException {
        double account = parseDouble(alpacaAPI.getAccount().getBuyingPower());
        return account;
    }
}
