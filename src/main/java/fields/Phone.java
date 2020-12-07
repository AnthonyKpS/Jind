package fields;

import java.util.Objects;

public class Phone {
    private final String phone;

    public Phone(String phone) {
        if (isValid(phone))
            this.phone = phone;
        else
            throw new IllegalArgumentException("Not a valid PHONE number.");
    }

    /**
     * Check if a number is a valid Greek Phone number.
     *  Rule: A 10-digit block where 2 first two digits should be 69 (cells)
     *  or 21 through 28 (landlines) | src: https://en.wikipedia.org/wiki/Telephone_numbers_in_Greece
     * @param num Number to be checked
     * @return True if the number is a valid Greek phone number.
     */
    private boolean isValid(String num) {
        if (num.length() == 10) {
            int prefix;
            try {
                prefix = Integer.parseInt(num.substring(0, 2));
            } catch (NumberFormatException e) {
                return false;
            }
            return prefix == 69 || (prefix >= 21 && prefix <= 28);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone1 = (Phone) o;
        return Objects.equals(phone, phone1.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone);
    }

    @Override
    public String toString() {
        return phone;
    }
}