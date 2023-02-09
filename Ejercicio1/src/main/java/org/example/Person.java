package org.example;

import java.util.List;

// @author Antonio Navajas Ortega
public class Person {

    private final String name;
    private final int age;
    private final String gender;

    public Person(String name,int age,String gender)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String name()
    {
        return name;
    }
    public int age(){
        return age;
    }
    public String gender()
    {
        return gender;
    }

    public double[] averageAgePerGender(List<Person> persons)
    {
        double [] res = new double[2];
        double sumMale = 0;
        double sumFemale = 0;
        double cont1 = 0;
        double cont2 = 0;
        for (Person p : persons) {
            if (p.gender.equals("Male")) {
                sumMale += p.age;
                cont1++;
            } else {
                sumFemale += p.age;
                cont2++;
            }
        }
        res[0] = sumMale / cont1;
        res[1] = sumFemale / cont2;
        return res;
    }

}
