package com.dkit.gd2.johnloane;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void getAverageAge()
    {
        ArrayList<Integer> interests = new ArrayList<>();
        interests.add(1);
        interests.add(2);
        interests.add(3);
        interests.add(4);
        Person stephen = new Person("Stephen", "Drogheda", 20, interests);
        Person zak = new Person("Zak", "Mornington", 18, interests);
        Person berk = new Person("Berk", "Dundalk", 30, interests);
        Person oisín = new Person("Oisín", "Drogheda", 8, interests);
        ArrayList<Person> people = new ArrayList<>();
        people.add(stephen);
        people.add(zak);
        people.add(berk);
        people.add(oisín);
        assertEquals(19.0, App.getAverageAge(people), 0.1);
    }
}
