package com.dkit.mb;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Laptop extends Computer
{
    private int screen_size;
    private double battery_life;
    private ArrayList<Laptop> laptopsList;

    public double getBattery_life() { return battery_life; }

    public void setBattery_life(double battery_life) { this.battery_life = battery_life; }

    public int getScreen_size() { return screen_size; }

    public void setScreen_size(int screen_size) { this.screen_size = screen_size; }

    public Laptop(String manufacturer, String cpu, int ram_size, int disk_size, double weight, String asset_tag, LocalDate purchase_date, int screen_size, double battery_life) {
        super(manufacturer, cpu, ram_size, disk_size, weight, asset_tag, purchase_date);
        this.screen_size = screen_size;
        this.battery_life = battery_life;
    }





    @Override
    public String toString() {
        return "Laptop{" + super.toString() +
                "screen_size=" + screen_size +
                ", battery_life=" + battery_life +
                '}';
    }
}
