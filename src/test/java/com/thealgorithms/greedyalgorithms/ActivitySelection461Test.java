package com.thealgorithms.greedyalgorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import org.junit.jupiter.api;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection461Test {

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Tag("valid")
	@Test
	public void testCompletelyOverlappingActivities() {

		int[] startTimes = { 1, 1, 1 };
		int[] endTimes = { 2, 2, 2 };

		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);

		assertThat(result).isNotNull();

		assertThat(result.size()).isEqualTo(1);
		assertThat(result.get(0)).isEqualTo(0);
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Tag("boundary")
	@Test
	public void testSingleActivity() {

		int[] startTimes = { 1 };
		int[] endTimes = { 2 };

		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);

		assertThat(result).isNotNull();
		assertThat(result.size()).isEqualTo(1);
		assertThat(result.get(0)).isEqualTo(0);
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Tag("valid")
	@Test
	public void testNonOverlappingActivities() {

		int[] startTimes = { 1, 3, 5 };
		int[] endTimes = { 2, 4, 6 };

		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);

		assertThat(result).isNotNull();

		assertThat(result.size()).isEqualTo(3);
		assertThat(result.get(0)).isEqualTo(0);
		assertThat(result.get(1)).isEqualTo(1);
		assertThat(result.get(2)).isEqualTo(2);
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Tag("valid")
	@Test
	public void testPartialOverlappingActivities() {

		int[] startTimes = { 1, 2, 3 };
		int[] endTimes = { 3, 4, 5 };

		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);

		assertThat(result).isNotNull();
		assertThat(result.size()).isEqualTo(2);
		assertThat(result.get(0)).isEqualTo(0);
		assertThat(result.get(1)).isEqualTo(2);
	}

	/*
	 * ROOST_METHOD_HASH=activitySelection_cce0da1981
	 * ROOST_METHOD_SIG_HASH=activitySelection_79d2670611
	 *
	 */@Tag("invalid")
	@Test
	public void testEmptyActivities() {

		int[] startTimes = {};
		int[] endTimes = {};

		ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);

		assertThat(result).isNotNull();

		assertThat(result.size()).isEqualTo(0);
	}

}