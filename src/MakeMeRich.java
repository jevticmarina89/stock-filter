
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class MakeMeRich {
	public static final List<String> symbols = Arrays.asList("AMD", "HPQ",
			"IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE", "AMZN", "CRAY", "CSCO",
			"SNE", "GOOG", "INTC", "INTU", "MSFT", "ORCL", "TIBX", "VRSN",
			"YHOO");

	public static void main(String[] args) {

		// 1. Print these symbols using a Java 8 for-each and lambdas
		
		symbols.stream().forEach(sym -> System.out.print(sym + "\n "));

		// 2. Use the StockUtil class to print the price of Bitcoin
		
		double priceOfBc = StockUtil.prices.get("BTC-USD");
		System.out.println(priceOfBc);

		// 3. Create a new List of StockInfo that includes the stock price
		
		List<StockInfo> newListWithPrice = new ArrayList<StockInfo>();
		for (String s : symbols) {
			newListWithPrice.add(StockUtil.getPrice(s));
		}
		System.out.println(newListWithPrice);
	
		// 4. Find the highest-priced stock under $500
		
		StockInfo highestPricedUnder500 = newListWithPrice.stream().filter(StockUtil.isPriceLessThan(500))
				.reduce(StockUtil::pickHigh).get();
		
		System.out.println(highestPricedUnder500 + " has highest price under 500");
	
	}

}
