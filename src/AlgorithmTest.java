import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class AlgorithmTest {
	
    @Test
    void testFindMiddleTwoDigits() {
        assertEquals(12, Algorithm.findMiddleTwoDigits(5));
        assertEquals(21, Algorithm.findMiddleTwoDigits(8));
        // Add more test cases here
    }

    @Test
    void testFindMiddleTwoDigitsInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Algorithm.findMiddleTwoDigits(2));
        assertThrows(IllegalArgumentException.class, () -> Algorithm.findMiddleTwoDigits(101));
        // Add more test cases for invalid inputs here
    }

    @Test
    void testGenerateNextSequence() {
        assertEquals("11", Algorithm.generateNextSequence("1"));
        assertEquals("21", Algorithm.generateNextSequence("11"));
        assertEquals("1211", Algorithm.generateNextSequence("21"));
        // Add more test cases for generateNextSequence here
    }

}
