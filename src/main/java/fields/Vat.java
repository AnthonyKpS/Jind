package fields;

import java.util.Objects;

public class Vat {
    private final String vat;

    public Vat(String vat) {
        if (isValid(vat))
            this.vat = vat;
        else
            throw new IllegalArgumentException("Not a valid VAT number.");
    }

    /**
     * Checks if a number is a valid Greek VAT number.
     *  Rule: A 9-digit block. | src: https://ec.europa.eu/taxation_customs/vies/faqvies.do
     * @param num Number to be checked.
     * @return True if the number is a valid VAT number.
     */
    private boolean isValid(String num) {
        if (num.length() == 9)
            try {
                Double.parseDouble(num);
                return true;
            } catch (NumberFormatException ignored) {
                return false;
            }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vat vat1 = (Vat) o;
        return Objects.equals(vat, vat1.vat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vat);
    }

    @Override
    public String toString() {
        return vat;
    }
}