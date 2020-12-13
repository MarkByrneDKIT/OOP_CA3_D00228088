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
                        System.out.println("Student added");

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
                        System.out.println("Please Enter the ID of the student you wish to find e.g 1000,1001 etc : "); //TODO add loop for menu error
                        String id = kb.next();
                        Student selectedStudent =  studentDB.findStudentByID(id);
                        System.out.println(selectedStudent);

                        editingStudentMenu();

                        int choice = kb.nextInt();
                        while(choice !=8) {
                            if (choice == 1)
                            {
                                System.out.println("Please enter new first name for the selected student");
                                String newName1 = kb.next();
                                System.out.println("Please enter new surname for the selected student");
                                String newName2 = kb.next();
                                String newName = newName1 + " " +newName2;
                                selectedStudent.setName(newName);
                                System.out.println(selectedStudent);
                            }
                            else if (choice == 2)
                            {
                                selectedStudent.setName("");
                            }
                            else if (choice == 3)
                            {
                                System.out.println("Please enter new email for the selected student");
                                String newEmail = kb.next();
                                selectedStudent.setEmail(newEmail);
                            }
                            else if (choice == 4)
                            {
                                selectedStudent.setEmail("");
                            }
                            else if (choice == 5)
                            {
                                System.out.println("Please enter new telephone for the selected student");
                                String newTelephone = kb.next();
                                selectedStudent.setTelephone(newTelephone);
                            }
                            else if (choice == 6)
                            {
                                selectedStudent.setTelephone("");
                            }
                            else if (choice == 7)
                            {
                                studentDB.removeStudentById(id);
                                System.out.println("Student removed from database");
                                studentDB.printStudents();
                            }
                            editingStudentMenu();
                            choice = kb.nextInt();

                        }
                        break;

                    case FIND_AND_EDIT_BOOKING:
                        System.out.println("Please Enter the ID of the Booking you wish to find e.g 1000,1001 etc : "); //TODO add loop for menu error
                        int b_id = kb.nextInt();
                        Booking selectedBooking =  bookingDB.findBookingByID(b_id);
                        System.out.println(selectedBooking);

                        editingBookingsMenu();

                        int bChoice = kb.nextInt();
                        while(bChoice != 14) {
                            if (bChoice == 1)
                            {
                                System.out.println("Please enter the new Booking ID: ");
                                int newBID = kb.nextInt();
                                selectedBooking.setBooking_id(newBID);
                            }
                            else if (bChoice == 2)
                            {
                                selectedBooking.setBooking_id(0);
                            }
                            else if (bChoice == 3)
                            {
                                System.out.println("Please select new booking time (YYYY-MM-DD):");
                                String newTime = kb.next();
                                LocalDate newBookingTime = LocalDate.parse(newTime);
                                selectedBooking.setBooking_time(newBookingTime);
                            }
                            else if (bChoice == 4)
                            {
                                selectedBooking.setBooking_time(null);
                            }
                            else if (bChoice == 5)
                            {
                                System.out.println("Please select new return time (YYYY-MM-DD): ");
                                String newTime2 = kb.next();
                                LocalDate newReturnTime = LocalDate.parse(newTime2);
                                selectedBooking.setReturn_time(newReturnTime);
                            }
                            else if (bChoice == 6)
                            {
                                selectedBooking.setReturn_time(null);
                            }
                            else if (bChoice == 7)
                            {
                                System.out.println("Pleas select new computer type: ");
                                String pcType = kb.next();
                                selectedBooking.setComputer_type(pcType);
                            }
                            else if (bChoice == 8)
                            {
                                selectedBooking.setComputer_type(null);
                            }
                            else if (bChoice == 9)
                            {
                                System.out.println("Please enter new computer asset tag: ");
                                String newAssetTag = kb.nextLine();
                                selectedBooking.setComputer_asset_tag(newAssetTag);
                            }
                            else if (bChoice == 10)
                            {
                                selectedBooking.setComputer_asset_tag(null);
                            }
                            else if (bChoice == 11)
                            {
                                System.out.println("Please enter new student id: ");
                                String newSId = kb.next();
                                selectedBooking.setStudent_id(newSId);
                            }
                            else if (bChoice == 12)
                            {
                                selectedBooking.setStudent_id(null);
                            }
                            else if (bChoice == 13)
                            {
                                bookingDB.removeBookingById(b_id);
                                System.out.println("Booking removed from database");
                                bookingDB.printBookings();
                            }
                            editingBookingsMenu();
                            bChoice = kb.nextInt();
                        }
                        break;



                    case PRINT_ALL_STUDENTS:
                        studentDB.printStudents();
                        break;


                    case PRINT_ALL_BOOKINGS:
                        bookingDB.printBookings();
                        break;



                    case AVERAGE_LENGTH_OF_BOOKINGS:
                        bookingDB.getAvgBookingLength();

                        break;



                    case PRINT_STATISTICS:
                        bookingDB.getStatistics();
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
        System.out.println(("\t4. Find and Edit Booking"));
        System.out.println(("\t5. Print all Students"));
        System.out.println(("\t6. Print all Bookings"));
        System.out.println(("\t7. Print Average Length of Bookings"));
        System.out.println(("\t8. Print Statistics"));
        System.out.println(("\t9. Quit"));
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
    private static void editingBookingsMenu()
    {
        System.out.println("-----Editing Menu for Booking-----");
        System.out.println("\t1. Edit Booking ID");
        System.out.println("\t2. Delete Booking ID");
        System.out.println("\t3. Edit Booking Time");
        System.out.println("\t4. Delete Booking Time");
        System.out.println("\t5. Edit Return Time");
        System.out.println("\t6. Delete Return Time");
        System.out.println("\t7. Edit Computer Type");
        System.out.println("\t8. Delete Computer Type");
        System.out.println("\t9. Edit Computer Asset Tag");
        System.out.println("\t10. Delete Computer Asset Tag");
        System.out.println("\t11. Edit Student ID");
        System.out.println("\t12. Delete Student ID");
        System.out.println("\t13. Remove Booking from System");
        System.out.println("\t14. Quit");
        System.out.print(("\n Selection ->"));
        System.out.println();
    }

}

