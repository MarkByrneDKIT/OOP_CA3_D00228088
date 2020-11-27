package com.dkit.mb;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    private static Scanner keyboard = new Scanner(System.in);
    public static void main( String[] args )
    {
        System.out.println( "Welcome to the Computer Loaning System" );

        MenuOptions selectOption = MenuOptions.CONTINUE;

        while(selectOption != MenuOptions.QUIT)
        {
            try
            {
                menu();
                selectOption = MenuOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];

                switch (selectOption)
                {
                    case Add_STUDENT:
                        String pcs[] = {"DK-001", "DK-002"};
                        Student s1 = new Student("John Reilly", "1000", "johnreilly7@gmail.com", "0879211657", pcs);
                        System.out.println(s1.toString());
                        break;
                    case ADD_BOOKING:
                        //when doing scanning in add asset tag of booking to student profile with same student id.

                        Booking b1 = new Booking(LocalDateTime.now(), "Dell", "DK-001", "1000");
                        Booking b2 = new Booking(LocalDateTime.now(), "AMD", "DK-002", "1001");
                        System.out.println(b1.toString());
                        System.out.println(b2.toString());
                        break;
                    case PRINT_ALL_BOOKINGS:
//                        printBookings()
                        break;
                    case AVERAGE_LENGTH_OF_BOOKINGS:
//                        printAVGLenght()
                        break;
                    case PRINT_STATISTICS:
//                        printStatistics()
                        break;
                    case QUIT:
                        break;
                    default:
                        System.out.println("Selection out of range. Try again");

                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Selection out of range. Please try again.");
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Selection out of range. Please try again.");
            }
        }
    }
    private static void createBank ()
    {
    }
    private static void menu ()
    {
        System.out.println("\n Enter: ");
        System.out.println(("\t1. Add a Student"));
        System.out.println(("\t2. Add a Booking"));
        System.out.println(("\t3. Print all Bookings"));
        System.out.println(("\t4. Print Average Length of Bookings"));
        System.out.println(("\t5. Print Statistics"));
        System.out.println(("\t6. Quit"));
        System.out.print(("\n Selection ->"));
        System.out.println();
    }
}

