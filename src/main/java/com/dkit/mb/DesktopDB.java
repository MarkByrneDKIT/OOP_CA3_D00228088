package com.dkit.mb;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class DesktopDB
{
    private ArrayList<Desktop> desktopsList;

    public DesktopDB(){this.desktopsList = new ArrayList<>();}

    public void printDesktops()
    {
        for(int i = 0; i < desktopsList.size(); i++)
        {
            System.out.println(desktopsList.get(i));
        }
    }


    protected void loadDesktopsFromFile()
    {
        System.out.println("Reading Desktops from file...");

        try {
            Scanner studentsFile = new Scanner(new File("Desktops.txt"));

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
                String monitor_size = studentsFile.next();
                int monitorSize = Integer.parseInt(monitor_size);


                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate purchaseTime = LocalDate.parse(purchaseDate, formatter);

                System.out.println("Manufacturer: " + manufacturer + " Cpu: " + cpu + " Ram size: " + ramSize + "gb Disk size: " + diskSize + "gb weight: " + weight + "kg Asset Tag: " + assetTag + " Purchase date: " + purchaseDate + " Monitor size: " + monitorSize + "inches");

                desktopsList.add( new Desktop(manufacturer, cpu, ramSize, diskSize, weight, assetTag, purchaseTime, monitorSize));

            }
            System.out.println("All Desktops loaded");
            studentsFile.close();
            System.out.println("All Desktops: " + desktopsList); // print them all

        }
        catch (IOException e)
        {
            System.out.println("IOException thrown in loadDesktopsFromFile() "+e.getMessage());
        }

    }
}
