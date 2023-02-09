
import org.example.*;
        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.junit.jupiter.api.Assertions.assertThrows;


class PersonTest {
    Person person;
    @BeforeEach
    void setup(String name, int age, String gender){
        assert name != null && name.length() <= 50;
        assert age >= 0 && age <= 120;
        assert gender.equals("Male") || gender.equals("Female");

        person = new Person(name,age,gender);
    }

    @AfterEach
    void shutdown(){
        person = null;
    }


    @Test
    void agePerGenderTest1(){



    }







}