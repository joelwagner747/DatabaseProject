package App.Domain;

public class SpecialEquip {
    private int equipId;
    private String equipName;
    private int equipQuantity;
    private double equipPrice;
    private String equipNote;

    public void setEquipId(int equipId) {
        this.equipId = equipId;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public void setEquipQuantity(int equipQuantity) {
        this.equipQuantity = equipQuantity;
    }

    public void setEquipPrice(double equipPrice) {
        this.equipPrice = equipPrice;
    }

    public void setEquipNote(String equipNote) {
        this.equipNote = equipNote;
    }

    public int getEquipId() {
        return this.equipId;
    }

    public String getEquipName() {
        return this.equipName;
    }

    public int getEquipQuantity() {
        return this.equipQuantity;
    }

    public double getEquipPrice() {
        return this.equipPrice;
    }

    public String getEquipNote() {
        return this.equipNote;
    }
}
