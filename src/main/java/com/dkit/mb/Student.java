package com.dkit.mb;

import java.util.Arrays;
import java.util.Scanner;

public class Student
{


    private String name;
    private String ID;
    private String email;
    private String telephone;
    private String[] pcs_on_loan;

    public Student(String name, String ID, String email, String telephone, String[] pcs_on_loan)
    {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.telephone = telephone;
        this.pcs_on_loan = pcs_on_loan;
    }

    public String[] getPcs_on_loan()
    {
        return pcs_on_loan;
    }

    public void setPcs_on_loan(String[] pcs_on_loan)
    {
        this.pcs_on_loan = pcs_on_loan;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", pcs_on_loan=" + Arrays.toString(pcs_on_loan) +
                '}';
    }
}
