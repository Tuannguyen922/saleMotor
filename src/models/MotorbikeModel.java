package models;
public class MotorbikeModel {
    private int modelId;
    private String modelName;
    private String branch;
    private String type;
    private String description;

    public MotorbikeModel(int modelId, String modelName, String branch) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.branch = branch;
    }

    // Getter và Setter
    public String getModelName() { return modelName; }
}