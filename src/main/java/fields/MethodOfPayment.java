package fields;

public enum MethodOfPayment {
    BY_CARD,
    WITH_CASH,
    WITH_DEPOSIT;

    /**
     * Checks if a given Method of Payment code is either of value 0 (=Payment by card),
     * 1 (=Payment with cash) or 2 (=Payment with deposit).
     * @param code Code to be checked.
     * @return true if Code is valid.
     */
    public static boolean isMethodOfPaymentValid(int code) {
        return (code >= 0 && code <=2);
    }
}
