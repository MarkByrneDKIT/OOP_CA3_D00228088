package com.dkit.mb;

public class RaspberryPi extends Computer
{
    private int GPIO_pins;
    private int sd_card_size;

    public RaspberryPi(int GPIO_pins, int sd_card_size)
    {
        this.GPIO_pins = GPIO_pins;
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

}
