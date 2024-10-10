package model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class CurrencyConverter {

    private static final String API_KEY = "sua-chave-api-aqui";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    private HttpClient client;
    private Gson gson;

    public CurrencyConverter() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) throws Exception {
        String requestUrl = API_URL + fromCurrency + "/" + toCurrency;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("Erro na API de conversão de moedas");
        }

        ExchangeRateResponse exchangeRateResponse = gson.fromJson(response.body(), ExchangeRateResponse.class);

        return amount * exchangeRateResponse.getConversion_rate();
    }
}