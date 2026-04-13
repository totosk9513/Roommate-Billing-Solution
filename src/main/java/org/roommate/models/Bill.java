package org.roommate.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public abstract class Bill
{
    private String name;
    private double grandTotalPrice;
    private Person payer;
    private List<Person> beneficiaries;
    private LocalDateTime dueDate;
    private LocalDateTime paidDate;

//    private List<IOU> relatedIOUs; //FIXME: SSOT 원칙에 어긋날 수도 있음. 나중에 ACID DB 쓸 때 의미 없을 수 있음.

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

    public LocalDateTime getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate)
    {
        this.dueDate = dueDate;
    }

    public LocalDateTime getPaidDate()
    {
        return paidDate;
    }

    public void setPaidDate(LocalDateTime paidDate)
    {
        this.paidDate = paidDate;
    }
}
