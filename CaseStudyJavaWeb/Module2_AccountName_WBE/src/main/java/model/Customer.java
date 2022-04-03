package model;

public class Customer extends  Person{
    private int type;

    public Customer() {
    }
    public Customer(int personalID) {
        super(personalID);
    }

    public Customer(int personalID,
                    String name,
                    String dOB,
                    boolean gender,
                    String idCard,
                    String phoneNumber,
                    String email,
                    String address,
                    int type) {
        super(personalID, name, dOB, gender, idCard, phoneNumber, email, address);
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
