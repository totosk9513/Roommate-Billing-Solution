package org.roommate.services;

import org.roommate.models.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatWeightAssigner implements IWeightAssigner
{

    @Override
    public Map<Person, Double> assignWeights(List<? extends Person> participators)
    {
        Map<Person, Double> weights = participators.stream().collect(Collectors.toMap(p -> p, p -> 1.0));
        return weights;
    }
}
