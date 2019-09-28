package main.service;

import main.dao.repo.ParkingLotDao;
import main.dao.repo.ParkingLotRepo;
import main.pojo.Slot;

import java.util.List;
import java.util.Map;

public class ParkingService {

    ParkingLotDao parkingLotDao = new ParkingLotDao();

    public void parkTheCar(String regNo, String color) {
        Integer slotNo = parkingLotDao.getAvailableSlotFromRepo().pollFirst();
        if (slotNo == null) {
            System.out.println("Sorry , parking lot is full");
            return;
        }
        parkingLotDao.getUnAvailableSlots().add(slotNo);
        Slot slot = new Slot(slotNo, regNo, color);
        parkingLotDao.putInDB(slot);
        System.out.println("Allocated slot number :" + slotNo);
    }

    public void releaseTheCar(int slotNo) {
        parkingLotDao.removeFromDB(slotNo);
        parkingLotDao.getAvailableSlotFromRepo().add(slotNo);
        System.out.println("Slot number " + slotNo + " is free.");
    }

    public void displayCurrentParkingStatus() {
        System.out.println("Slot No \t" + "Registration No \t" + "Colour ");
        for (Map.Entry<Integer, Slot> slotEntry : parkingLotDao.getAllFilledParkingSlot().entrySet()) {
            int slotNo = slotEntry.getKey();
            Slot slot = parkingLotDao.getSlotDetail(slotNo);
            System.out.println(slotNo + "\t\t\t" + slot.getRegNo() + "\t\t" + slot.getColor());
        }
    }

    public void getSlotNumberByRegNo(String regNo) {
        Slot slot = parkingLotDao.getSlotNumberByRegNo(regNo);
        if (slot == null)
            System.out.println("not found");
        else
            System.out.println(slot.getSlotNo());
    }

    public void getSlotNoByColor(String color) {
        if (!parkingLotDao.getSlotNoByColor(color).isEmpty())
            System.out.println(parkingLotDao.getSlotNoByColor(color));
        else
            System.out.println("not found");
    }

    public void getRegNoByColor(String color) {
        if (!parkingLotDao.getRegNoByColor(color).isEmpty())
            System.out.println(parkingLotDao.getRegNoByColor(color));
        else
            System.out.println("not found");
    }
}
