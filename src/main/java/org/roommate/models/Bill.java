package org.roommate.models;

import java.time.LocalDateTime;
import java.util.List;

//TODO: interface나 abstract의 형태로 만들지 정해보기. 원래 Abstract으로 만들었음.
public class Bill
{
    private String name;
    private double grandTotalPrice;
//    private double subTotal;
//    private List<BillFee> billFees ;
    private Person payer;
    private List<? extends Person> participators;
//    private LocalDateTime dueDate;
    private LocalDateTime paidDate;
//    private List<Item> items;

    public Bill(String name, Double cost, Person payer)
    {
        this.name = name;
        this.grandTotalPrice = cost;
        this.payer = payer;
        this.paidDate = LocalDateTime.now();
    }

    public Bill(String name, Double cost, Person payer, List<? extends Person> participators)
    {
        this.name = name;
        this.grandTotalPrice = cost;
        this.payer = payer;
        this.participators = participators;
        this.paidDate = LocalDateTime.now();
    }

    public Bill(String name, Double cost, Person payer, List<? extends Person> participators, LocalDateTime dateTime)
    {
        this.name = name;
        this.grandTotalPrice = cost;
        this.payer = payer;
        this.participators = participators;
        this.paidDate = dateTime;
    }

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

    public List<? extends Person> getParticipators()
    {
        return participators;
    }

    public void setParticipators(List<Person> participators)
    {
        this.participators = participators;
    }

//    public LocalDateTime getDueDate()
//    {
//        return dueDate;
//    }
//
//    public void setDueDate(LocalDateTime dueDate)
//    {
//        this.dueDate = dueDate;
//    }

    public LocalDateTime getPaidDate()
    {
        return paidDate;
    }

    public void setPaidDate(LocalDateTime paidDate)
    {
        this.paidDate = paidDate;
    }
}
