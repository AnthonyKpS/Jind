package fields;

public enum Status {
    STUDENT,
    INDIVIDUAL,
    ENTERPRISE;

    /**
     * Checks if a number is a valid STATUS code code.
     * @param code Code to be checked.
     * @return True if the code is a valid STATUS code
     */
    public static boolean isStatusValid(int code) {
        return (code >= 0 && code <=2);
    }

}
