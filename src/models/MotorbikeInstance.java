package models;
public class MotorbikeInstance {
    private String vin; 
    private String engineNumber;
    private int versionId;
    private String status;
    private String importDate;

    public MotorbikeInstance(String vin, String engineNumber, int versionId, String importDate) {
        this.vin = vin;
        this.engineNumber = engineNumber;
        this.versionId = versionId;
        this.importDate = importDate;
        this.status = "IN_STOCK"; 
    }

    // Method cũng phải có thân hàm { }
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    // Đừng quên tạo Getter để Service có thể lấy dữ liệu
    public String getVin() {
        return vin;
    }
}