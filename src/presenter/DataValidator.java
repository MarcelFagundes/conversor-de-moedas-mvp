package presenter;

public class DataValidator {

    /**
     * Valida se o valor é um número positivo.
     * @param amount O valor a ser validado.
     * @return true se o valor for válido, false caso contrário.
     */
    public boolean isValidAmount(double amount) {
        return amount > 0;
    }

    /**
     * Valida se o código da moeda está no formato correto (por exemplo, 3 letras).
     * @param currency O código da moeda a ser validado.
     * @return true se o código for válido, false caso contrário.
     */
    public boolean isValidCurrencyCode(String currency) {
        return currency != null && currency.matches("^[A-Z]{3}$");
    }
}
