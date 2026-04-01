package models;

public class WarrantyVisit {
    private int id;
    private int warrantyBookId;
    private String visitDate;
    private int kmReading;
    private String description;
    private String technicianNotes;

    public WarrantyVisit(int id, int warrantyBookId, String visitDate, int kmReading, String description) {
        this.id = id;
        this.warrantyBookId = warrantyBookId;
        this.visitDate = visitDate;
        this.kmReading = kmReading;
        this.description = description;
    }

    // Các hàm Getter/Setter cơ bản
    public void setTechnicianNotes(String notes) { this.technicianNotes = notes; }
    public String getDescription() { return description; }
}