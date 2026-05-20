package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testCreateRandomArray() {
        int[] arr = Main.createRandomArray();

        assertNotNull(arr);
        assertTrue(arr.length >= 1 && arr.length <= 10);

        for (int n : arr) {
            assertTrue(n >= -100 && n <= 100);
        }
    }

    @Test
    void testCreateManualArray() {
        int[] arr = Main.createManualArray("1, 5, -3, 10");

        assertArrayEquals(new int[]{1, 5, -3, 10}, arr);
    }

    @Test
    void testAddNumber() {
        int[] arr = {1, 2, 3};
        int[] result = Main.addNumber(arr, 5);

        assertArrayEquals(new int[]{1, 2, 3, 5}, result);
    }

    @Test
    void testFindMax() {
        int[] arr = {3, 9, 1, 7};
        assertEquals(9, Main.findMax(arr));
    }

    @Test
    void testFindMin() {
        int[] arr = {3, 9, 1, 7};
        assertEquals(1, Main.findMin(arr));
    }

    @Test
    void testRemoveNumber() {
        int[] arr = {1, 2, 3, 2, 4};
        int[] result = Main.removeNumber(arr, 2);

        assertArrayEquals(new int[]{1, 3, 4}, result);
    }

    @Test
    void testDeleteArray() {
        int[] arr = Main.deleteArray();
        assertNull(arr);
    }
}
