package main.service;

import main.dao.repo.ParkingLotDao;
import main.dao.repo.ParkingLotRepo;

public class CreateParkingLot {

    ParkingLotDao parkingLotDao = new ParkingLotDao();

    public void initialize(int n) {
        for (int i = 1  ; i <=n ;i++) {
            parkingLotDao.getAvailableSlotFromRepo().add(i);
        }

        System.out.println("created a parking lot with " + n + " slots");
    }
}
