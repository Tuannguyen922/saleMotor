package models;

public class Customer {
    // Thuộc tính private để đảm bảo tính đóng gói
    private int id;
    private String identityCard;
    private String fullName;
    private String dateOfBirth;
    private String phone;
    private String address;
    private String email;

    // Constructor khởi tạo khách hàng mới
    public Customer(int id, String identityCard, String fullName, String phone) {
        this.id = id;
        this.identityCard = identityCard;
        this.fullName = fullName;
        this.phone = phone;
    }

    
}