package com.dkit.mb;

import java.time.LocalDateTime;

public class RaspberryPi extends Computer
{
    private int GPIO_pins;
    private int sd_card_size;

    public RaspberryPi(String manufacturer, String cpu, int ram_size, int disk_size, double weight, String asset_tag, LocalDateTime purchase_date, int GPIO_pins, int sd_card_size)
    {
        super(manufacturer, cpu, ram_size, disk_size, weight, asset_tag, purchase_date);
        this.GPIO_pins = GPIO_pins;
        this.sd_card_size = sd_card_size;
    }


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

    @Override
    public String toString() {
        return "RaspberryPi{" + super.toString() +
                "GPIO_pins=" + GPIO_pins +
                ", sd_card_size=" + sd_card_size +
                '}';
    }
}
