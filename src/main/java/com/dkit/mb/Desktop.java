package com.dkit.mb;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Desktop extends Computer
{
    private int monitor_size;
    private ArrayList<Desktop> desktopsList;

    public Desktop(String manufacturer, String cpu, int ram_size, int disk_size, double weight, String asset_tag, LocalDate purchase_date, int monitor_size) {
        super(manufacturer, cpu, ram_size, disk_size, weight, asset_tag, purchase_date);
        this.monitor_size = monitor_size;
    }


    public int getMonitor_size() {
        return monitor_size;
    }

    public void setMonitor_size(int monitor_size) {
        this.monitor_size = monitor_size;
    }



    @Override
    public String toString() {
        return "Desktop{" + super.toString() +
                "monitor_size=" + monitor_size +
                '}';
    }
}
