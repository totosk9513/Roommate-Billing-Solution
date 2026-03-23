package org.project.models;

import java.util.Date;

public class UtilityBill extends Bill
{
    private Date startingDate;
    private Date endingDate;
    private boolean isInclusive_starting;
    private boolean isInclusive_ending;

    public UtilityBill()
    {

    }

    public UtilityBill(Date startingDate, Date endingDate, boolean isInclusive_starting, boolean isInclusive_ending)
    {
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.isInclusive_starting = isInclusive_starting;
        this.isInclusive_ending = isInclusive_ending;
    }

    public Date getStartingDate()
    {
        return startingDate;
    }

    public void setStartingDate(Date startingDate)
    {
        this.startingDate = startingDate;
    }

    public Date getEndingDate()
    {
        return endingDate;
    }

    public void setEndingDate(Date endingDate)
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
