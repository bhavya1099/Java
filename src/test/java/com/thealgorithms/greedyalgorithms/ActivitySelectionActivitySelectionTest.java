
package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import java.util.Comparator;

public class ActivitySelectionActivitySelectionTest {

	@Test
	@Tag("valid")
	public void testEmptyActivitySelection() {
		int[] startTimes = new int[0];
		int[] endTimes = new int[0];
		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);
		assertTrue(result.isEmpty(), "Result should be empty as no activities are provided");
	}

	@Test
	@Tag("valid")
	public void testOverlappingActivities() {
		int[] startTimes = { 1, 3, 0, 5, 8, 5 };
		int[] endTimes = { 2, 4, 6, 7, 9, 9 };
		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(Arrays.asList(0, 1, 3, 4), result, "Result should only include non-overlapping activities");
	}

	@Test
	@Tag("valid")
	public void testUnsortedActivityTimes() {
		int[] startTimes = { 5, 8, 5, 1, 3, 0 };
		int[] endTimes = { 7, 9, 9, 2, 4, 6 };
		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(Arrays.asList(3, 4, 0, 1), result, "Result should be sorted according to end times");
	}

	@Test
	@Tag("invalid")
	public void testNegativeActivityTimes() {
		int[] startTimes = { 1, -3, 0, 5, 8, 5 };
		int[] endTimes = { 2, 4, 6, -7, 9, 9 };
		// TODO: Process should be updated to handle negative values
	}

}