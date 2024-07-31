
package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelectionActivitySelectionTest {

	@Test
    @Tag('valid')
    public void testValidStartAndEndTimes() {
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] endTimes = {2, 4, 6, 7, 9, 9};
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 3, 4));
        ArrayList<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
        assertEquals(expected, actual);
    }

	@Test
	@Tag
	('invalid')public void testEmptyStartAndEndTimes() {
		int[] startTimes = {};
		int[] endTimes = {};
		ArrayList<Integer> expected = new ArrayList<>();
		ArrayList<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(expected, actual);
	}

	@Test
	@Tag
	('valid')public void testNonOverlappingStartAndEndTimes() {
		int[] startTimes = { 1, 3, 5, 7 };
		int[] endTimes = { 2, 4, 6, 8 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
		ArrayList<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(expected, actual);
	}

	@Test
	@Tag
	('invalid')public void testNullStartAndEndTimes() {
		int[] startTimes = null;
		int[] endTimes = null;
		assertThrows(NullPointerException.class, () -> ActivitySelection.activitySelection(startTimes, endTimes));
	}

	@Test
	@Tag
	('invalid')public void testDifferentLengthStartAndEndTimes() {
		int[] startTimes = { 1, 2, 3 };
		int[] endTimes = { 2, 3 };
		assertThrows(IllegalArgumentException.class, () -> ActivitySelection.activitySelection(startTimes, endTimes));
	}

}