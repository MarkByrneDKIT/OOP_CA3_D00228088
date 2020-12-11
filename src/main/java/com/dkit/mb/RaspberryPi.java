package com.dkit.mb;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class RaspberryPi extends Computer
{
    private int GPIO_pins;
    private int sd_card_size; //in gbs
    private ArrayList<RaspberryPi> raspberryPis;

    public RaspberryPi(String manufacturer, String cpu, int ram_size, int disk_size, double weight, String asset_tag, LocalDate purchase_date, int GPIO_pins, int sd_card_size)
    {
        super(manufacturer, cpu, ram_size, disk_size, weight, asset_tag, purchase_date);
        this.GPIO_pins = GPIO_pins;
        this.sd_card_size = sd_card_size;
    }
/*
    public RaspberryPi()
    {this.raspberryPis = new ArrayList<>();}


 */
    public int getSd_card_size() {
        return sd_card_size;
    }

    public void setSd_card_size(int sd_card_size) {
        this.sd_card_size = sd_card_size;
    }

    public int getGPIO_pins() {
        return GPIO_pins;
    }

    public void setGPIO_pins(int GPIO_pins) {
        this.GPIO_pins = GPIO_pins;
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

                raspberryPis.add( new RaspberryPi(manufacturer, cpu, ramSize, diskSize, weight, assetTag, purchaseTime, gpio_Pins, sdCardSize));

            }
            System.out.println("All students loaded");
            studentsFile.close();
            System.out.println("All Students: " + raspberryPis); // print them all

        }
        catch (IOException e)
        {
            System.out.println("IOException thrown in loadStudentsFromFile() "+e.getMessage());
        }

    }







    @Override
    public String toString() {
        return "RaspberryPi{" + super.toString() +
                "GPIO_pins=" + GPIO_pins +
                ", sd_card_size=" + sd_card_size +
                '}';
    }
}
