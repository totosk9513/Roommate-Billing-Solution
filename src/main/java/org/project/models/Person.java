package org.project.models;

import org.project.enums.Gender;

public abstract class Person
{
    private String name;
    private Gender gender;

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
