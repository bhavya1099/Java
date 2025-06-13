package com.thealgorithms.greedyalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api;

public class ActivitySelection78Test {

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("valid")
	public void testOverlappingActivities() {
		int[] startTimes = { 1, 1, 1 };
		int[] endTimes = { 3, 3, 3 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0));
		ArrayList<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(expected, actual, "Only one activity should be selected.");
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("valid")
	public void testIdenticalActivities() {
		int[] startTimes = { 1, 1, 1 };
		int[] endTimes = { 2, 2, 2 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0));
		ArrayList<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(expected, actual, "Only one activity should be selected when start and end times are identical.");
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("invalid")
	public void testInvalidActivityTimes() {
		int[] startTimes = { 3, 5, 7 };
		int[] endTimes = { 2, 4, 6 };
		ArrayList<Integer> expected = new ArrayList<>();
		ArrayList<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(expected, actual, "Activities with start times greater than end times should not be selected.");
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("boundary")
	public void testEmptyInput() {
		int[] startTimes = {};
		int[] endTimes = {};
		ArrayList<Integer> expected = new ArrayList<>();
		ArrayList<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(expected, actual, "Empty input should result in an empty output.");
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("valid")
	public void testNonOverlappingWithDifferentDurations() {
		int[] startTimes = { 1, 3, 6 };
		int[] endTimes = { 2, 5, 8 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2));
		ArrayList<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(expected, actual,
				"All activities should be selected when intervals are strictly non-overlapping.");
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("boundary")
	public void testOutputOrderOnPartialOverlap() {
		int[] startTimes = { 1, 2, 3 };
		int[] endTimes = { 3, 5, 4 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 2));
		ArrayList<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(expected, actual, "Selected activities should follow the input order when partially overlapping.");
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("valid")
	public void testFullySelectableActivities() {
		int[] startTimes = { 1, 2, 3, 4 };
		int[] endTimes = { 2, 3, 4, 5 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
		ArrayList<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(expected, actual,
				"All activities should be selected when intervals are contiguous and non-overlapping.");
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Test
	@Tag("boundary")
	public void testSubsetIntervals() {
		int[] startTimes = { 1, 2, 3 };
		int[] endTimes = { 10, 4, 5 };
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2));
		ArrayList<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
		assertEquals(expected, actual,
				"Shorter and compatible activities should be selected over overlapping longer ones.");
	}

}