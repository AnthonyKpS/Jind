import fields.*;

import java.util.Scanner;

public class FieldsTest {

    Scanner stdin = new Scanner(System.in);

    // VAT number check.
    public void vatCheck() {
        boolean validity = false;
        System.out.print("Please provide a valid VAT number (e.g 999999999): ");
        Vat vatNum = null;
        while (!validity) {
            String input = stdin.nextLine();
            System.out.println("");
            try {
                vatNum = new Vat(input);
                validity = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.print("Please try again: ");
            }
        }
    }

    // ID number check.
    public void idCheck() {
        boolean validity = false;
        System.out.print("Please provide a valid ID number (e.g AN920921): ");
        Id idNum = null;
        while (!validity) {
            String input = stdin.nextLine();
            System.out.println("");
            try {
                idNum = new Id(input);
                validity = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.print("Please try again: ");
            }
        }
    }

    // EMAIL address check.
    public void emailAddressCheck() {
        boolean validity = false;
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
    }

    // HOME address check
    public void homeAddressCheck() {
        boolean validity = false;
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
    }

    // STATUS code check
    public void statusCheck() {
        boolean validity = false;
        System.out.print("Please provide a valid STATUS code (0 = STUDENT, 1 = INDIVIDUAL, 2 = PROFESSIONAL): ");
        while (!validity) {
            String input = stdin.nextLine();
            System.out.println("");
            try {
                int code = Integer.parseInt(input);
                if (Status.isStatusValid(code)) {
                    validity = true;
                    Status status;
                    switch (code) {
                        case 0:
                            status = Status.STUDENT;
                            break;
                        case 1:
                            status = Status.INDIVIDUAL;
                            break;
                        case 2:
                            status = Status.ENTERPRISE;
                            break;
                        default:
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number.");
                System.out.print("Please try again: ");
        }
    }
}

    public static void main(String[] args) {
        FieldsTest test = new FieldsTest();
        test.vatCheck();
        test.idCheck();
        test.emailAddressCheck();
        test.homeAddressCheck();
        test.statusCheck();
    }
}