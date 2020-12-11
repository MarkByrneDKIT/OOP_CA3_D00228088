package com.dkit.mb;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class LaptopDB
{
    private ArrayList<Laptop> laptopsList;

    public LaptopDB(){this.laptopsList= new ArrayList<>();}

    public void printLaptops()
    {
        for(int i = 0; i < laptopsList.size(); i++)
        {
            System.out.println(laptopsList.get(i));
        }
    }


    protected ArrayList<Laptop> loadLaptopsFromFile()
    {
        System.out.println("Reading Laptops from file...");

        try {
            Scanner studentsFile = new Scanner(new File("Laptops.txt"));

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
                String sSize = studentsFile.next();
                int screenSize= Integer.parseInt(sSize);
                String batLife = studentsFile.next();
                int batteryLife = Integer.parseInt(batLife);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate purchaseTime = LocalDate.parse(purchaseDate, formatter);

                System.out.println("Manufacturer: " + manufacturer + " Cpu: " + cpu + " Ram size: " + ramSize + "gb Disk size: " + diskSize + "gb weight: " + weight + "kg Asset Tag: " + assetTag + " Purchase date: " + purchaseDate + " Screen Size: " + screenSize + "inches BatteryLife: " + batteryLife + "hours");

                laptopsList.add( new Laptop(manufacturer, cpu, ramSize, diskSize, weight, assetTag, purchaseTime, screenSize, batteryLife));

            }
            System.out.println("All Laptops loaded");
            studentsFile.close();
            System.out.println("All Laptops: " + laptopsList); // print them all


        }
        catch (IOException e)
        {
            System.out.println("IOException thrown in loadLaptopsFromFile() "+e.getMessage());
        }
        return laptopsList;
    }



}
