package org.roommate.models;

import org.roommate.enums.Gender;

import java.util.ArrayList;
import java.util.List;

public abstract class Person
{
    protected String name;
    protected Gender gender;
    protected List<IOU> IOUs = new ArrayList<>();

    private List<Bill> expenses;
    private final List<IOU> iouList = new ArrayList<>();

    private Person()
    {
        this.name = null;
        this.gender = Gender.OTHERS;
    }

    public Person(String name)
    {
        this.name = name;
//        this.gender = gender;
    }

    public Person(String name, Gender gender)
    {
        this.name = name;
        this.gender = gender;
    }


    public List<IOU> getDebts()
    {
        List<IOU> debts = new ArrayList<>();
        for (IOU iou : IOUs)
        {
            if (iou.getDebtor().equals(this))
            {
                debts.add(iou);
            }
        }
        return debts;
    }

    public List<IOU> getCredits()
    {
        List<IOU> debts = new ArrayList<>();
        for (IOU iou : IOUs)
        {
            if (iou.getCreditor().equals(this))
            {
                debts.add(iou);
            }
        }
        return debts;
    }

    //Get IOUS of what this class person owns to person of parameter
    public List<IOU> getMyDebtsOfPerson(Person person)
    {
        List<IOU> myDebts = new ArrayList<>();
        for (IOU iou : IOUs)
        {
            if (iou.getCreditor().equals(person))
            {
                myDebts.add(iou);
            }
        }
        return myDebts;
    }


    //Get IOUS of person of parameter owns to this class person
    public List<IOU> getMyCreditsOfPerson(Person person)
    {
        List<IOU> myCredits = new ArrayList<>();
        for (IOU iou : IOUs)
        {
            if (iou.getDebtor().equals(person))
            {
                myCredits.add(iou);
            }
        }
        return myCredits;
    }

    public double getTotalPriceOfMyDebtsOfPerson(Person person)
    {
        List<IOU> myDebts = getMyDebtsOfPerson(person);
        return myDebts.stream().mapToDouble(IOU::getAmount).sum();
    }

    public double getTotalPriceOfMyCreditsOfPerson(Person person)
    {
        List<IOU> myDebts = getMyCreditsOfPerson(person);
        return myDebts.stream().mapToDouble(IOU::getAmount).sum();
    }

    public List<IOU> getIouList()
    {
        return IOUs;
    }

    public void addIOU(IOU IOU) {
        this.IOUs.add(IOU);
    }

    public double getTotalDebtAmount()
    {
        return iouList.stream()
                .filter(iou -> iou.getDebtor().equals(this))
                .mapToDouble(IOU::getAmount)
                .sum();
    }

    // 내가 받아야 할 총액 계산
    public double getTotalCreditAmount()
    {
        return iouList.stream()
                .filter(iou -> iou.getCreditor().equals(this))
                .mapToDouble(IOU::getAmount)
                .sum();
    }

    public String getName()
    {
        return this.name;
    }

    public void changeName(String newName)
    {
        this.name = newName;
        //TODO: add a log that tells this person has changed the name.
    }

    public void setGender (Gender gender)
    {
        this.gender = gender;
    }

    public Gender getGender()
    {
        return this.gender;
    }

}
