package org.project.models;

import java.util.Date;
import java.util.List;

public abstract class Bill
{
    private String name;
    private double grandTotalPrice;
    private Person payer; //FIXME: Solid 원칙에 어긋날 수도 있음
    private List<Person> beneficiaries;
    private Date dueDate;
    private Date paidDate;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getGrandTotalPrice()
    {
        return grandTotalPrice;
    }

    public void setGrandTotalPrice(double grandTotalPrice)
    {
        this.grandTotalPrice = grandTotalPrice;
    }

    public Person getPayer()
    {
        return payer;
    }

    public void setPayer(Person payer)
    {
        this.payer = payer;
    }

    public List<Person> getBeneficiaries()
    {
        return beneficiaries;
    }

    public void setBeneficiaries(List<Person> beneficiaries)
    {
        this.beneficiaries = beneficiaries;
    }

    public Date getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
    }

    public Date getPaidDate()
    {
        return paidDate;
    }

    public void setPaidDate(Date paidDate)
    {
        this.paidDate = paidDate;
    }
}
