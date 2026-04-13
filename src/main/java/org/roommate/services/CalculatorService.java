package org.roommate.services;

import org.roommate.models.Person;

import java.util.List;

public abstract class CalculatorService
{
    protected String name;
    protected Person payer;
    protected List<? extends Person> participators;

    public CalculatorService(String name)
    {
        this.name = name;
    }

    public abstract void calc();

}
