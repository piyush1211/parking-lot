package main;

import java.io.*;

public class ParkingLot {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;


        System.out.println("what you do, File or Interactive");
        line = in.readLine();

        if (line.equalsIgnoreCase("F")) {
            getDataByFile();
        } else if (line.equalsIgnoreCase("I")) {
            getDataByCommands();
        }

    }

    private static void getDataByCommands() throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String cmd;

        System.out.println("Please type command");

        while ((cmd = in.readLine()) != null) {
            System.out.println("command= " + cmd);
            ParkingLotManager parkingLotManager = new ParkingLotManager();
            parkingLotManager.decideAction(cmd);
            System.out.println();
        }
    }


    private static void getDataByFile() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String path;


        System.out.println("Please type file name");
        path = in.readLine();
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            System.out.println("command " + st);
            ParkingLotManager parkingLotManager = new ParkingLotManager();
            parkingLotManager.decideAction(st);
            System.out.println();
        }
    }


}


