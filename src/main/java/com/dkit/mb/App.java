package com.dkit.mb;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    private static Scanner keyboard = new Scanner(System.in);
    public static void main( String[] args )
    {
        System.out.println( "Welcome to the Computer Loaning System" );

        BookingDB bookingDB = new BookingDB();
        bookingDB.loadBookingsFromFile();


        StudentDB studentDB = new StudentDB();
        studentDB.loadStudentsFromFile();


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
                        System.out.println("Please enter the name of the student you wish to add: ");
                        String studentName = keyboard.next();

                        System.out.println("Please enter the student's ID: ");
                        int studentID = keyboard.nextInt();

                        System.out.println("Please enter the student's email:  ");

                        System.out.println("Please enter the student's telephone number: ");

                        System.out.println("Please enter the number of pcs the student has loan: ");
                        int numOfPcs = keyboard.nextInt();

                        break;
                    case ADD_BOOKING:
                        //when doing scanning in add asset tag of booking to student profile with same student id.

                        break;


                    case FIND_AND_EDIT_STUDENT:

                        EditingStudentMenuOptions selection = EditingStudentMenuOptions.CONTINUE;

                        while(selection != EditingStudentMenuOptions.QUIT_MENU)
                        {
                            try
                            {
                                editingStudentMenu();
                                selection = EditingStudentMenuOptions.values()[Integer.parseInt(keyboard.nextLine().trim())];

                                switch (selection)
                                {
                                    case FIND_STUDENT:
                                        System.out.println("Please Enter the ID od the student you wish to find e.g 1000,1001 etc : ");
                                        int id = keyboard.nextInt();
                                        //Student selectedStudent =  studentDB.findStudentByID(id);
                                        //System.out.println(selectedStudent);
                                        break;
                                    case EDIT_NAME:
                                        //selectedStudent.setName();
                                        break;

                                    case DELETE_NAME:

                                        break;

                                    case EDIT_EMAIL:
                                        //selectedStudent.setEmail();
                                        break;

                                    case DELETE_EMAIL:

                                        break;

                                    case EDIT_TELEPHONE:
                                        //selectedStudent.setTelephone();
                                        break;

                                    case DELETE_TELEPHONE:

                                        break;

                                    case REMOVE_STUDENT_FROM_SYSTEM:
                                        //studentDB.removeStudentById(id);
                                        break;

                                    case QUIT_MENU:

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

                        break;

                    case PRINT_ALL_STUDENTS:
                        studentDB.printStudents();
                        break;


                    case PRINT_ALL_BOOKINGS:
                        bookingDB.printBookings();
                        break;



                    case AVERAGE_LENGTH_OF_BOOKINGS:
//                        printAVGLength()
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

    private static void menu ()
    {
        System.out.println("\n Enter: ");
        System.out.println(("\t1. Add a Student"));
        System.out.println(("\t2. Add a Booking"));
        System.out.println(("\t3. Find and Edit Student"));
        System.out.println(("\t4. Print all Students"));
        System.out.println(("\t5. Print all Bookings"));
        System.out.println(("\t6. Print Average Length of Bookings"));
        System.out.println(("\t7. Print Statistics"));
        System.out.println(("\t8. Quit"));
        System.out.print(("\n Selection ->"));
        System.out.println();
    }

    private static void editingStudentMenu()
    {
        System.out.println("-----Editing Menu for Student-----");
        System.out.println("\t1. Edit Name");
        System.out.println("\t2. Delete Name");
        System.out.println("\t3. Edit Email");
        System.out.println("\t4. Delete Email");
        System.out.println("\t5. Edit Telephone");
        System.out.println("\t6. Delete Telephone");
        System.out.println("\t7 Remove Student from System");
        System.out.println("\t8. Quit");
        System.out.print(("\n Selection ->"));
        System.out.println();

    }
}

