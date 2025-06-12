package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection40Test {

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("valid")
	public void verifyEmptyLists() {

		int[] startTimes = {};

		int[] endTimes = {};
		ArrayList<Integer> actualResult = ActivitySelection.activitySelection(startTimes, endTimes);

		ArrayList<Integer> expectedResult = new ArrayList<>();
		assertEquals(expectedResult, actualResult);
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("valid")
	public void checkFullyOverlappingActivities() {

		int[] startTimes = { 1, 1, 1 };

		int[] endTimes = { 2, 2, 2 };
		ArrayList<Integer> actualResult = ActivitySelection.activitySelection(startTimes, endTimes);
		ArrayList<Integer> expectedResult = new ArrayList<>();

		expectedResult.add(0);
		assertEquals(expectedResult, actualResult);
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("valid")
	public void validatePartialOverlap() {

		int[] startTimes = { 1, 2, 3 };
		int[] endTimes = { 3, 5, 8 };
		ArrayList<Integer> actualResult = ActivitySelection.activitySelection(startTimes, endTimes);
		ArrayList<Integer> expectedResult = new ArrayList<>();

		expectedResult.add(0);

		expectedResult.add(2);
		assertEquals(expectedResult, actualResult);
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("boundary")
	public void testLateStartEarlyFinish() {

		int[] startTimes = { 5, 1, 8 };

		int[] endTimes = { 6, 2, 9 };
		ArrayList<Integer> actualResult = ActivitySelection.activitySelection(startTimes, endTimes);
		ArrayList<Integer> expectedResult = new ArrayList<>();

		expectedResult.add(1);

		expectedResult.add(0);

		expectedResult.add(2);
		assertEquals(expectedResult, actualResult);
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("boundary")
	public void handleZeroTimeActivities() {

		int[] startTimes = { 0, 0, 0 };

		int[] endTimes = { 0, 2, 5 };
		ArrayList<Integer> actualResult = ActivitySelection.activitySelection(startTimes, endTimes);
		ArrayList<Integer> expectedResult = new ArrayList<>();

		expectedResult.add(0);

		expectedResult.add(1);

		expectedResult.add(2);
		assertEquals(expectedResult, actualResult);
	}

}