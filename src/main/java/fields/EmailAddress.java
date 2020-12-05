package fields;

import java.util.regex.Pattern;

public class EmailAddress {
    private final String emailAddress;

    public EmailAddress(String emailAddress) {
        if (isValid(emailAddress))
            this.emailAddress = emailAddress;
        else
            throw new IllegalArgumentException("Not a valid EMAIL Address.");
    }

    /**
     * Checks if a String is a valid EMAIL address.
     *  Rule: regex src: https://www.regular-expressions.info/email.html
     * @param address Address to be checked.
     * @return True if the address is a valid EMAIL address.
     */
    private boolean isValid(String address) {
        Pattern pattern = Pattern.compile(
                "[a-zA-Z0-9+._%-+]{1,256}" +
                        "@" +
                        "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" +
                        "(" +
                        "." +
                        "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" +
                        ")+"
        );
        return address.matches(String.valueOf(pattern));
    }

    @Override
    public String toString() {
        return emailAddress;
    }
}
