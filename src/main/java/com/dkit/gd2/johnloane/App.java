package com.dkit.gd2.johnloane;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        //First need to store multiple people
        //I'm not sure how many people are going to be in the file
        ArrayList<Person> people = new ArrayList<>();
        readPeopleFromFile(people);
        System.out.println(Arrays.toString(people.toArray()));
        writePeopleToFile(people);
        System.out.println(getAverageAge(people));
    }

    private static void readPeopleFromFile(ArrayList<Person> people)
    {
        //Should use try with resources
        //Should also use BufferedReader
        try(Scanner peopleFile = new Scanner(new BufferedReader(new FileReader("people.txt"))))
        {
            while(peopleFile.hasNextLine())
            {
                String input = peopleFile.nextLine();
                String[] data = input.split(",");
                String name = data[0];
                String address = data[1];
                int age = Integer.parseInt(data[2]);
                ArrayList<Integer> tempList = new ArrayList<>();
                for(int i=3;i<data.length;i++)
                {
                    tempList.add(Integer.parseInt(data[i]));
                }
                people.add(new Person(name, address, age, tempList));
            }
        }
        catch(FileNotFoundException fne)
        {
            System.out.println("Could not open people.txt");
        }
    }

    private static void writePeopleToFile(ArrayList<Person> people)
    {
        //Try with resources
        //BufferedWriter
        try(BufferedWriter personsFile = new BufferedWriter(new FileWriter("persons.txt")))
        {
            for(Person person : people)
            {
                personsFile.write(person.getName()+","+person.getAddress()+","+person.getAge());
                for(int i=0; i < person.getInterests().size();i++)
                {
                    personsFile.write("," + person.getInterests().get(i));
                }
                personsFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println(ioe.getMessage());
        }
    }

    protected static double getAverageAge(ArrayList<Person> people)
    {
        int ageSum = 0;
        for(Person person : people)
        {
            ageSum += person.getAge();
        }
        return (double)ageSum/people.size();
    }
}
