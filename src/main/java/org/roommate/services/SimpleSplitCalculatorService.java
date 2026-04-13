package org.roommate.services;

import org.roommate.models.Bill;
import org.roommate.models.IOU;
import org.roommate.models.Person;

/**
 * This bill calculator simply just divide a bill by number of participators.
 */
public class SimpleSplitCalculatorService extends CalculatorService
{
//    private String name;
    private Bill utilBill;


    public SimpleSplitCalculatorService(String name)
    {
        super(name);
    }

    @Override
    public void calc()
    {
        int numOfParticipators = participators.size();
        double split = utilBill.getGrandTotalPrice() / numOfParticipators;
        for (Person p : participators)
        {
            if (!p.equals(payer))
            {
                p.addDebt(new IOU(p, payer, split, name + " : REASON"));
            }
        }
    }

    //    public void


}
