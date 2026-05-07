package org.roommate.services;

import org.roommate.models.Bill;
import org.roommate.models.Person;

import java.util.Map;

public class WeightedCalculatorService extends CalculatorService
{
    private Map<Person, Double> weights;

    public WeightedCalculatorService(Bill bill)
    {
        super(bill);
        //if weight is not inputed, set all weights to same one (1)
        for (Person person : bill.getParticipators())
        {
//            this.weights.put(person, 1.0);
            WeightAssigner wa = new WeightAssigner(bill.getParticipators());
            weights = wa.getAssignedSameWeightToAll();
        }
    }

    //User can set weights on each participators.
    public WeightedCalculatorService(Bill bill, Map<Person, Double> weights) {
        super(bill);
        this.weights = weights;
    }

//    public WeightedCalculatorService

    //TODO: need to implement this part.
    @Override
    public void calc()
    {
         //get totalUnits from the weights
        //get unitCost, totalBill/totalUnits
        //assign bills based on units
    }

    //unit test
    public static void main(String[] args)
    {

    }
}
