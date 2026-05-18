package org.roommate.services;

import org.roommate.models.Person;

import java.util.List;
import java.util.Map;

public interface IWeightAssigner
{
    Map<Person, Double> assignWeights(List<? extends Person> participators);

}
