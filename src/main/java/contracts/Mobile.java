package contracts;

import fields.Vat;

public class Mobile extends Contract {

    // contracts.Mobile contract fields
    private int dataAmount; // in MB
    private int smsAmount; // in individual messages

    public Mobile(Vat vatNumber, String CU_UUID) {
        super(vatNumber, CU_UUID);
    }

    public int getDataAmount() {
        return dataAmount;
    }

    public void setDataAmount(int dataAmount) {
        this.dataAmount = dataAmount;
    }

    public int getSmsAmount() {
        return smsAmount;
    }

    public void setSmsAmount(int smsAmount) {
        this.smsAmount = smsAmount;
    }
}
