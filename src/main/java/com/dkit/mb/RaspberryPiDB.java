package com.dkit.mb;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class RaspberryPiDB
{
    private ArrayList<RaspberryPi> pisList;

    public RaspberryPiDB(){this.pisList = new ArrayList<>();}

    public void printPis()
    {
        for(int i = 0; i < pisList.size(); i++)
        {
            System.out.println(pisList.get(i));
        }
    }


    protected void loadRaspberryPisFromFile()
    {
        System.out.println("Reading Raspberry Pis from file...");

        try {
            Scanner studentsFile = new Scanner(new File("RaspberryPis.txt"));

            while (studentsFile.hasNext())
            {

                String manufacturer = studentsFile.next();
                String cpu = studentsFile.next();
                String ram_size = studentsFile.next();
                int ramSize = Integer.parseInt(ram_size);
                String disk_size = studentsFile.next();
                int diskSize = Integer.parseInt(disk_size);
                String Sweight = studentsFile.next();
                double weight = Double.parseDouble(Sweight);
                String assetTag = studentsFile.next();
                String purchaseDate = studentsFile.next();
                String gpioPins = studentsFile.next();
                int gpio_Pins = Integer.parseInt(gpioPins);
                String SdCardSize = studentsFile.next();
                int sdCardSize = Integer.parseInt(SdCardSize);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate purchaseTime = LocalDate.parse(purchaseDate, formatter);

                System.out.println("Manufacturer: " + manufacturer + " Cpu: " + cpu + " Ram size: " + ramSize + "gb Disk size: " + diskSize + "gb weight: " + weight +  "kg Asset Tag: " + assetTag + " Purchase date: " + purchaseDate + " GPIO PINS: " + gpioPins + " Sd Card Size: " + sdCardSize + "gb");

                pisList.add( new RaspberryPi(manufacturer, cpu, ramSize, diskSize, weight, assetTag, purchaseTime, gpio_Pins, sdCardSize));

            }
            System.out.println("All Raspberry Pis loaded");
            studentsFile.close();
            System.out.println("All Raspberry Pis: " + pisList); // print them all

        }
        catch (IOException e)
        {
            System.out.println("IOException thrown in loadRaspberryPisFromFile() "+e.getMessage());
        }

    }



}
