package org.roommate.models;

import org.roommate.enums.Gender;

import java.util.ArrayList;
import java.util.List;

public abstract class Person
{
    protected String name;
    protected Gender gender;
    protected List<IOU> IOUS = new ArrayList<>();

    private List<Bill> expenses;
    private final List<IOU> iouList = new ArrayList<>();

    private Person()
    {
        this.name = null;
        this.gender = Gender.OTHERS;
    }

    public Person(String name, Gender gender)
    {
        this.name = name;
        this.gender = gender;
    }

    public void addDebt(IOU IOU) {
        this.IOUS.add(IOU);
    }

    private String getName()
    {
        return this.name;
    }

    private void changeName(String newName)
    {
        this.name = newName;
        //TODO: add a log that tells this person has changed the name.
    }

    private void setGender (Gender gender)
    {
        this.gender = gender;
    }

    private Gender getGender()
    {
        return this.gender;
    }
}
