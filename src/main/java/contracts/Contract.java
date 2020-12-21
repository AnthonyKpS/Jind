package contracts;

import fields.ContractDuration;
import fields.MethodOfPayment;
import fields.Phone;
import fields.Vat;

import java.util.Date;

public class Contract {

    // contracts.Contract fields
    private final String UUID = "CO" + java.util.UUID.randomUUID().toString(); // CO prefix for Contracts

    private Vat vatNumber;
    private String CU_UUID;

    private Phone phoneNumber;

    private int minutesToLandline;
    private int minutesToMobile;

    private Date startDate;
    private ContractDuration duration;

    private boolean isDigital;

    private MethodOfPayment methodOfPayment;

    public Contract(Vat vatNumber, String CU_UUID) {
        this.vatNumber = vatNumber;
        this.CU_UUID = CU_UUID;
    }

    /**
     * Checks if a startDate of a {@link Contract} is valid.
     *
     * @param startDate Date to be checked.
     * @return True if the given Date is AFTER the current date.
     */
    public boolean isStartDateValid(Date startDate) {
        Date currentDate = new Date();
        return (startDate.after(currentDate));
    }

    public static boolean isIsDigitalValid(String option) {
        return (option.equals("yes") || option.equals("no"));
    }

    public Phone getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Phone phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Vat getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(Vat vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getCU_UUID() {
        return CU_UUID;
    }

    public void setCU_UUID(String CU_UUID) {
        this.CU_UUID = CU_UUID;
    }

    public int getMinutesToLandline() {
        return minutesToLandline;
    }

    public void setMinutesToLandline(int minutesToLandline) {
        this.minutesToLandline = minutesToLandline;
    }

    public int getMinutesToMobile() {
        return minutesToMobile;
    }

    public void setMinutesToMobile(int minutesToMobile) {
        this.minutesToMobile = minutesToMobile;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setDuration(ContractDuration duration) {
        this.duration = duration;
    }

    public boolean isDigital() {
        return isDigital;
    }

    public void setDigital(boolean digital) {
        isDigital = digital;
    }

    public MethodOfPayment getMethodOfPayment() {
        return methodOfPayment;
    }

    public void setMethodOfPayment(MethodOfPayment methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
    }
}
