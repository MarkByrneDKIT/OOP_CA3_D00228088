package com.dkit.mb;

import java.time.LocalDate;

public class Booking
{
    private static int count = 1000;
    private  int booking_id;
    private LocalDate booking_time;
    private LocalDate return_time;
    private String computer_type;
    private String computer_asset_tag;
    private String student_id;



    public Booking(LocalDate booking_time, LocalDate return_time, String computer_type, String computer_asset_tag, String student_id)
    {
        booking_id = count + 1;
        count ++;
        this.booking_time = booking_time;
        this.computer_type = computer_type;
        this.computer_asset_tag = computer_asset_tag;
        this.student_id = student_id;
    }

    public Booking(int b_id, LocalDate booking_time,LocalDate return_time, String computer_type, String computer_asset_tag, String student_id)
    {
        this.booking_id = b_id;
        this.booking_time = booking_time;
        this.return_time = return_time;
        this.computer_type = computer_type;
        this.computer_asset_tag = computer_asset_tag;
        this.student_id = student_id;
    }




    public int getBooking_id() { return booking_id; }

    public void setBooking_id(int booking_id) { this.booking_id = booking_id; }

    public String getStudent_id() { return student_id; }

    public void setStudent_id(String student_id) { this.student_id = student_id; }

    public String getComputer_asset_tag() {
        return computer_asset_tag;
    }

    public void setComputer_asset_tag(String computer_asset_tag) {
        this.computer_asset_tag = computer_asset_tag;
    }

    public String getComputer_type() {
        return computer_type;
    }

    public void setComputer_type(String computer_type) {
        this.computer_type = computer_type;
    }

    public LocalDate getReturn_time() {
        return return_time;
    }

    public void setReturn_time(LocalDate return_time) {
        this.return_time = return_time;
    }

    public LocalDate getBooking_time() {
        return booking_time;
    }

    public void setBooking_time(LocalDate booking_time) {
        this.booking_time = booking_time;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "booking_id=" + booking_id +
                ", booking_time=" + booking_time +
                ", return_time=" + return_time +
                ", computer_type='" + computer_type + '\'' +
                ", computer_asset_tag='" + computer_asset_tag + '\'' +
                ", student_id='" + student_id + '\'' +
                '}';
    }


    
}
