package com.dkit.mb;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class BookingDB
{

    private ArrayList<Booking> bookingList;

    public BookingDB()
    {
        this.bookingList = new ArrayList<>();
    }



    public Booking findBookingById(int id) {
        for(Booking b : bookingList ) {
            if(b.getBooking_id() == id)
                return b;
        }
        return null;    // not found
    }

    public void addBooking(Booking booking) //TODO prevent duplicates
    {
        bookingList.add(booking);
    }

    public void printBookings()
    {
        for(int i = 0; i < bookingList.size(); i++)
        {
            System.out.println(bookingList.get(i));
        }
    }

    public void removeBookingById(int id)
    {
        Booking booking = findBookingById(id);      //TODO check for null id
        if(booking != null)
        {
            bookingList.remove(booking);
        }
    }

    protected void loadBookingsFromFile()
    {
        System.out.println("Reading student DB from file...");

        try {
            Scanner studentsFile = new Scanner(new File("Bookings.txt"));

            while (studentsFile.hasNext())
            {


                String b_id = studentsFile.next();
                int booking_id = Integer.parseInt(b_id);
                String booking_time = studentsFile.next();
                String return_time = studentsFile.next();
                String computer_type = studentsFile.next();
                String computer_asset_tag = studentsFile.next();
                String student_id = studentsFile.next();

                System.out.println("Booking ID: " + booking_id + " Booking Time: " + booking_time + " Return Time: " + return_time + " Computer Type: " + computer_type + " Computer Asset Tag: " + computer_asset_tag + " Student ID: " + student_id);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate bookingTime = LocalDate.parse(booking_time, formatter);
                LocalDate returnTime = LocalDate.parse(return_time, formatter);

                bookingList.add( new Booking(booking_id,bookingTime,returnTime,computer_type,computer_asset_tag,student_id));

            }
            System.out.println("All students loaded");
            studentsFile.close();
            System.out.println("All Students: " + bookingList); // print them all

        } catch (IOException e)
        {
            System.out.println("IOException thrown in loadStudentsFromFile() "+e.getMessage());
        }

    }






}


