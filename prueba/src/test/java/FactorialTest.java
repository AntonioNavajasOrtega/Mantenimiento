import org.example.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class FactorialTest {
    Factorial factorial;
    @BeforeEach
    void setup(){
        factorial = new Factorial();
    }

    @AfterEach
    void shutdown(){
        factorial = null;
    }


    @Test
    void factorialOfZeroIsOne(){

        int obtainedValue = factorial.compute(0);
        int expectedValue = 1;

        assertEquals(expectedValue,obtainedValue);
    }
    @Test
    void factorialOfOneIsOne(){

        int obtainedValue = factorial.compute(1);
        int expectedValue = 1;

        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    void factorialOfTwoisTwo(){

        int obtainedValue = factorial.compute(2);
        int expectedValue = 2;

        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    void factorialOfThreeIsThree(){

        int obtainedValue = factorial.compute(3);
        int expectedValue = 6;

        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    void factorialOfFiveIsFive(){

        int obtainedValue = factorial.compute(5);
        int expectedValue = 120;

        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    void factorialOfMinusIs(){
        assertThrows(RuntimeException.class, () -> factorial.compute(-1));
    }


}