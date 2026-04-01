package models;

public class SaleOrder {
    private int id;
    private int customerId;
    private String orderDate;
    private int totalAmount;
    private String paymentStatus;

    public SaleOrder(int id, int customerId, String orderDate, int totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.paymentStatus = "PAID";
    }

    // Getters
    public int getId() { return id; }
}