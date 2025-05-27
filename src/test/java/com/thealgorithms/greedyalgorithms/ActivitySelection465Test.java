package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Assertions.assertEquals;

public class ActivitySelection465Test {

	/*
	 * ROOST_METHOD_HASH=activitySelection_0bfed95984
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("valid")
	public void activitySelectionWithSomeActivitiesHavingSameEndTime() {
		ActivitySelection activitySelection = new ActivitySelection();
		int[] startTimes = { 1, 3, 5, 7, 9 };
		int[] endTimes = { 2, 4, 6, 6, 10 };
		ArrayList<Integer> expectedOutput = new ArrayList<>();
		expectedOutput.add(0);
		expectedOutput.add(1);
		expectedOutput.add(3);
		expectedOutput.add(4);
		ArrayList<Integer> actualOutput = activitySelection.activitySelection(startTimes, endTimes);
		assertEquals(expectedOutput, actualOutput, "The actual output does not match expected output");
	}

}