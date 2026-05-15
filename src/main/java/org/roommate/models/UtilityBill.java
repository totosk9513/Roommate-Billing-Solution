package org.roommate.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class UtilityBill extends Bill
{
    private LocalDate startingDate;
    private LocalDate endingDate;
    private boolean isInclusive_starting;
    private boolean isInclusive_ending;

    private LocalDateTime dueDate;

//    public UtilityBill()
//    {
//
//    }
    public UtilityBill(String name, Person payer, List<? extends Person> participators, double cost, LocalDate startingDate, LocalDate endingDate)
    {
        super(name, cost, payer, participators);
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.isInclusive_starting = true;
        this.isInclusive_ending = false;
    }

    public UtilityBill(String name, Person payer, List<? extends Person> participators, double cost, LocalDate startingDate, LocalDate endingDate, boolean isInclusive_starting, boolean isInclusive_ending)
    {
        super(name, cost, payer, participators);
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.isInclusive_starting = isInclusive_starting;
        this.isInclusive_ending = isInclusive_ending;
    }

    public LocalDate getStartingDate()
    {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate)
    {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate()
    {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate)
    {
        this.endingDate = endingDate;
    }

    public boolean isInclusive_starting()
    {
        return isInclusive_starting;
    }

    public void setInclusive_starting(boolean inclusive_starting)
    {
        isInclusive_starting = inclusive_starting;
    }

    public boolean isInclusive_ending()
    {
        return isInclusive_ending;
    }

    public void setInclusive_ending(boolean inclusive_ending)
    {
        isInclusive_ending = inclusive_ending;
    }
}
