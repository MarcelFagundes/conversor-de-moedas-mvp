package view;

public interface CurrencyConverterView {
    String getFromCurrency();
    String getToCurrency();
    double getAmount();
    void displayResult(double amount, String fromCurrency, double convertedAmount, String toCurrency);
    void displayError(String message);
}
