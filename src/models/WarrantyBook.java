package models;

public class WarrantyBook {
    private int id;
    private String vin;
    private int customerId;
    private String issueDate;
    private String expDate;

    public WarrantyBook(int id, String vin, int customerId, String issueDate, String expDate) {
        this.id = id;
        this.vin = vin;
        this.customerId = customerId;
        this.issueDate = issueDate;
        this.expDate = expDate;
    }

    public void checkWarranty() {
        System.out.println("Dang kiem tra han bao hanh cho xe: " + vin);
    }
}