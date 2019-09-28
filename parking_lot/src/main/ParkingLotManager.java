package main;

import main.service.CreateParkingLot;
import main.service.ParkingService;

public class ParkingLotManager {
    ParkingService parkingService = new ParkingService();
    CreateParkingLot createParkingLot = new CreateParkingLot();

    public void decideAction(String st) {
        String[] commands = st.split(" ");
        switch (commands[0]) {
            case "create_parking_lot":
                createParkingLot.initialize(Integer.parseInt(commands[1]));
                break;
            case "park":
                parkingService.parkTheCar(commands[1], commands[2]);
                break;
            case "leave":
                parkingService.releaseTheCar(Integer.parseInt(commands[1]));
                break;
            case "status":
                parkingService.displayCurrentParkingStatus();
                break;
            case "registration_numbers_for_cars_with_colour":
                parkingService.getRegNoByColor(commands[1]);
                break;
            case "slot_number_for_registration_number":
                parkingService.getSlotNumberByRegNo(commands[1]);
                break;
            case "slot_numbers_for_cars_with_colour":
                parkingService.getSlotNoByColor(commands[1]);
                break;
            default:
                break;
        }
    }
}