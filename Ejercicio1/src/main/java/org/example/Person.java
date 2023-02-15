package org.example;

import java.util.List;

// @author Antonio Navajas Ortega
public class Person {

    private final String name;
    private final int age;
    private final String gender;

    public Person(String name,int age,String gender)
    {
        if(name == null || name.length() > 50)
        {
            throw new NameException("Name field cannot be null or bigger than 50 characters.");
        }
        if(age < 0 || age > 120)
        {
            throw new AgeException("Age field cannot be negative or bigger than 120");
        }
        if(!gender.equals("Male") && !gender.equals("Female")) // En este caso no vamos a ignorar mayúsculas o minúsculas
        {
            throw new GenderException("Gender field must be either Male or Female.");
        }

        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName()
    {
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getGender()
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
        // Si no tenemos Male o Female para evaluar, uso el valor -1.
        res[0] = -1;
        res[1] = -1;

        if(persons.size() != 0)
        {
            for (Person p : persons) {
                if(p != null) // Si vale null lo saltamos
                {
                    if (p.gender.equals("Male")) {
                        sumMale += p.age;
                        cont1++;
                    } else if (p.gender.equals("Female")) {
                        sumFemale += p.age;
                        cont2++;
                    } else {
                        // Ignoramos si gender vale otra cosa
                    }
                }

            }
        }

        if(cont1 > 0)
        {
            res[0] = sumMale / cont1;
        }
        if(cont2 > 0)
        {
            res[1] = sumFemale / cont2;
        }
        return res;
    }

}
