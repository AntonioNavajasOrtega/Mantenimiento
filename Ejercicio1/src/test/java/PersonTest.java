
import org.example.*;
        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



class PersonTest {
    Person person;
    @BeforeEach
    void setup(){
        person = new Person("Antonio",20,"Male");
    }

    @AfterEach
    void shutdown(){
        person = null;
    }

    @Test
    void testName()
    {
        String expectedName = "Antonio";
        assertEquals(expectedName,person.getName());
    }

    @Test
    void testAge()
    {
        int expectedAge = 20;
        assertEquals(expectedAge,person.getAge());
    }

    @Test
    void testGender()
    {
        String expectedGender = "Male";
        assertEquals(expectedGender,person.getGender());
    }

    @Test
    void illegalName()
    {
        assertThrows(NameException.class, () -> new Person(null,30,"Male"));
        assertThrows(NameException.class, () -> new Person("AbcdefghijklmnñopqrstuvwxyzAbcdefghijklmnñopqrstuvwxyz",30,"Male"));
    }

    @Test
    void illegalAge()
    {
        assertThrows(AgeException.class, () -> new Person("Javier",-1,"Male"));
        assertThrows(AgeException.class, () -> new Person("Javier",123,"Male"));
    }

    @Test
    void illegalGender()
    {
        assertThrows(GenderException.class, () -> new Person("Javier",30,"Malea"));
    }

    @Test
    void agePerGenderTest1Male0Female()
    {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Javier",30,"Male"));
        double [] expectedRes = {30,-1};
        assertArrayEquals(expectedRes,person.averageAgePerGender(persons));

    }

    @Test
    void agePerGenderTest0Male1Female()
    {
            List<Person> persons = new ArrayList<>();
            persons.add(new Person("Nerea",30,"Female"));
            double [] expectedRes = {-1,30};
        assertArrayEquals(expectedRes,person.averageAgePerGender(persons));
    }

    @Test
    void agePerGenderTest0Male0Female()
    {
                List<Person> persons = new ArrayList<>();
                double [] expectedRes = {-1,-1};
        assertArrayEquals(expectedRes,person.averageAgePerGender(persons));
    }

    @Test
    void agePerGenderTestMaleFemale()
    {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Nerea",30,"Female"));
        persons.add(new Person("Javier",30,"Male"));
        persons.add(new Person("María",47,"Female"));
        persons.add(new Person("Alejandro",28,"Male"));
        persons.add(new Person("Adriana",18,"Female"));
        persons.add(new Person("Carlos",52,"Male"));
        persons.add(new Person("Marta",35,"Female"));
        persons.add(new Person("Sergio",49,"Male"));
        double [] expectedRes = {39.75,32.5};
        assertArrayEquals(expectedRes,person.averageAgePerGender(persons));
    }
    @Test
    void agePerGenderTestMaleFemaleWithNull()
    {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Nerea",30,"Female"));
        persons.add(new Person("Javier",30,"Male"));
        persons.add(new Person("María",47,"Female"));
        persons.add(null);
        persons.add(new Person("Alejandro",28,"Male"));
        persons.add(new Person("Adriana",18,"Female"));
        persons.add(new Person("Carlos",52,"Male"));
        persons.add(new Person("Marta",35,"Female"));
        persons.add(new Person("Sergio",49,"Male"));
        persons.add(null);
        double [] expectedRes = {39.75,32.5};
        assertArrayEquals(expectedRes,person.averageAgePerGender(persons));
    }



}