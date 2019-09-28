package main.dao.repo;

import main.pojo.Slot;

import java.util.*;

public class ParkingLotDao {

    ParkingLotRepo parkinglotRepo = ParkingLotRepo.getInstance();

    public TreeSet<Integer> getAvailableSlotFromRepo() {
        return parkinglotRepo.getAvailableSlot();
    }

    public void putInDB(Slot slot) {
        parkinglotRepo.getSlotWiseParkingDetail().put(
                slot.getSlotNo(), slot
        );
        parkinglotRepo.getRegNoWiseParkingDetail().put(
                slot.getRegNo(), slot
        );
        parkinglotRepo.getColorWiseParkingDetail().put(
                slot.getColor() + slot.getSlotNo(), slot
        );
    }

    public TreeSet<Integer> getUnAvailableSlots() {
        return parkinglotRepo.getUnAvailableSlot();
    }

    public void removeFromDB(int slotNo) {
        Slot slot = parkinglotRepo.getSlotWiseParkingDetail().get(slotNo);
        if (slot != null) {
            parkinglotRepo.getSlotWiseParkingDetail().remove(slot.getSlotNo());
            parkinglotRepo.getRegNoWiseParkingDetail().remove(slot.getRegNo());
            parkinglotRepo.getColorWiseParkingDetail().remove(slot.getColor() + slot.getSlotNo());
        } else {
            System.out.println("this car is not parked");
        }
    }

    public Slot getSlotDetail(int slotNo) {
        return parkinglotRepo.getSlotWiseParkingDetail().get(slotNo);
    }

    public Map<Integer, Slot> getAllFilledParkingSlot() {
        return parkinglotRepo.getSlotWiseParkingDetail();
    }

    public List<String> getRegNoByColor(String color) {
        List<String> regNoList = new ArrayList<>();
        for (Map.Entry<Integer, Slot> entry : parkinglotRepo.getSlotWiseParkingDetail().entrySet()) {
            Integer slotNo = entry.getValue().getSlotNo();
            Slot slot = parkinglotRepo.getColorWiseParkingDetail().get(color + slotNo);
            if (slot != null) {
                regNoList.add(slot.getRegNo());
            }
        }
        return regNoList;
    }

    public List<Integer> getSlotNoByColor(String color) {
        List<Integer> slotNoList = new ArrayList<>();
        for (Map.Entry<Integer, Slot> entry : parkinglotRepo.getSlotWiseParkingDetail().entrySet()) {
            Integer slotNo = entry.getValue().getSlotNo();
            Slot slot = parkinglotRepo.getColorWiseParkingDetail().get(color + slotNo);
            if (slot != null) {
                slotNoList.add(slot.getSlotNo());
            }
        }
        return slotNoList;

    }

    public Slot getSlotNumberByRegNo(String regNo) {
        return parkinglotRepo.getRegNoWiseParkingDetail().get(regNo);

    }
}
