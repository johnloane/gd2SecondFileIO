package com.dkit.gd2.johnloane;

import java.util.ArrayList;

public class Person
{
    private String name;
    private String address;
    private int age;
    private ArrayList<Integer> interests;

    public Person(String name, String address, int age, ArrayList<Integer> interests)
    {
        this.name = name;
        this.address = address;
        this.age = age;
        this.interests = interests;
    }

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public int getAge()
    {
        return age;
    }

    public ArrayList<Integer> getInterests()
    {
        return interests;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", interests=" + interests +
                '}';
    }
}
