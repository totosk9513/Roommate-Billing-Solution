package org.project.models;

import org.project.enums.Gender;

import java.util.Date;
import java.util.List;

public class Tenant extends Person
{
    private boolean isCurrentTenant;
    private List<Date> absentDate;

    private List<Bill> expenses;
    private List<Debt> debts;
    private List<Credits> credits;

    //TODO: Need to implement Debt and Credits classes.

    private String venmoID;
    private String zellID;

    public Tenant(String name, Gender gender)
    {
        super(name, gender);
    }


}
