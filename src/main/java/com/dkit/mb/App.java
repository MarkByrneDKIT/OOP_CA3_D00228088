package com.dkit.mb;



import java.time.LocalDate;
import java.util.Scanner;

public class App
{
    private static Scanner keyboard = new Scanner(System.in);
    private static Scanner kb = new Scanner(System.in);
    public static void main( String[] args )
    {
        System.out.println( "Welcome to the Computer Loaning System" );

        BookingDB bookingDB = new BookingDB();
        bookingDB.loadBookingsFromFile();
        System.out.println("------------------------------------------------------------------------------------------");
        StudentDB studentDB = new StudentDB();
        studentDB.loadStudentsFromFile();
        System.out.println("-------------------------------------------------------------------------------------------");
        LaptopDB laptopsDB = new LaptopDB();
        laptopsDB.loadLaptopsFromFile();
        System.out.println("-------------------------------------------------------------------------------------------");
        DesktopDB desktopsDB = new DesktopDB();
        desktopsDB.loadDesktopsFromFile();
        System.out.println("-------------------------------------------------------------------------------------------");
        RaspberryPiDB pisDB = new RaspberryPiDB();
        pisDB.loadRaspberryPisFromFile();




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
                        String studentName = kb.next();

                        System.out.println("Please enter the student's ID: ");
                        String studentID = kb.next();

                        System.out.println("Please enter the student's email:  ");
                        String email = kb.next();

                        System.out.println("Please enter the student's telephone number: ");
                        String telephone = kb.next();

                        String[] pcsOnLoan = {};

                        Student newStudent = new Student(studentName, studentID, email, telephone, pcsOnLoan);
                        studentDB.addStudent(newStudent);

                        break;
                    case ADD_BOOKING:
                        //when doing scanning in add asset tag of booking to student profile with same student id.
                        System.out.println("Please enter the date (YYYY-MM-DD): ");
                        String bookingTime = kb.next();
                        LocalDate booking_time = LocalDate.parse(bookingTime);
                        LocalDate returnTime = null;
                        System.out.println("PLease enter computer type (laptop/desktop/raspberry pi): ");
                        String computerType = kb.next();


                                if (computerType.toUpperCase().equals("DESKTOP"))
                                {
                                    System.out.println("Desktops available:");
                                    desktopsDB.printDesktops();

                                } else if (computerType.toUpperCase().equals("LAPTOP"))
                                {
                                    System.out.println("laptops available:");
                                    laptopsDB.printLaptops();

                                } else if (computerType.toUpperCase().equals("RASPBERRY PI"))
                                {
                                    System.out.println("Raspberry Pis available:");
                                    pisDB.printPis();

                                } else {
                                    System.out.println("Incorrect computer type " + computerType.toUpperCase());

                                }


                        System.out.println("Please enter computer asset tag that you wish to borrow");
                        String computerAssetTag = kb.next();

                        System.out.println("Please enter student id: ");
                        String student_id = kb.next();

                        Booking newBooking = new Booking(booking_time, returnTime,computerType,computerAssetTag,student_id);
                        bookingDB.addBooking(newBooking);
                        bookingDB.printBookings();
                        break;


                    case FIND_AND_EDIT_STUDENT:
                        System.out.println("Please Enter the ID od the student you wish to find e.g 1000,1001 etc : "); //TODO add loop for menu error
                        int id = kb.nextInt();
                        Student selectedStudent =  studentDB.findStudentByID(id);
                        System.out.println(selectedStudent);

                        editingStudentMenu();

                        int choice = kb.nextInt();

                        if(choice == 1)
                        {
                            System.out.println("Please enter new name for the selected student");
                            String newName = kb.next();
                            selectedStudent.setName(newName);
                        }
                        else if(choice == 2)
                        {
                            selectedStudent.setName("");
                        }
                        else if(choice == 3)
                        {
                            System.out.println("Please enter new email for the selected student");
                            String newEmail = kb.next();
                            selectedStudent.setEmail(newEmail);
                        }
                        else if(choice == 4)
                        {
                            selectedStudent.setEmail("");
                        }
                        else if(choice == 5)
                        {
                            System.out.println("Please enter new telephone for the selected student");
                            String newTelephone = kb.next();
                            selectedStudent.setTelephone(newTelephone);
                        }
                        else if(choice == 6)
                        {
                            selectedStudent.setTelephone("");
                        }
                        else if(choice == 7)
                        {
                            studentDB.removeStudentById(id);
                            System.out.println("Student removed from database");
                            System.out.println(studentDB);
                        }
                        else if(choice == 8)
                        {

                            //quit
                        }
                        break;

                    case PRINT_ALL_STUDENTS:
                        studentDB.printStudents();
                        break;


                    case PRINT_ALL_BOOKINGS:
                        bookingDB.printBookings();
                        break;



                    case AVERAGE_LENGTH_OF_BOOKINGS:
//                        printAVGLength()  use sort
                        break;



                    case PRINT_STATISTICS:
//                        printStatistics()
                        break;



                    case QUIT:
                        bookingDB.saveBookingsToFile();
                        studentDB.saveStudentsToFile();
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

