package App.Domain;

public class SpecialEquipUses {
    private int equipId;
    private String equipName;
    private int equipAmount;
    private double equipPrice;

    public void setEquipId(int equipId) {
        this.equipId = equipId;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName;
    }

    public void setEquipAmount(int equipAmount) {
        this.equipAmount = equipAmount;
    }

    public void setEquipPrice(double equipPrice) {
        this.equipPrice = equipPrice;
    }

    public int getEquipId() {
        return this.equipId;
    }

    public String getEquipName() {
        return this.equipName;
    }

    public int getEquipAmount() {
        return this.equipAmount;
    }

    public double getEquipPrice() {
        return this.equipPrice;
    }

}
