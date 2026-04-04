// Bước 1: Import các class từ package models vào để sử dụng
import models.MotorbikeInstance;
import models.MotorbikeModel;
import models.MotorbikeVersion;
import services.MotorImportService;
import models.PurchaseOrder;
import models.SaleOrder;
import models.SaleOrderDetail;
import models.WarrantyBook;
import models.WarrantyVisit;
import services.CustomerService;
import java.sql.Date;

// java.time.localDate
public class Main {
    public static void main(String[] args) {
        // --- TẠO DỮ LIỆU TEST ---

        // 1. Tạo xe (Cần tạo Model -> Version -> Instance)
        MotorbikeModel visionModel = new MotorbikeModel("M01", "Vision", "Honda", "Tay ga", "Xe pho thong");
        MotorbikeVersion visionBlue = new MotorbikeVersion(101, "Xanh Đen", "110cc", "35000000", visionModel);
        
        Date today = Date.valueOf("2026-04-05");
        MotorbikeInstance bike1 = new MotorbikeInstance("VIN-V01", "ENG-001", visionBlue, today);
        MotorbikeInstance bike2 = new MotorbikeInstance("VIN-V02", "ENG-002", visionBlue, today);

        // Đưa xe vào kho thông qua service
        MotorImportService inventory = new MotorImportService();
        inventory.addMotorbike(bike1);
        inventory.addMotorbike(bike2);

        // 2. Tạo khách hàng
        // Constructor: fullName, phone, id, identityCard, dateOfBirth, address, email
        Customer thiago = new Customer("Thiago", "0901234567", 1, "079012345678", "2004-01-01", "Da Nang", "thiago@email.com");
        CustomerService customerService = new CustomerService();
        customerService.addCustomer(thiago);

        // 3. Giả lập mua bán
        System.out.println("--- GIA LAP MUA BAN ---");
        // Khách hàng Thiago mua xe có mã VIN-V01
        inventory.sellMotorbike("VIN-V01", thiago);

        // --- IN OUTPUT ---
        System.out.println("\nDanh sach xe:");
        inventory.showKho();
    }
}