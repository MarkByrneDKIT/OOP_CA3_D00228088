package com.dkit.mb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDB
{
    private static Scanner keyboard = new Scanner(System.in);
    private ArrayList<Student> studentList;

    public StudentDB() {

        this.studentList = new ArrayList<>();
    }



    public void printStudents()
    {
        for(int i = 0; i < studentList.size(); i++)
        {
            System.out.println(studentList.get(i));
        }
    }

    public Student findStudentByID(int id)
    {
        for(Student s : studentList) {
            if (s.getID().equals(id))
                return s;

        }
        return null;
    }

    public void addStudent(Student student)
    {
        studentList.add(student);
    }

    public void removeStudentById(int id)
    {
        Student student = findStudentByID(id);      //TODO check for null id
        if(student != null)
        {
            studentList.remove(student);
        }
    }



    protected void loadStudentsFromFile()
    {
        System.out.println("Reading student DB from file...");

        try {
            Scanner studentsFile = new Scanner(new File("Students.txt"));

            while (studentsFile.hasNext())
            {

                String fname = studentsFile.next();
                String lname = studentsFile.next();
                String name = fname + " " + lname;
                String id = studentsFile.next();
                String email= studentsFile.next();
                String telephone= studentsFile.next();

                String pcs_on_loan = studentsFile.nextLine();


                String[] pcs = pcs_on_loan.split("\\s+");
                for (int i = 0; i < pcs.length; i++)
                {
                    pcs[i] = pcs[i].replaceAll("[^\\w]", "");
                }


                System.out.println("Name: " + name + " ID: " + id + " EMAIL: " + email + " TELEPHONE: " + " PCS ON LOAN: " + pcs);

                studentList.add( new Student(name, id, email, telephone, pcs));

            }
            System.out.println("All students loaded");
            studentsFile.close();
            System.out.println("All Students: " + studentList); // print them all

        }
        catch (IOException e)
        {
            System.out.println("IOException thrown in loadStudentsFromFile() "+e.getMessage());
        }

    }


    public void saveStudentsToFile()
    {
        try(BufferedWriter studentsFile = new BufferedWriter(new FileWriter("newStudents.txt") ))
        {
            for(Student student : studentList)
            {
               studentsFile.write(student.getName() +" "+student.getID()+" "+student.getEmail() + " " + student.getTelephone() + " " + student.getPcs_on_loan());
                studentsFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println("Could not save students.");
        }
    }



}


