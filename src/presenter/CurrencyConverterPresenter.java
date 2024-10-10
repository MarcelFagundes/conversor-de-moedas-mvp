package presenter;

import model.CurrencyConverter;
import view.CurrencyConverterView;

public class CurrencyConverterPresenter {

    private CurrencyConverterView view;
    private CurrencyConverter model;
    private DataValidator validator;

    public CurrencyConverterPresenter(CurrencyConverterView view, CurrencyConverter model, DataValidator validator) {
        this.view = view;
        this.model = model;
        this.validator = validator;
    }

    public void performConversion() {
        String fromCurrency;
        do {
            fromCurrency = view.getFromCurrency();
            if (!validator.isValidCurrencyCode(fromCurrency)) {
                view.displayError("Código da moeda de origem inválido. Por favor, insira um código de 3 letras, ex: USD, BRL, JPY, GBP.");
            }
        } while (!validator.isValidCurrencyCode(fromCurrency));

        String toCurrency;
        do {
            toCurrency = view.getToCurrency();
            if (!validator.isValidCurrencyCode(toCurrency)) {
                view.displayError("Código da moeda de destino inválido. Por favor, insira um código de 3 letras, ex: USD, BRL, JPY, GBP.");
            }
        } while (!validator.isValidCurrencyCode(toCurrency));

        double amount;
        do {
            amount = view.getAmount();
            if (!validator.isValidAmount(amount)) {
                view.displayError("O valor deve ser um número positivo.");
            }
        } while (!validator.isValidAmount(amount));

        try {
            double convertedAmount = model.convertCurrency(fromCurrency, toCurrency, amount);
            view.displayResult(amount, fromCurrency, convertedAmount, toCurrency);
        } catch (Exception e) {
            view.displayError(e.getMessage());
        }
    }
}
