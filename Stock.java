package April_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stock {
    public static void main(String[] args) {
        String stockSymbol = "AAPL"; // Replace with the stock symbol you want to fetch

        try {
            // URL of Yahoo Finance for fetching stock data
            URL url = new URL("https://finance.yahoo.com/quote/" + stockSymbol);

            // Open the connection to the URL
            URLConnection connection = url.openConnection();

            // Set the User-Agent request header to mimic a web browser
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            // Read the response from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();

            // Parse the HTML content to extract the stock price
            String html = content.toString();
            // Implement your logic to extract the stock price from the HTML
            String price = getCurrentPrice(html);

            // Print the stock price
            System.out.println("Current price of " + stockSymbol + ": " + price);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Example method to extract the current price from HTML content
    private static String getCurrentPrice(String html) {
        // Regular expression pattern to match the stock price
        Pattern pattern = Pattern.compile("<span[^>]*data-value=\"32\">([\\d,]+\\.\\d{2})</span>");
        Matcher matcher = pattern.matcher(html);

        // Find the first match
        if (matcher.find()) {
            // Extract the price from the match
            return matcher.group(1);
        } else {
            return "Price not found";
        }
    }
}

