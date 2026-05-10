package org.roommate.services;

import org.roommate.models.Bill;
import org.roommate.models.Person;

import java.util.List;

public class UtilityCalcService extends CalculatorService
{

    public UtilityCalcService(String name , Bill bill)
    {
        super(name);
    }

    public UtilityCalcService(Bill bill)
    {
        super(bill);
    }


    @Override
    public void calc()
    {

    }
}
