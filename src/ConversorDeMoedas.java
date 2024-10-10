import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.Gson;

public class ConversorDeMoedas {

    private static final String API_KEY = "sua-chave-api-aqui";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    // Classe para representar a resposta JSON da API
    static class ExchangeRateResponse {
        double conversion_rate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a moeda de origem, ex: USD, BRL, JPL, GBP: ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.println("Digite a moeda de destino, ex: USD, BRL, JPL, GBP: ");
        String toCurrency = scanner.nextLine().toUpperCase();

        System.out.println("Digite o valor que deseja converter: ");
        double amount = scanner.nextDouble();

        try {
            double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);
            System.out.printf("%.2f %s é igual a %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (Exception e) {
            System.out.println("Erro ao converter a moeda: " + e.getMessage());
        }

        scanner.close();
    }

    private static double convertCurrency(String fromCurrency, String toCurrency, double amount) throws Exception {
        String requestUrl = API_URL + fromCurrency + "/" + toCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("Erro na API de conversão de moedas");
        }

        // Usar Gson para converter a resposta JSON em um objeto Java
        Gson gson = new Gson();
        ExchangeRateResponse exchangeRateResponse = gson.fromJson(response.body(), ExchangeRateResponse.class);

        // Retorna o valor convertido
        return amount * exchangeRateResponse.conversion_rate;
    }
}