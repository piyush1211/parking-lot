package main.dao.repo;

import main.pojo.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class ParkingLotRepo {

    private static ParkingLotRepo single_instance = null;

    public static ParkingLotRepo getInstance() {
        if (single_instance == null)
            single_instance = new ParkingLotRepo();

        return single_instance;
    }

    public TreeSet<Integer> getAvailableSlot() {
        return availableSlot;
    }

    public void setAvailableSlot(TreeSet<Integer> availableSlot) {
        this.availableSlot = availableSlot;
    }

    public TreeSet<Integer> getUnAvailableSlot() {
        return unAvailableSlot;
    }

    public void setUnAvailableSlot(TreeSet<Integer> unAvailableSlot) {
        this.unAvailableSlot = unAvailableSlot;
    }

    public TreeMap<Integer, Slot> getSlotWiseParkingDetail() {
        return slotWiseParkingDetail;
    }

    public void setSlotWiseParkingDetail(TreeMap<Integer, Slot> slotWiseParkingDetail) {
        this.slotWiseParkingDetail = slotWiseParkingDetail;
    }

    public TreeMap<String, Slot> getRegNoWiseParkingDetail() {
        return regNoWiseParkingDetail;
    }

    public void setRegNoWiseParkingDetail(TreeMap<String, Slot> regNoWiseParkingDetail) {
        this.regNoWiseParkingDetail = regNoWiseParkingDetail;
    }

    public TreeMap<String, Slot> getColorWiseParkingDetail() {
        return colorWiseParkingDetail;
    }

    public void setColorWiseParkingDetail(TreeMap<String, Slot> colorWiseParkingDetail) {
        this.colorWiseParkingDetail = colorWiseParkingDetail;
    }

    private ParkingLotRepo() {
        availableSlot = new TreeSet<>();
        unAvailableSlot = new TreeSet<>();
        slotWiseParkingDetail = new TreeMap<>();
        regNoWiseParkingDetail = new TreeMap<>();
        colorWiseParkingDetail = new TreeMap<>();
    }

    TreeSet<Integer> availableSlot;
    TreeSet<Integer> unAvailableSlot;
    TreeMap<Integer, Slot> slotWiseParkingDetail;
    TreeMap<String, Slot> regNoWiseParkingDetail;
    TreeMap<String, Slot> colorWiseParkingDetail;

}
