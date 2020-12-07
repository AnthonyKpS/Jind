package contracts;

import fields.TypeOfConnection;

public class Landline {

    // Landline contract fields
    private TypeOfConnection typeOfConnection;
    private int connectionSpeed = 0;

    public Landline(TypeOfConnection typeOfConnection) {
        this.typeOfConnection = typeOfConnection;
        switch (typeOfConnection) {
            case ADSL -> connectionSpeed = 24;
            case VDSL -> connectionSpeed = 50;
        };
    }

    public TypeOfConnection getTypeOfConnection() {
        return typeOfConnection;
    }

    public void setTypeOfConnection(TypeOfConnection typeOfConnection) {
        this.typeOfConnection = typeOfConnection;
    }

    public int getConnectionSpeed() {
        return connectionSpeed;
    }
}
