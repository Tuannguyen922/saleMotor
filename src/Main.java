// Bước 1: Import các class từ package models vào để sử dụng
import models.MotorbikeInstance;
import models.MotorbikeModel;
import models.MotorbikeVersion;
import models.MotorImportService;
import models.PurchaseOrder;
import models.SaleOrder;
import models.SaleOrderDetail;
import models.WarrantyBook;
import services.CustomerService;


// java.time.localDate
public class Main {
    public static void main(String[] args) {
        System.out.println("--- KHOI DONG HE THONG QUAN LY CUA HANG XE MAY ---\n");

        //b1: khoi tao du lieu
        System.out.println("--- 1. Khoi tao danh muc xe ---");
        // Constructor: modelId, modelName, branch
        MotorbikeModel modelVision = new MotorbikeModel(1, "Vision", "Honda");
        MotorbikeModel modelExciter = new MotorbikeModel(2, "Exciter", "Yamaha");

        // Constructor: id, modelId, versionName, color, basePrice
        MotorbikeVersion visionCaoCap = new MotorbikeVersion(101, 1, "Vision Cao Cấp", "Xanh đen", 35000000);
        MotorbikeVersion exciter155 = new MotorbikeVersion(102, 2, "Exciter 155 VVA", "Xanh GP", 50000000);
        System.out.println("-> Da tao danh muc Model va Version thanh cong!\n");

        //b2: nhap kho
        System.out.println("--- 2. Nhap xe vao kho ---");
        MotorImportService importService = new MotorImportService();
        
        // Tạo hóa đơn nhập hàng từ nhà cung cấp
        // Constructor: id, supplier, orderDate, totalAmount
        PurchaseOrder po1 = new PurchaseOrder(1001, "Honda Vietnam", "2026-04-01", 70000000);
        importService.doPurchase(po1);

        // Tạo các instance của xe (thực tế nhập về kho)
        // Constructor: vin, engineNumber, versionId, importDate (Status tự động là IN_STOCK)
        MotorbikeInstance bike1 = new MotorbikeInstance("VIN-V01", "ENG-V001", 101, "2026-04-01");
        MotorbikeInstance bike2 = new MotorbikeInstance("VIN-E01", "ENG-E001", 102, "2026-04-01");
        
        importService.importMotor(bike1);
        importService.importMotor(bike2);
        System.out.println("-> Da nhap kho 2 chiec xe.");
        System.out.println("-> Ma VIN xe 1: " + bike1.getVin() + " | Trang thai: IN_STOCK\n");

        //b3: quan ly khach hang
        System.out.println("--- 3. Tiep nhan khach hang ---");
        CustomerService customerService = new CustomerService();
        
        // Constructor: id, identityCard, fullName, phone
        Customer customer1 = new Customer(1, "079012345678", "Thiago", "0901234567");
        customerService.addCustomer(customer1);
        System.out.println("-> Da luu thong tin khach hang moi: Thiago\n");

        //b4: quan ly khach hang
        System.out.println("--- 4. Xu ly đơn ban hang ---");
        // Thiago quyết định mua chiếc Vision (VIN-V01)
        // Constructor SaleOrder: id, customerId, orderDate, totalAmount (PaymentStatus tự động PAID)
        SaleOrder saleOrder = new SaleOrder(5001, 1, "2026-04-04", 36000000);
        
        // Constructor SaleOrderDetail: id, orderId, vin, salePrice
        SaleOrderDetail orderDetail = new SaleOrderDetail(1, saleOrder.getId(), bike1.getVin(), 36000000);
        
        // Cập nhật trạng thái chiếc xe đã bán thành SOLD
        bike1.updateStatus("SOLD");
        System.out.println("-> Da xuat hoa đon #" + saleOrder.getId() + " cho chiec xe: " + orderDetail.getVin());
        System.out.println("-> Trang thai xe " + bike1.getVin() + " tren he thong da cap nhat thanh: SOLD\n");

        //b5: quan ly bao hanh
        System.out.println("--- 5. Cap so va ghi nhan lich su bao hanh ---");
        // Constructor WarrantyBook: id, vin, customerId, issueDate, expDate
        WarrantyBook warrantyBook = new WarrantyBook(1, bike1.getVin(), 1, "2026-04-04", "2029-04-04");
        
        System.out.print("-> ");
        warrantyBook.checkWarranty(); // Gọi hàm in ra "Dang kiem tra han bao hanh..."

        // Một tháng sau, khách mang xe đến bảo dưỡng định kỳ
        // Constructor WarrantyVisit: id, warrantyBookId, visitDate, kmReading, description
        WarrantyVisit visit1 = new WarrantyVisit(1, 1, "2026-05-04", 1000, "Bảo dưỡng lần 1, thay nhớt định kỳ");
        visit1.setTechnicianNotes("Xe chay em, đong co va phanh hoat đong tot.");
        
        System.out.println("-> Ghi nhan lich su: " + visit1.getDescription());
        
        System.out.println("\n=== HOAN TAT DEMO LUONG CHINH CUA CHUONG TRINH ===");
    }
}