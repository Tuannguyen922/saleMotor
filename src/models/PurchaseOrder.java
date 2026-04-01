package models;
public class PurchaseOrder {
    private int id;
    private String supplier;
    private String orderDate;
    private int totalAmount;
    private String status;

    public PurchaseOrder(int id, String supplier, String orderDate, int totalAmount) {
        this.id = id;
        this.supplier = supplier;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = "COMPLETED";
    }
}