package main.pojo;

public class Slot {

    int slotNo;
    String regNo ;
    String color;

    public Slot(int slotNo, String regNo, String color) {
        this.slotNo = slotNo;
        this.regNo = regNo;
        this.color = color;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
