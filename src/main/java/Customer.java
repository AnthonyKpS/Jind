import fields.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Customer {

    // Customer fields
    private final String UUID = "CU" + java.util.UUID.randomUUID().toString(); // CU prefix for CUstomers

    // Critical fields
    private Vat vatNum;
    private Id idNum;

    // Non critical fields
    private HomeAddress homeAddress;
    private EmailAddress emailAddress;
    private Status status;
    private Contract contract;

    public Customer(Vat vatNum, Id idNum) {
        this.vatNum = vatNum;
        this.idNum = idNum;
    }

    public boolean createContract() {

        System.out.println("Let's add a new contract...");

        // Inherit the correct VAT and UUID values to the new Contract.
        contract = new Contract(vatNum, UUID);

        Scanner stdin = new Scanner(System.in);
        boolean validity = false;
        boolean uniqueness = false;

        // Start filling the other fields.

        // Phone number
        System.out.print("Please provide a valid PHONE number (e.g 6971872199 or 2103253256): ");
        Phone phoneNumber = null;
        String input;
        while (!validity) {
            input = stdin.nextLine();
            System.out.println("");

            // Check input's validity
            try {
                phoneNumber = new Phone(input);
                validity = true;

                // TODO: Check for uniqueness
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.print("Please try again: ");
            }
        }
        contract.setPhoneNumber(phoneNumber);

        // Minutes to Landline
        System.out.print("Please provide minutes of talking to LANDLINE: ");
        validity = false;
        int minutesToLandline = 0;
        while (!validity) {
            if (stdin.hasNextInt()) {
                minutesToLandline = stdin.nextInt();
                validity = true;
            } else
                System.out.print("Please try again: ");
        }
        contract.setMinutesToLandline(minutesToLandline);

        // Minutes to Landline
        System.out.print("Please provide minutes of talking to MOBILE: ");
        validity = false;
        int minutesToMobile = 0;
        while (!validity) {
            if (stdin.hasNextInt()) {
                minutesToMobile = stdin.nextInt();
                validity = true;
            } else
                System.out.print("Please try again: ");
        }
        contract.setMinutesToMobile(minutesToMobile);

        // Start date
        System.out.print("Please provide a valid starting date for your contract: ");
        validity = false;
        Date startDate = null;
        while (!validity) {
            input = stdin.nextLine();
            try {
                startDate = new SimpleDateFormat("dd/MM/yyyy").parse(input);
                if (contract.isStartDateValid(startDate))
                    validity = true;
            } catch (ParseException e) {
                System.out.println("That is not a valid date.");
                System.out.print("Please try again: ");
            }
        }
        contract.setStartDate(startDate);

        // Contract duration
        System.out.print("Please provide a valid Contract duration code (0 = 1year. 1 = 2years): ");
        validity = false;
        ContractDuration contractDuration = null;
        while (!validity) {
            input = stdin.nextLine();
            System.out.println("");
            try {
                int code = Integer.parseInt(input);
                if (ContractDuration.isContractDurationValid(code)) {
                    validity = true;
                    contractDuration = switch (code) {
                        case 0 -> ContractDuration.ONE_YEAR;
                        default -> ContractDuration.TWO_YEAR;
                    };
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number.");
                System.out.print("Please try again: ");
            }
        }
        contract.setDuration(contractDuration);

        // isDigital
        System.out.print("Should your account be digital ONLY? (yes or no): ");
        validity = false;
        boolean isDigital = false;
        while (!validity) {
            input = stdin.nextLine().toLowerCase(Locale.ROOT);
            if (Contract.isIsDigitalValid(input)) {
                validity = true;
                if (input.equals("yes")) {
                    isDigital = true;
                }
            } else {
                System.out.println("That's not a valid answer.");
                System.out.print("Please try again: ");
            }
        }
        contract.setDigital(isDigital);

        // Method of payment
        System.out.print("Select a method of payment (0 = by card, 1 = with cash, 2 = with deposit): ");
        validity = false;
        MethodOfPayment methodOfPayment;
        while (!validity) {
            input = stdin.nextLine();
            System.out.println("");
            try {
                int code = Integer.parseInt(input);
                if (MethodOfPayment.isMethodOfPaymentValid(code)) {
                    validity = true;
                    methodOfPayment = switch (code) {
                        case 0 -> MethodOfPayment.BY_CARD;
                        case 1 -> MethodOfPayment.WITH_CASH;
                        default -> MethodOfPayment.WITH_DEPOSIT;
                    };
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number: ");
                System.out.print("Please try again: ");
            }
        }

        // type of contract
        System.out.print("Choose your type of Contract (Landline or Mobile): ");



        return true;
    }


    /**
     * Setters
     */
    public void setHomeAddress(HomeAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    /**
     * Getters
     */
    public String getUUID() {
        return UUID;
    }

    public Vat getVatNum() {
        return vatNum;
    }

    public Id getIdNum() {
        return idNum;
    }

    public HomeAddress getHomeAddress() {
        return homeAddress;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public Status getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "UUID='" + UUID + '\'' +
                ", vatNum=" + vatNum +
                ", idNum=" + idNum +
                ", homeAddress=" + homeAddress +
                ", emailAddress=" + emailAddress +
                ", status=" + status +
                '}';
    }
}
