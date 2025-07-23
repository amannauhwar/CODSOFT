package src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import org.json.JSONObject;


public class CurrencyConverter {
    public static void main(String[] args) throws IOException{
        HashMap<Integer, String> currencyCodes = new HashMap<Integer,String>();
        
        currencyCodes.put(1, "USD"); // United States Dollar
        currencyCodes.put(2, "EUR"); // Euro
        currencyCodes.put(3, "JPY"); // Japanese Yen
        currencyCodes.put(4, "GBP"); // British Pound Sterling
        currencyCodes.put(5, "AUD"); // Australian Dollar
        currencyCodes.put(6, "CAD"); // Canadian Dollar
        currencyCodes.put(7, "CHF"); // Swiss Franc
        currencyCodes.put(8, "CNY"); // Chinese Yuan Renminbi
        currencyCodes.put(9, "INR"); // Indian Rupee
        currencyCodes.put(10, "BRL"); // Brazilian Real
        currencyCodes.put(11, "RUB"); // Russian Ruble
        currencyCodes.put(12, "KRW"); // South Korean Won
        currencyCodes.put(13, "MXN"); // Mexican Peso
        currencyCodes.put(14, "SGD"); // Singapore Dollar
        currencyCodes.put(15, "HKD"); // Hong Kong Dollar
        currencyCodes.put(16, "NZD"); // New Zealand Dollar
        currencyCodes.put(17, "SEK"); // Swedish Krona
        currencyCodes.put(18, "NOK"); // Norwegian Krone
        currencyCodes.put(19, "ZAR"); // South African Rand
        currencyCodes.put(20, "TRY"); // Turkish Lira

        String fromCode, toCode;
        double amount;

        Scanner sc = new Scanner(System.in);

        System.out.println("****************************************Welcome to the currency converter!*********************************************");

        System.out.println("> Currency converting from?");

        System.out.println("1:USD (US Dollar)\t 2:EUR (Euro)\t 3:JPY (Japanese Yen)\t 4:GBP (British Pound Sterling)\t 5:AUD (Australian Dollar)\t 6:CAD (Canadian Dollar)\t 7:CHF (Swiss Franc)\t 8:CNY (Chinese Yuan Renminbi)\t 9:INR (Indian Rupee)\t 10:BRL (Brazilian Real)\t 11:RUB (Russian Ruble)\t 12:KRW (South Korean Won)\t 13:MXN (Mexican Peso)\t 14:SGD (Singapore Dollar)\t 15:HKD (Hong Kong Dollar)\t 16:NZD (New Zealand Dollar)\t 17:SEK (Swedish Krona)\t 18:NOK (Norwegian Krone)\t 19:ZAR (South African Rand)\t 20:TRY (Turkish Lira)");

        fromCode = currencyCodes.get(sc.nextInt());

        System.out.println("> Currency converting to?");

        System.out.println("1:USD (US Dollar)\t 2:EUR (Euro)\t 3:JPY (Japanese Yen)\t 4:GBP (British Pound Sterling)\t 5:AUD (Australian Dollar)\t 6:CAD (Canadian Dollar)\t 7:CHF (Swiss Franc)\t 8:CNY (Chinese Yuan Renminbi)\t 9:INR (Indian Rupee)\t 10:BRL (Brazilian Real)\t 11:RUB (Russian Ruble)\t 12:KRW (South Korean Won)\t 13:MXN (Mexican Peso)\t 14:SGD (Singapore Dollar)\t 15:HKD (Hong Kong Dollar)\t 16:NZD (New Zealand Dollar)\t 17:SEK (Swedish Krona)\t 18:NOK (Norwegian Krone)\t 19:ZAR (South African Rand)\t 20:TRY (Turkish Lira)");

        toCode = currencyCodes.get(sc.nextInt());
        
        System.out.println("Amount you want to convert?");
        amount = sc.nextDouble();

        sendHttpGetRequest(fromCode, toCode, amount);

    }

    private static void sendHttpGetRequest(String fromCode, String toCode, double amount) throws IOException {
        String Get_Url = "https://cdn.jsdelivr.net/npm/@fawazahmed0/currency-api@latest/v1/currencies/" + fromCode.toLowerCase() + ".json";

        URL url = new URL(Get_Url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if(responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }in.close();


            JSONObject obj = new JSONObject(response.toString());

            JSONObject baseCurrencyRates = obj.getJSONObject(fromCode.toLowerCase());

            Double exchangeRate = baseCurrencyRates.getDouble(toCode.toLowerCase());

            System.out.println("Exchange Rate (1 " + fromCode.toUpperCase() + " to " + toCode.toUpperCase() + "): " + exchangeRate);

            System.out.println();

            System.out.printf("%.2f %s = %.2f %s%n", amount, fromCode.toUpperCase(), amount * exchangeRate, toCode.toUpperCase());
        }
        else{
            System.out.println("GET request has failed!");
        }
    }
}