package com.dkit.mb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
            System.out.println("All Bookings loaded");
            studentsFile.close();
            System.out.println("All Bookings: " + bookingList); // print them all

        } catch (IOException e)
        {
            System.out.println("IOException thrown in loadStudentsFromFile() "+e.getMessage());
        }




    }


    public void saveBookingsToFile()
    {
        try(BufferedWriter studentsFile = new BufferedWriter(new FileWriter("newBookings.txt") ))
        {
            for(Booking booking : bookingList)
            {
                studentsFile.write(booking.getBooking_id() +" " + booking.getBooking_time() + " " + booking.getReturn_time() + " " + booking.getComputer_type() + " " + booking.getComputer_asset_tag() + " " + booking.getStudent_id());
                studentsFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println("Could not save bookings.");
        }
    }


    public void getAvgBookingLength()
    {
        Long difference = Long.valueOf(0);
        Long count = Long.valueOf(0);


        for(Booking b : bookingList)
        {
            if(b.getReturn_time() != null)
            {
                count = count+1;
                difference = difference + Duration.between(b.getBooking_time().atStartOfDay(), b.getReturn_time().atStartOfDay()).toDays(); //use atStartofDay() to avoid seconds exception
            }

        }


        Long avg = difference / count;


        System.out.println("The average length of bookings is: " + avg + " days");
    }


    public void getStatistics()
    {
        int count_pis = 0;
        int count_laptops = 0;
        int count_desktops = 0;


        for(Booking b : bookingList)
        {
            if(b.getComputer_type().equals("Desktop"))
            {
                count_desktops += 1;
            }
            else if(b.getComputer_type().equals("Laptop"))
            {
                count_laptops += 1;
            }
            else
            {
                count_pis += 1;
            }
        }

        System.out.println("Total Desktops booked to date: " + count_desktops);
        System.out.println("Total Laptops booked to date: " + count_laptops);
        System.out.println("Total Raspberry Pis booked to date: " + count_pis);
    }


    public Booking findBookingByID(int id)
    {
        for(Booking b : bookingList) {
            if (b.getBooking_id() == id) {
                System.out.println("Booking found!");
                return b;
            }
        }
        return null;
    }


}


