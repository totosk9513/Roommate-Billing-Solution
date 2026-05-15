package org.roommate.services;

import org.roommate.models.Bill;
import org.roommate.models.Person;
import org.roommate.models.Tenant;
import org.roommate.models.UtilityBill;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.List;

//Utility Calc Service for "Pay as you go utilities"
//EX: elec, water, cooking gas.
//Wifi, Heating gas, AC elec are not usually considered "Pay as you go", but fixed consumption.
public class UtilityCalcService extends CalculatorService
{
    private UtilityBill utilityBill;

    public UtilityCalcService(String name, Bill bill)
    {
        super(name);
    }

    public UtilityCalcService(UtilityBill utilityBill)
    {
        super(utilityBill);
        this.utilityBill = utilityBill;
    }


    //TODO: need to finish this part.
    @Override
    public void calc()
    {
        LocalDate startDate = utilityBill.getStartingDate();
        LocalDate endDate = utilityBill.getEndingDate();
        long daysOfBillingCycle = ChronoUnit.DAYS.between(startDate, endDate);

        //1. get weights for participators.
//        for (Tenant t : participators)
//        {
//            //Get affective days == weights
//
//        }

        //2. Apply the weights of participators, and create/add IOUs.

    }
}
