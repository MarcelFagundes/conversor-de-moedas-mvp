package view;

import java.util.Scanner;

public class ConsoleCurrencyConverterView implements CurrencyConverterView {

    private Scanner scanner;

    public ConsoleCurrencyConverterView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getFromCurrency() {
        System.out.println("Seja bem-vindo ao Conversor de Moedas\n ");
        System.out.print("Digite a moeda de origem, ex: USD, BRL, JPY, GBP: ");
        return scanner.nextLine().toUpperCase();
    }

    @Override
    public String getToCurrency() {
        System.out.print("Digite a moeda de destino, ex: USD, BRL, JPY, GBP: ");
        return scanner.nextLine().toUpperCase();
    }

    @Override
    public double getAmount() {
        System.out.print("Digite o valor que deseja converter: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, insira um número válido.");
            scanner.next();
        }
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consumir a quebra de linha restante
        return amount;
    }

    @Override
    public void displayResult(double amount, String fromCurrency, double convertedAmount, String toCurrency) {
        System.out.printf("%.2f %s é igual a %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);

    }

    @Override
    public void displayError(String message) {
        System.out.println("Erro: " + message);
    }

    public void closeScanner() {
        scanner.close();
    }
}