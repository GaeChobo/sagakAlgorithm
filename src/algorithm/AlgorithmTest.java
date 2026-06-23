package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class AlgorithmTest {

    @Test
    void testFindMiddleTwoDigits() {
        assertEquals(12, Algorithm.findMiddleTwoDigits(5));
        assertEquals(21, Algorithm.findMiddleTwoDigits(8));
    }

    @Test
    void testFindMiddleTwoDigitsInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Algorithm.findMiddleTwoDigits(2));
        assertThrows(IllegalArgumentException.class, () -> Algorithm.findMiddleTwoDigits(101));
    }

    @Test
    void testGenerateNextSequence() {
        assertEquals("11", Algorithm.generateNextSequence("1"));
        assertEquals("21", Algorithm.generateNextSequence("11"));
        assertEquals("1211", Algorithm.generateNextSequence("21"));
    }
}
