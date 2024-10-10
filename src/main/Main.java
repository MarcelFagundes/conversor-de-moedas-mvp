package main;
import model.CurrencyConverter;
import presenter.CurrencyConverterPresenter;
import presenter.DataValidator;
import view.ConsoleCurrencyConverterView;
import view.CurrencyConverterView;

public class Main {
    public static void main(String[] args) {
        CurrencyConverterView view = new ConsoleCurrencyConverterView();
        CurrencyConverter model = new CurrencyConverter();
        DataValidator validator = new DataValidator();
        CurrencyConverterPresenter presenter = new CurrencyConverterPresenter(view, model, validator);

        presenter.performConversion();

        // Fechar o scanner para evitar vazamento de recursos
        if (view instanceof ConsoleCurrencyConverterView) {
            ((ConsoleCurrencyConverterView) view).closeScanner();
        }
    }
}