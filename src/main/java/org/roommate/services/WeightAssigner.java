package org.roommate.services;

import org.roommate.models.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WeightAssigner
{
    private List<Person> participators;
    private Map<Person, Double> weights;


    /**
     Input all the list of the Person, and assign no weight.
     * @param persons
     */
    WeightAssigner (List<? extends  Person> persons)
    {

        weights = persons.stream().collect(Collectors.toMap(p -> p, p -> 0.0));
    }

    public void assignSameWeightToAll()
    {
        weights.replaceAll((key, value) -> 1.0);
    }

    public void setWeightToPerson(Person person, double weight)
    {
        weights.replace(person, weight);
    }


    public void assignWeightAt(Person person, double weight)
    {
        weights.put(person, weight);
    }

    public Map<Person, Double> getWeights()
    {
        return weights;
    }

    public Map<Person, Double> getAssignedSameWeightToAll()
    {
        assignSameWeightToAll();
        return getWeights();
    }
}
