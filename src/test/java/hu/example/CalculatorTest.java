package hu.example;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("Tests starting...");
    }

    @Test
    void addTwoNumbers() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("2 + 3 eredménye 5")
    void additionWorks() {
         assertEquals(5, calculator.add(2,3));

    }

    @Test
    void substractionWorks(){
        assertEquals(7, calculator.substract(10,3));
    }

    @Test
    void multiplicationWorks(){
        assertEquals(20, calculator.multimply(4,5));
    }

    @Test
    void divisionByZeroThrowsException(){
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10, 0)
        );

        assertEquals("Division by zero", exception.getMessage());
    }

    @Test
    void severalAssertions() {
        int result = 10;

        assertAll(
                () -> assertTrue(result > 0),
                () -> assertTrue(result < 100),
                () -> assertEquals(10, result)
        );
    }

    @Test
    @Disabled("A funkció nincs implementálva")
    void unfinishedTest(){
        // még nincs kész
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "3, 4, 7",
            "-1, 1, 0",
            "10, 20, 30"
    })
    void additionWorks(
            int a,
            int b,
            int expected) {

        assertEquals(
                expected,
                calculator.add(a, b)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 100})
    void positiveNumbersArePositive(int number) {

        assertTrue(number > 0);
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("Tests finished.");
    }
}