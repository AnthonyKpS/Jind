package fields;

public enum TypeOfConnection {
    NO_CONNECTION,
    ADSL,
    VDSL;


    /**
     * Checks if a given Type of Connection is either of value 0 (=No connection), 1 (=ADSL type of connection),
     * 2 (=VDSL type of connection)
     * @param code to be checked.
     * @return true if Code is valid
     */
    public static boolean isTypeOfConnectionValid(int code) {
        return (code >= 0 && code <=2);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}