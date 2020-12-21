package fields;

public enum ContractDuration {
    ONE_YEAR,
    TWO_YEAR;

    /**
     * Checks if a given contracts.Contract Duration is either of value 0 (=1 year contract)
     * or 1 (=2 years contract)
     * @param duration Duration to be checked
     * @return true if Duration is valid
     */
    public static boolean isContractDurationValid(int duration) {
        return (duration == 0 || duration == 1);
    }
}
