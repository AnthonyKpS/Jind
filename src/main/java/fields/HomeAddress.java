package fields;

import java.util.regex.Pattern;

public class HomeAddress {
    private final String homeAddress;

    public HomeAddress(String homeAddress) {
        if (isValid(homeAddress))
            this.homeAddress = homeAddress;
        else
            throw new IllegalArgumentException("Not a valid Home Address");
    }

    private boolean isValid(String address) {
        Pattern pattern = Pattern.compile(
                "^([a-zA-Z]+,)\\s(\\d+)"
        );
        return address.matches(String.valueOf(pattern));
    }

    @Override
    public String toString() {
        return homeAddress;
    }
}
