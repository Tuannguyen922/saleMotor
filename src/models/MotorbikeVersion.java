package models;
public class MotorbikeVersion {
    private int id;
    private int modelId;
    private String versionName;
    private String color;
    private String engineCapacity;
    private int basePrice;

    public MotorbikeVersion(int id, int modelId, String name, String color, int price) {
        this.id = id;
        this.modelId = modelId;
        this.versionName = name;
        this.color = color;
        this.basePrice = price;
    }

    // Getter

}