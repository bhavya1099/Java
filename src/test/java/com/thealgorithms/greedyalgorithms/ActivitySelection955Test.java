package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection955Test {

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("valid")
	public void activitySelectionWithNonOverlappingActivities() {
		int[] startTimes = { 1, 3, 5, 7 };
		int[] endTimes = { 2, 4, 6, 8 };
		ArrayList<Integer> expectedOutput = new ArrayList<>();
		expectedOutput.add(0);
		expectedOutput.add(1);
		expectedOutput.add(2);
		expectedOutput.add(3);
		ArrayList<Integer> actualOutput = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(expectedOutput, actualOutput, "The acutal output does not match expected output");
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("valid")
	public void activitySelectionWithOverlappingActivities() {
		int[] startTimes = { 1, 3, 0, 5, 8, 5 };
		int[] endTimes = { 2, 4, 6, 7, 9, 10 };
		ArrayList<Integer> expectedOutput = new ArrayList<>();
		expectedOutput.add(0);
		expectedOutput.add(1);
		expectedOutput.add(3);
		expectedOutput.add(4);
		ArrayList<Integer> actualOutput = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(expectedOutput, actualOutput, "The acutal output does not match expected output");
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("boundary")
	public void activitySelectionWithEmptyArrays() {
		int[] startTimes = {};
		int[] endTimes = {};
		ArrayList<Integer> expectedOutput = new ArrayList<>();
		ArrayList<Integer> actualOutput = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(expectedOutput, actualOutput, "The acutal output does not match expected output");
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("invalid")
	public void activitySelectionWithNullInput() {
		int[] startTimes = null;
		int[] endTimes = null;
		ArrayList<Integer> actualOutput = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(null, actualOutput, "The acutal output does not match expected output");
	}

}