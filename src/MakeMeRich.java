
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class MakeMeRich {
	
	final static String API_KEY = "CF29OUGWGVGADAEA";
	
	public static final List<String> symbols = Arrays.asList("AMD", "HPQ",
			"IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE", "AMZN", "CRAY", "CSCO",
			"SNE", "GOOG", "INTC", "INTU", "MSFT", "ORCL", "TIBX", "VRSN",
			"YHOO");

	public static void main(String[] args) throws IOException {

//		// 1. Print these symbols using a Java 8 for-each and lambdas
//		
//		symbols.stream().forEach(sym -> System.out.print(sym + "\n "));
//
//		// 2. Use the StockUtil class to print the price of Bitcoin
//		
//		double priceOfBc = StockUtil.prices.get("BTC-USD");
//		System.out.println(priceOfBc);
//
//		// 3. Create a new List of StockInfo that includes the stock price
//		
//		List<StockInfo> newListWithPrice = new ArrayList<StockInfo>();
//		for (String s : symbols) {
//			newListWithPrice.add(StockUtil.getPrice(s));
//		}
//		System.out.println(newListWithPrice);
//	
//		// 4. Find the highest-priced stock under $500
//		
//		StockInfo highestPricedUnder500 = newListWithPrice.stream().filter(StockUtil.isPriceLessThan(500))
//				.reduce(StockUtil::pickHigh).get();
//		
//		System.out.println(highestPricedUnder500 + " has highest price under 500");
		
		String symbol = "BTC-USD";
		String chosenDate = "2019-10-09";
		System.out.println(LiveStockData(symbol, chosenDate));
	}
		
		private static String LiveStockData(String symbol, String chosenDate) throws IOException {
			
		String rootURL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY";
		rootURL += "&symbol=" + symbol;
		rootURL += "&apikey=" + API_KEY;
		//System.out.println(rootURL);
		
		URL request = new URL(rootURL);
		String response = IOUtils.toString(request.openStream());
		//System.out.println(response);
		
		JSONObject root = new JSONObject(response);
		JSONObject perDay = (JSONObject) root.get("Time Series (Daily)");
		JSONObject date = (JSONObject) perDay.get(chosenDate);
		
		return 	(String) date.get("4. close");

		}
	}


