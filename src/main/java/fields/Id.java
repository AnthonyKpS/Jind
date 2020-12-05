package fields;

import java.util.Objects;

public class Id
{
    private final String id;

    public Id(String id) {
        if (isValid(id))
            this.id = id;
        else
            throw new IllegalArgumentException("Not a valid ID number.");
    }

    /**
     * Checks if an id is a valid ID number.
     *  Rule: A 2-letter block and a 6-digit block. | src: https://el.wikipedia.org/wiki/%CE%94%CE%B5%CE%BB%CF%84%CE%AF%CE%BF_%CE%B1%CF%83%CF%84%CF%85%CE%BD%CE%BF%CE%BC%CE%B9%CE%BA%CE%AE%CF%82_%CF%84%CE%B1%CF%85%CF%84%CF%8C%CF%84%CE%B7%CF%84%CE%B1%CF%82_(%CE%95%CE%BB%CE%BB%CE%AC%CE%B4%CE%B1)
     * @param id Id to be checked.
     * @return True if id is a valid number.
     */
    private boolean isValid(String id) {
        if (id.length() == 8) {

            // Check prefix
            String prefix = id.substring(0,2);
            for (int i = 0; i < prefix.length(); i++) {
                if (!Character.isLetter(id.charAt(i)))
                    return false;
            }

            // Check postfix
            String postfix = id.substring(2, 8);
            try {
                Double.parseDouble(postfix);
            } catch (NumberFormatException e) {
                return false;
            }

            // If checks pass
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Id id1 = (Id) o;
        return Objects.equals(id, id1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}