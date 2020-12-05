import fields.*;

import java.util.UUID;

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

    public String getUUID() {
        return UUID;
    }

    public Vat getVatNum() {
        return vatNum;
    }

    public Id getIdNum() {
        return idNum;
    }

    public Customer(Vat vatNum, Id idNum) {
        this.vatNum = vatNum;
        this.idNum = idNum;
    }

    public HomeAddress getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(HomeAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
