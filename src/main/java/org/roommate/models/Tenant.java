package org.roommate.models;

import org.roommate.enums.Gender;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Tenant extends Person
{
    private boolean isCurrentTenant;
    private List<LocalDate> absentDate;

//    private List<Bill> expenses;
//    private List<IOU> IOUS;
//    private List<Credits> credits;

    //TODO: Need to implement IOU and Credits classes.

    private String venmoID;
    private String zellID;

    public Tenant(String name)
    {
        super(name);
    }

    public Tenant(String name, Gender gender)
    {
        super(name, gender);
    }


}
