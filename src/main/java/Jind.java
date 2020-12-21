import fields.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Jind {

    // Array list that holds all the Customers
    ArrayList<Customer> customers;

    public Jind() {
        customers = new ArrayList<>();
    }

    public static void main(String[] args) {

    }

    /**
     * Creates a new {@link Customer} in the {@link ArrayList<Customer>}
     * if the given VAT and ID numbers are unique.
     *
     * @return true if the insertion was successful.
     */
    public boolean createCustomer() {

        System.out.println("Let's add a new customer...");

        Scanner stdin = new Scanner(System.in);
        boolean validity = false;
        boolean uniqueness = false;

        // Read the critical fields
        // VAT number
        System.out.print("Please provide a valid VAT number (e.g 999999999): ");
        Vat vatNum = null;
        while (!validity || !uniqueness) {
            String input = stdin.nextLine();
            System.out.println("");

            // Check for validity.
            try {
                vatNum = new Vat(input);
                validity = true;

                // If VAT is valid, check for Uniqueness.
                if (isVatUnique(vatNum))
                    uniqueness = true;
                else
                    System.out.print("VAT is not unique, please try again: ");

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.print("Please try again: ");
            }
        }

        // ID number
        validity = false;
        uniqueness = false;
        System.out.print("Please provide a valid ID number (e.g AN920921): ");
        Id idNum = null;
        while (!validity || !uniqueness) {
            String input = stdin.nextLine();
            System.out.println("");
            try {
                idNum = new Id(input);
                validity = true;

                // If ID is valid, check for Uniqueness.
                if (isIdUnique(idNum))
                    uniqueness = true;
                else
                    System.out.print("ID is not unique, please try again: ");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.print("Please try again: ");
            }
        }

        Customer newCustomer = new Customer(vatNum, idNum);

        // Non-critical fields
        // EMAIL address
        validity = false;
        System.out.print("Please provide a valid EMAIL address (e.g. name@domain.gr): ");
        EmailAddress emailAddress = null;
        while (!validity) {
            String input = stdin.nextLine();
            System.out.println("");
            try {
                emailAddress = new EmailAddress(input);
                validity = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.print("Please try again: ");
            }
        }
        newCustomer.setEmailAddress(emailAddress);

        // HOME address
        validity = false;
        System.out.print("Please provide a valid HOME address (e.g Kleopatras, 8): ");
        HomeAddress homeAddress = null;
        while (!validity) {
            String input = stdin.nextLine();
            System.out.println("");
            try {
                homeAddress = new HomeAddress(input);
                validity = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.print("Please try again: ");
            }
        }
        newCustomer.setHomeAddress(homeAddress);

        // STATUS
        validity = false;
        System.out.print("Please provide a valid STATUS code (0 = STUDENT, 1 = INDIVIDUAL, 2 = PROFESSIONAL): ");
        Status status = null;
        while (!validity) {
            String input = stdin.nextLine();
            System.out.println("");
            try {
                int code = Integer.parseInt(input);
                if (Status.isStatusValid(code)) {
                    validity = true;
                    status = switch (code) {
                        case 0 -> Status.STUDENT;
                        case 1 -> Status.INDIVIDUAL;
                        default -> Status.ENTERPRISE;
                    };
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number.");
                System.out.print("Please try again: ");
            }
        }
        newCustomer.setStatus(status);

        // Do the insertion
        customers.add(newCustomer);

        return true;
    }


    /**
     * Searches through the {@link ArrayList<Customer>} to see if a
     * given VAT number is unique.
     *
     * @param vat Vat number to be compared against Customers VAT numbers in {@link ArrayList<Customer>}
     * @return true if the given VAT number is unique.
     */
    private boolean isVatUnique(Vat vat) {
        // Traverse the ArrayList
        for (Customer customer : customers) {
            if (customer.getVatNum().equals(vat))
                return false;
        }
        return true;
    }

    /**
     * Searches through the {@link ArrayList<Customer>} to see if a
     * given ID number is unique.
     *
     * @param id ID number to be compared against Customers ID numbers in {@link ArrayList<Customer>}
     * @return true if the given ID number is unique.
     */
    private boolean isIdUnique(Id id) {
        // Traverse the ArrayList
        for (Customer customer : customers) {
            if (customer.getIdNum().equals(id))
                return false;
        }
        return true;
    }
}
