package models;

public class SaleOrderDetail {
    private int id;
    private int orderId;
    private String vin;
    private int salePrice;

    public SaleOrderDetail(int id, int orderId, String vin, int salePrice) {
        this.id = id;
        this.orderId = orderId;
        this.vin = vin;
        this.salePrice = salePrice;
    }
}